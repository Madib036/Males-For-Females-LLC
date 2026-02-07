{
  "types": {
    "EIP712Domain": [
      {
        "name": "name",
        "type": "string"
      },
      {
        "name": "version",
        "type": "string"
      },
      {
        "name": "chainId",
        "type": "uint256"
      },
      {
        "name": "salt",
        "type": "bytes32"
      }
    ],
    "VerificationClaim": [
      {
        "name": "fid",
        "type": "uint256"
      },
      {
        "name": "address",
        "type": "address"
      },
      {
        "name": "blockHash",
        "type": "bytes32"
      },
      {
        "name": "network",
        "type": "uint8"
      }
    ]
  },
  "primaryType": "VerificationClaim",
  "domain": {
    "name": "Farcaster Verify Ethereum Address",
    "version": "2.0.0",
    "salt": "0xf2d857f4a3edcb9b78b4d503bfe733db1e3f6cdc2b7971ee739626c97e86a558",
    "chainId": 1
  },
  "message": {
    "fid": "2528070",
    "address": "0x6178baf1b087e54a6438fecc10c316579db14128",
    "blockHash": "0x021800cce292e1fdcae9d130acd7190a182920ad71b43e7df4e424f1cc41583d",
    "network": 1,
    "protocol": 0
  }
}