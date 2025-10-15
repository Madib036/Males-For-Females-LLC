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

package com.google.android.gms.samples.pay.util;

import android.content.Context;

import com.google.android.gms.samples.pay.Constants;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Contains helper static methods for dealing with the Payments API.
 *
 * <p>Many of the parameters used in the code are optional and are set here merely to call out their
 * existence. Please consult the documentation to learn more and feel free to remove ones not
 * relevant to your implementation.
 */
public class PaymentsUtil {

  /**
   * Create a Google Pay API base request object with properties used in all requests.
   *
   * @return Google Pay API base request object.
   * @throws JSONException if the object is malformed.
   */
  private static JSONObject getBaseRequest() throws JSONException {
    return new JSONObject()
        .put("apiVersion", 2)
        .put("apiVersionMinor", 0);
  }

  /**
   * Creates an instance of {@link PaymentsClient} for use in an {@link Context} using the
   * environment and theme set in {@link Constants}.
   *
   * @param context is the caller's context.
   */
  public static PaymentsClient createPaymentsClient(Context context) {
    Wallet.WalletOptions walletOptions =
        new Wallet.WalletOptions.Builder().setEnvironment(Constants.PAYMENTS_ENVIRONMENT).build();
    return Wallet.getPaymentsClient(context, walletOptions);
  }

  /**
   * Gateway Integration: Identify your gateway and your app's gateway merchant identifier.
   *
   * <p>The Google Pay API response will return an encrypted payment method capable of being charged
   * by a supported gateway after payer authorization.
   *
   * <p>TODO: Check with your gateway on the parameters to pass and modify them in Constants.java.
   *
   * @return Payment data tokenization for the CARD payment method.
   * @throws JSONException if the object is malformed.
   * @see <a href=
   * "https://developers.google.com/pay/api/android/reference/object#PaymentMethodTokenizationSpecification">PaymentMethodTokenizationSpecification</a>
   */
  private static JSONObject getGatewayTokenizationSpecification() throws JSONException {
    return new JSONObject()
        .put("type", "PAYMENT_GATEWAY")
        .put("parameters", new JSONObject()
            .put("gateway", "example")
            .put("gatewayMerchantId", "exampleGatewayMerchantId")
        );
  }

  /**
   * {@code DIRECT} Integration: Decrypt a response directly on your servers. This configuration has
   * additional data security requirements from Google and additional PCI DSS compliance complexity.
   *
   * <p>Please refer to the documentation for more information about {@code DIRECT} integration. The
   * type of integration you use depends on your payment processor.
   *
   * @return Payment data tokenization for the CARD payment method.
   * @throws JSONException if the object is malformed.
   * @see <a
   * href="https://developers.google.com/pay/api/android/reference/object#PaymentMethodTokenizationSpecification">PaymentMethodTokenizationSpecification</a>
   */
  private static JSONObject getDirectTokenizationSpecification()
      throws JSONException, RuntimeException {
    return new JSONObject()
        .put("type", "DIRECT")
        .put("parameters", new JSONObject(Constants.DIRECT_TOKENIZATION_PARAMETERS));
  }

  /**
   * Card networks supported by your app and your gateway.
   *
   * <p>TODO: Confirm card networks supported by your app and gateway & update in Constants.java.
   *
   * @return Allowed card networks
   * @see <a
   * href="https://developers.google.com/pay/api/android/reference/object#CardParameters">CardParameters</a>
   */
  private static JSONArray getAllowedCardNetworks() {
    return new JSONArray(Constants.SUPPORTED_NETWORKS);
  }

  /**
   * Card authentication methods supported by your app and your gateway.
   *
   * <p>TODO: Confirm your processor supports Android device tokens on your supported card networks
   * and make updates in Constants.java.
   *
   * @return Allowed card authentication methods.
   * @see <a
   * href="https://developers.google.com/pay/api/android/reference/object#CardParameters">CardParameters</a>
   */
  private static JSONArray getAllowedCardAuthMethods() {
    return new JSONArray(Constants.SUPPORTED_METHODS);
  }

  /**
   * Describe your app's support for the CARD payment method.
   *
   * <p>The provided properties are applicable to both an IsReadyToPayRequest and a
   * PaymentDataRequest.
   *
   * @return A CARD PaymentMethod object describing accepted cards.
   * @throws JSONException if the object is malformed.
   * @see <a
   * href="https://developers.google.com/pay/api/android/reference/object#PaymentMethod">PaymentMethod</a>
   */
  private static JSONObject getBaseCardPaymentMethod() throws JSONException {
    return new JSONObject()
        .put("type", "CARD")
        .put("parameters", new JSONObject()
            .put("allowedAuthMethods", getAllowedCardAuthMethods())
            .put("allowedCardNetworks", getAllowedCardNetworks())
            .put("billingAddressRequired", true)
            .put("billingAddressParameters", new JSONObject()
                .put("format", "FULL")
            )
        );
  }

  /**
   * Describe the expected returned payment data for the CARD payment method
   *
   * @return A CARD PaymentMethod describing accepted cards and optional fields.
   * @throws JSONException if the object is malformed.
   * @see <a
   * href="https://developers.google.com/pay/api/android/reference/object#PaymentMethod">PaymentMethod</a>
   */
  private static JSONObject getCardPaymentMethod() throws JSONException {
    return getBaseCardPaymentMethod()
        .put("tokenizationSpecification", getGatewayTokenizationSpecification());
  }

  /**
   * Return a collection of payment methods allowed to complete the operation with Google Pay.
   *
   * @return A JSONArray object with the list of payment methods.
   * @throws JSONException if the JSON object is malformed.
   */
  public static JSONArray getAllowedPaymentMethods() throws JSONException {
    return new JSONArray().put(getCardPaymentMethod());
  }

  /**
   * An object describing accepted forms of payment by your app, used to determine a viewer's
   * readiness to pay.
   *
   * @return API version and payment methods supported by the app.
   * @see <a
   * href="https://developers.google.com/pay/api/android/reference/object#IsReadyToPayRequest">IsReadyToPayRequest</a>
   */
  public static JSONObject getIsReadyToPayRequest() {
    try {
      return getBaseRequest()
          .put("allowedPaymentMethods", new JSONArray().put(getBaseCardPaymentMethod()));
    } catch (JSONException e) {
      return null;
    }
  }

  /**
   * Provide Google Pay API with a payment amount, currency, and amount status.
   *
   * @return information about the requested payment.
   * @throws JSONException if the object is malformed.
   * @see <a
   * href="https://developers.google.com/pay/api/android/reference/object#TransactionInfo">TransactionInfo</a>
   */
  private static JSONObject getTransactionInfo(String price) throws JSONException {
    return new JSONObject()
        .put("totalPrice", price)
        .put("totalPriceStatus", "FINAL")
        .put("countryCode", Constants.COUNTRY_CODE)
        .put("currencyCode", Constants.CURRENCY_CODE)
        .put("checkoutOption", "COMPLETE_IMMEDIATE_PURCHASE");
  }

  /**
   * Information about the merchant requesting payment information
   *
   * @return Information about the merchant.
   * @throws JSONException if the object is malformed.
   * @see <a
   * href="https://developers.google.com/pay/api/android/reference/object#MerchantInfo">MerchantInfo</a>
   */
  private static JSONObject getMerchantInfo() throws JSONException {
    return new JSONObject().put("merchantName", "Example Merchant");
  }

  /**
   * An object describing information requested in a Google Pay payment sheet
   *
   * @return Payment data expected by your app.
   * @see <a
   * href="https://developers.google.com/pay/api/android/reference/object#PaymentDataRequest">PaymentDataRequest</a>
   */
  public static JSONObject getPaymentDataRequest(String priceLabel) {
    try {
      return PaymentsUtil.getBaseRequest()
          .put("allowedPaymentMethods", getAllowedPaymentMethods())
          .put("transactionInfo", getTransactionInfo(priceLabel))
          .put("merchantInfo", getMerchantInfo())
          .put("shippingAddressRequired", true)
          .put("shippingAddressParameters", new JSONObject()
              .put("phoneNumberRequired", false)
              .put("allowedCountryCodes", new JSONArray(Constants.SHIPPING_SUPPORTED_COUNTRIES))
          );

    } catch (JSONException e) {
      return null;
    }
  }
}
