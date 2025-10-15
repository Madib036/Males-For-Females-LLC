/*
 * Copyright 2024 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gms.samples.pay.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.samples.pay.R;
import com.google.android.gms.samples.pay.databinding.ActivityCheckoutBinding;
import com.google.android.gms.samples.pay.util.PaymentsUtil;
import com.google.android.gms.samples.pay.viewmodel.CheckoutViewModel;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.button.ButtonOptions;
import com.google.android.gms.wallet.button.PayButton;
import com.google.android.gms.wallet.contract.TaskResultContracts.GetPaymentDataResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

/**
 * Checkout implementation for the app
 */
public class CheckoutActivity extends AppCompatActivity {

  private CheckoutViewModel model;

  private PayButton googlePayButton;

  private final ActivityResultLauncher<Task<PaymentData>> paymentDataLauncher =
      registerForActivityResult(new GetPaymentDataResult(), result -> {
        int statusCode = result.getStatus().getStatusCode();
        switch (statusCode) {
          case CommonStatusCodes.SUCCESS:
            handlePaymentSuccess(result.getResult());
            break;
          //case CommonStatusCodes.CANCELED: The user canceled
          case CommonStatusCodes.DEVELOPER_ERROR:
            handleError(statusCode, result.getStatus().getStatusMessage());
            break;
          default:
            handleError(statusCode, "Unexpected non API" +
                " exception when trying to deliver the task result to an activity!");
            break;
        }
      });

  /**
   * Initialize the Google Pay API on creation of the activity
   *
   * @see Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initializeUi();

    // Check Google Pay availability
    model = new ViewModelProvider(this).get(CheckoutViewModel.class);
    model.canUseGooglePay.observe(this, this::setGooglePayAvailable);
  }

  private void initializeUi() {

    // Use view binding to access the UI elements
    ActivityCheckoutBinding layoutBinding = ActivityCheckoutBinding.inflate(getLayoutInflater());
    setContentView(layoutBinding.getRoot());

    // The Google Pay button is a layout file – take the root view
    googlePayButton = layoutBinding.googlePayButton;
    try {
      googlePayButton.initialize(
          ButtonOptions.newBuilder()
              .setAllowedPaymentMethods(PaymentsUtil.getAllowedPaymentMethods().toString()).build()
      );
      googlePayButton.setOnClickListener(this::requestPayment);
    } catch (JSONException e) {
      // Keep Google Pay button hidden (consider logging this to your app analytics service)
    }
  }

  /**
   * If isReadyToPay returned {@code true}, show the button and hide the "checking" text.
   * Otherwise, notify the user that Google Pay is not available. Please adjust to fit in with
   * your current user flow. You are not required to explicitly let the user know if isReadyToPay
   * returns {@code false}.
   *
   * @param available isReadyToPay API response.
   */
  private void setGooglePayAvailable(boolean available) {
    if (available) {
      googlePayButton.setVisibility(View.VISIBLE);
    } else {
      Toast.makeText(this, R.string.google_pay_status_unavailable, Toast.LENGTH_LONG).show();
    }
  }

  public void requestPayment(View view) {
    // The price provided to the API should include taxes and shipping.
    final Task<PaymentData> task = model.getLoadPaymentDataTask("50.2");
    task.addOnCompleteListener(paymentDataLauncher::launch);
  }

  /**
   * PaymentData response object contains the payment information, as well as any additional
   * requested information, such as billing and shipping address.
   *
   * @param paymentData A response object returned by Google after a payer approves payment.
   * @see <a href="https://developers.google.com/pay/api/android/reference/
   * object#PaymentData">PaymentData</a>
   */
  private void handlePaymentSuccess(PaymentData paymentData) {
    final String paymentInfo = paymentData.toJson();

    try {
      JSONObject paymentMethodData = new JSONObject(paymentInfo).getJSONObject("paymentMethodData");
      // If the gateway is set to "example", no payment information is returned - instead, the
      // token will only consist of "examplePaymentMethodToken".

      final JSONObject info = paymentMethodData.getJSONObject("info");
      final String billingName = info.getJSONObject("billingAddress").getString("name");
      Toast.makeText(
          this, getString(R.string.payments_show_name, billingName),
          Toast.LENGTH_LONG).show();

      // Logging token string.
      Log.d("Google Pay token", paymentMethodData
          .getJSONObject("tokenizationData")
          .getString("token"));

      startActivity(new Intent(this, CheckoutSuccessActivity.class));

    } catch (JSONException e) {
      Log.e("handlePaymentSuccess", "Error: " + e);
    }
  }

  /**
   * At this stage, the user has already seen a popup informing them an error occurred. Normally,
   * only logging is required.
   *
   * @param statusCode holds the value of any constant from CommonStatusCode or one of the
   *                   WalletConstants.ERROR_CODE_* constants.
   * @see <a href="https://developers.google.com/android/reference/com/google/android/gms/wallet/
   * WalletConstants#constant-summary">Wallet Constants Library</a>
   */
  private void handleError(int statusCode, @Nullable String message) {
    Log.e("loadPaymentData failed",
        String.format(Locale.getDefault(), "Error code: %d, Message: %s", statusCode, message));
  }
}
