// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/governance/TimelockController.sol";

contract DopamineTimelock is TimelockController {
    constructor(
        address[] memory proposers,
        address[] memory executors,
        uint256 minDelay
    )
        TimelockController(minDelay, proposers, executors, msg.sender)
    {}
}