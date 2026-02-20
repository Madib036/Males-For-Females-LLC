// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/access/Ownable.sol";
import "@openzeppelin/contracts/token/ERC20/IERC20.sol";

contract DopamineTreasury is Ownable {
    IERC20 public dopeToken;
    uint256 public stakerShare = 40;
    uint256 public treasuryShare = 40;
    uint256 public buybackShare = 20;

    mapping(address => uint256) public staked;

    event RevenueDistributed(uint256 total, uint256 stakers, uint256 treasury, uint256 buyback);

    constructor(IERC20 _dopeToken) {
        dopeToken = _dopeToken;
    }

    function stake(uint256 amount) external {
        require(amount > 0, "Cannot stake 0");
        staked[msg.sender] += amount;
        dopeToken.transferFrom(msg.sender, address(this), amount);
    }

    function unstake(uint256 amount) external {
        require(staked[msg.sender] >= amount, "Insufficient stake");
        staked[msg.sender] -= amount;
        dopeToken.transfer(msg.sender, amount);
    }

    function distributeRevenue(uint256 totalRevenue) external onlyOwner {
        uint256 stakersAmount = (totalRevenue * stakerShare) / 100;
        uint256 treasuryAmount = (totalRevenue * treasuryShare) / 100;
        uint256 buybackAmount = (totalRevenue * buybackShare) / 100;

        // Treasury portion remains in contract
        // Staker rewards: proportional distribution
        uint256 totalStaked = totalStakedTokens();
        for (uint i = 0; i < stakersList.length; i++) {
            address staker = stakersList[i];
            uint256 reward = (stakers[staker] * stakersAmount) / totalStaked;
            dopeToken.transfer(staker, reward);
        }

        // Buyback logic (sent to multisig for buybacks)
        dopeToken.transfer(owner(), buybackAmount);

        emit RevenueDistributed(totalRevenue, stakersAmount, treasuryAmount, buybackAmount);
    }

    address[] public stakersList;

    function totalStakedTokens() public view returns (uint256 total) {
        for (uint i = 0; i < stakersList.length; i++) {
            total += staked[stakersList[i]];
        }
    }
}