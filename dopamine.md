// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/token/ERC20/extensions/ERC20Votes.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract Dopamine is ERC20Votes, Ownable {

    uint256 public constant MAX_SUPPLY = 1_000_000_000 * 10 ** 18;

    constructor()
        ERC20("Dopamine", "DOPE")
        ERC20Permit("Dopamine")
    {
        _mint(msg.sender, MAX_SUPPLY);
    }

    function _afterTokenTransfer(address from, address to, uint256 amount)
        internal
        override(ERC20Votes)
    {
        super._afterTokenTransfer(from, to, amount);
    }

    function _mint(address to, uint256 amount)
        internal
        override(ERC20Votes)
    {
        super._mint(to, amount);
    }

    function _burn(address account, uint256 amount)
        internal
        override(ERC20Votes)
    {
        super._burn(account, amount);
    