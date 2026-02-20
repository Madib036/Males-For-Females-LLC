    ┌───────────────────────────────┐
        │       ERC20 Standard           │
        │-------------------------------│
        │ - transfer                    │
        │ - approve                     │
        │ - allowance                   │
        │ - balanceOf                   │
        └─────────────┬─────────────────┘
                      │
                      │ inherits
                      ▼
        ┌───────────────────────────────┐
        │         ERC20Votes             │
        │-------------------------------│
        │ - vote delegation             │
        │ - checkpoints (historical)    │
        │ - on-chain governance voting  │
        └─────────────┬─────────────────┘
                      │
                      │ inherits
                      ▼
        ┌───────────────────────────────┐
        │        ERC20Permit             │
        │-------------------------------│
        │ - gasless approvals via       │
        │   signed messages (EIP‑2612) │
        └─────────────┬─────────────────┘
                      │
                      ▼
        ┌───────────────────────────────┐
        │        Dopamine Token          │
        │-------------------------------│
        │ Name: Dopamine                 │
        │ Symbol: DOPE                   │
        │ Max Supply: 1,000,000,000      │
        │ Decimals: 18                   │
        │ Initial Mint: deployer wallet  │
        └─────────────┬─────────────────┘
                      │
                      │ linked off-chain
                      ▼
        ┌───────────────────────────────┐
        │      Off-Chain Metadata        │
        │-------------------------------│
        │ - Name / Symbol               │
        │ - Description                 │
        │ - Image (IPFS)                │
        │ - Attributes (Type, Mood)     │
        └───────────────────────────────