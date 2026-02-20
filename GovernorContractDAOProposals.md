// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/governance/Governor.sol";
import "@openzeppelin/contracts/governance/extensions/GovernorVotes.sol";
import "@openzeppelin/contracts/governance/extensions/GovernorTimelockControl.sol";

contract DopamineGovernor is Governor, GovernorVotes, GovernorTimelockControl {
    uint256 public votingDelayBlocks = 1; // ~1 block
    uint256 public votingPeriodBlocks = 40320; // ~1 week (assuming 15s blocks)
    uint256 public proposalThresholdTokens = 10_000 * 10**18; // min 10k DOPE to propose
    uint256 public quorumPercentage = 4; // 4% quorum

    constructor(ERC20Votes _token, TimelockController _timelock)
        Governor("DopamineGovernor")
        GovernorVotes(_token)
        GovernorTimelockControl(_timelock)
    {}

    function votingDelay() public view override returns (uint256) {
        return votingDelayBlocks;
    }

    function votingPeriod() public view override returns (uint256) {
        return votingPeriodBlocks;
    }

    function proposalThreshold() public view override returns (uint256) {
        return proposalThresholdTokens;
    }

    function quorum(uint256 blockNumber) public view override returns (uint256) {
        return (token.getPastTotalSupply(blockNumber) * quorumPercentage) / 100;
    }

    // Required overrides
    function state(uint256 proposalId)
        public
        view
        override(Governor, GovernorTimelockControl)
        returns (ProposalState)
    {
        return super.state(proposalId);
    }

    function propose(address[] memory targets, uint256[] memory values, bytes[] memory calldatas, string memory description)
        public
        override(Governor, GovernorTimelockControl)
        returns (uint256)
    {
        return super.propose(targets, values, calldatas, description);
    }

    function _execute(uint256 proposalId, address[] memory targets, uint256[] memory values, bytes[] memory calldatas, bytes32 descriptionHash)
        internal
        override(Governor, GovernorTimelockControl)
    {
        super._execute(proposalId, targets, values, calldatas, descriptionHash);
    }

    function _cancel(uint256 proposalId)
        internal
        override(Governor, GovernorTimelockControl)
        returns (uint256)
    {
        return super._cancel(proposalId);
    }

    function supportsInterface(bytes4 interfaceId)
        public
        view
        override(Governor, GovernorTimelockControl)
        returns (bool)
    {
        return super.supportsInterface(interfaceId);
    }
}