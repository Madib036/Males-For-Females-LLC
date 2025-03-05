# OSPO Discussions

![Octocats Collaborating](https://octodex.github.com/images/collabocats.jpg)

## Introduction

This was a public repository for discussions relating to Open Source Program Offices on GitHub.

# Primer Primitives

This repo contains values for color, spacing, and typography primitives for use with [Primer][primer], GitHub's design system.

## Install

This repository is distributed on [npm][npm]. After [installing npm][install-npm], you can install `@primer/primitives` with this command.

$ npm install --save @primer/primitives


## Usage

Primitive data is served in several formats from the `dist/` folder:

* `dist/scss` contains [SCSS][scss] files that define CSS variables to be imported into other SCSS files
* `dist/json` contains JSON files for each set of primitives
* `dist/js` contains CommonJS-style JavaScript modules for each set of primitives, as well as an index file that loads all of the primitives for all primitive types; you can access this via `require('@primer/primitives')`. The JavaScript modules also include TypeScript typings files for use in TypeScript projects.

## License

[MIT](./LICENSE) &copy; [GitHub](https://github.com/)

[primer]: https://github.com/primer/primer
[npm]: https://www.npmjs.com/
[install-npm]: https://docs.npmjs.com/getting-started/installing-node
[scss]: https://sass-lang.com/

# Git integration for Visual Studio Code

**Notice:** This extension is bundled with Visual Studio Code. It can be disabled but not uninstalled.

## Features

See [Git support in VS Code](https://code.visualstudio.com/docs/editor/versioncontrol#_git-support) to learn about the features of this extension.

## API

The Git extension exposes an API, reachable by any other extension.

1. Copy `src/api/git.d.ts` to your extension's sources;
2. Include `git.d.ts` in your extension's compilation.
3. Get a hold of the API with the following snippet: 
`ts const gitExtension = vscode.extensions.getExtensi <GitExtension ('vscode.git')`

# Welcome to your organization's demo respository

This code repository (or "repo") is designed to demonstrate the best GitHub has to offer with the least amount of noise.
The repo includes an `index.html` file (so it can render a web page), two GitHub Actions workflows, and a CSS stylesheet dependency.
This workflow uses actions that are not certified by GitHub. They are provided by a third-party and are governed by separate terms of service, privacy policy, and support
documentation. This workflow lets you generate SLSA provenance file for your project. The generation satisfies level 3 for the provenance requirements - see https://slsa.dev/spec/v0.1/requirements
The project is an initiative of the OpenSSF (openssf.org) and is developed at https://github.com/slsa-framework/slsa-github-generator. The provenance file can be verified using https://github.com/slsa-framework/slsa-verifier. 

# For more information about SLSA and how it improves the supply-chain, visit slsa.dev.

    `name: SLSA generic generator
     on:
    workflow_dispatch:
    release:
    types: [created]
     jobs:
    build:
    runs-on: ubuntu-latest
    outputs:
    digests: ${{ steps.hash.outputs.digests }}
     steps:
    uses: actions/checkout@v3`

# Step 1: Build your artifacts.

     `name: Build artifacts
        run: |`

These are some amazing artifacts.

    echo "artifact1" > artifact1
    echo "artifact2" > artifact2

# ProcessStep 2: Add a step to generate the provenance subjects as shown below. Update the sha256 sum arguments to include all binaries that you generate provenance for.

      `name: Generate subject for provenance
        id: hash
        run: |
          set -euo pipefail`

List the artifacts the provenance will refer to.
          
    `files=$(ls artifact*)`

Generate the subjects (base64 encoded).
      
    `echo "hashes=$(sha256sum $files | base64 -w0)" >> "${GITHUB_OUTPUT}"
     provenance:
    needs: [build]
    permissions:
      actions: read`

To read the workflow path.
      
    `id-token: write`

To sign the provenance.
    
    `contents: write`

To add assets to a release.
    
    `uses: slsa-framework/slsa-github-generator/.github/workflows/generator_generic_slsa3.yml@v1.4.0
    with:
      base64-subjects: "${{ needs.build.outputs.digests }}"
      upload-assets: true `

# Optional: Upload to a new release

# polkadot{.js} extension

A very simple scaffolding browser extension that injects a [@polkadot/api](https://github.com/polkadot-js/api) Signer into a page, along with any associated accounts, allowing for use by any dapp. This is an extensible POC implementation of a Polkadot/Substrate browser signer.
As it stands, it does one thing: it _only_ manages accounts and allows the signing of transactions with those accounts. It does not inject providers for use by dapps at this early point, nor does it perform wallet functions where it constructs and submits txs to the network.

## Installation

On Chrome, install via [Chrome web store](https://chrome.google.com/webstore/detail/polkadot%7Bjs%7D-extension/mopnmbcafieddcagagdcbnhejhlodfdd)
On Firefox, install via [Firefox add-ons](https://addons.mozilla.org/en-US/firefox/addon/polkadot-js-extension/)
[interface screenshots](docs/extension-overview.png)

# Documentation and examples

Find out more about how to use the extension as a Dapp developper, cookbook, as well as answers to most frequent questions in the [Polkadot-js extension documentation](https://polkadot.js.org/docs/extension/)

## Development version

Steps to build the extension and view your changes in a browser:

1. Build via `yarn build`
2. Install the extension
  - Chrome:
    - go to `chrome://extensions/`
    - ensure you have the Development flag set
    - "Load unpacked" and point to `packages/extension/build`
    - if developing, after making changes - refresh the extension
  - Firefox:
    - go to `about:debugging#addons`
    - check "Enable add-on debugging"
    - click on "Load Temporary Add-on" and point to `packages/extension/build/manifest.json`
    - if developing, after making changes - reload the extension
3. When visiting `https://polkadot.js.org/apps/` it will inject the extension

Once added, you can create an account (via a generated seed) or import via an existing seed. The [apps UI](https://github.com/polkadot-js/apps/), when loaded, will show these accounts as `<account name> (extension)`

## Development

The repo is split into a number of packages -

- [extension](packages/extension/) - All the injection and background processing logic (the main entry)
- [extension-ui](packages/extension-ui/) - The UI components for the extension, to build up the popup
- [extension-dapp](packages/extension-dapp/) - A convenience wrapper to work with the injected objects, simplifying data extraction for any dapp that wishes to integrate the extension (or any extension that supports the interface)
- [extension-inject](packages/extension-inject/) - A convenience wrapper that allows extension developers to inject their extension for use by any dapp

## Dapp developers

The actual in-depth technical breakdown is given in the next section for any dapp developer wishing to work with the raw objects injected into the window. However, convenience wrappers are provided that allows for any dapp to use this extension (or any other extension that conforms to the interface) without having to manage any additional info.
The documentation for Dapp development is available [in the polkadot-js doc](https://polkadot.js.org/docs/extension).
This approach is used to support multiple external signers in for instance [apps](https://github.com/polkadot-js/apps/). You can read more about the convenience wrapper [@polkadot/extension-dapp](packages/extension-dapp/) along with usage samples.

## API interface

The extension injection interfaces are generic, i.e. it is designed to allow any extension developer to easily inject extensions (that conforms to a specific interface) and at the same time, it allows for any dapp developer to easily enable the interfaces from multiple extensions at the same time. It is not an all-or-nothing approach, but rather it is an ecosystem where the user can choose which extensions fit their style best.
From a dapp developer perspective, the only work needed is to include the [@polkadot/extension-dapp](packages/extension-dapp/) package and call the appropriate enabling function to retrieve all the extensions and their associated interfaces. From an extension developer perspective, the only work required is to enable the extension via the razor-thin [@polkadot/extension-inject](packages/extension-inject/) wrapper. 
Any dapp using the above interfaces will have access to the extension via this interface. {When there is more than one extension, each will populate an entry via the injection interface and each will be made available to the dapp. The `Injected` interface, as returned via `enable`, contains the following information for any compliant extension.js interface Injected {the interface for Accounts, as detailed below readonly accounts: Accounts the standard Signer interface for the API, as detailed below 
readonly signer: Signer; not injected as of yet, subscribable provider for polkadot-js API injection, this can be passed to the API itself upon construction in the dapp readonly provider?: Provider} interface Account = {ss-58 encoded address readonly address: string; the genesisHash for this account (empty if applicable to all)} readonly genesisHash: string; (optional) name for display readonly name: string} exposes accounts
interface Accounts {retrieves the list of accounts for right now get: () => Promise<Account[]> (optional) subscribe to all accounts, updating as they change subscribe: (cb: (accounts: Account[]) => any) => () => void} a signer that communicates with the extension via sendMessage interface Signer extends SignerInterface {no specific signer extensions, exposes the `sign` interface for use by the polkadot-js API, confirming the Signer interface for this API}

## Injection information

The information contained in this section may change and evolve. It is therefore recommended that all access is done via the [@polkadot/extension-dapp](packages/extension-dapp/) (for dapps) and [extension-inject](packages/extension-inject/) (for extensions) packages, which removes the need to work with the lower-level targets.
The extension injects `injectedWeb3` into the global `window` object, exposing the following: (This is meant to be generic across extensions, allowing any dapp to utilize multiple signers, and pull accounts from multiples, as they are available.)
window.injectedWeb3 = {this is the name for this extension, there could be multiples injected, each with their own keys, here `polkadot-js` is for this extension 'polkadot-js': {semver for the package version: '0.1.0'}
this is called to enable the injection, and returns an injected object containing the accounts, signer and provider interfaces or it will reject if not authorized) enable (originName: string): Promise<Injected>}}

## Mnemonics, Passwords, and Imports/Exports

Using the mnemonic and password from the extension When you create a keypair via the extension, it supplies a 12-word mnemonic seed and asks you to create a password. This password only encrypts the private key on disk so that the password is required to spend funds in `polkadot-js/apps` or to import the account from backup. The password does not protect the mnemonic phrase. That is, if an attacker were to acquire the mnemonic phrase, they would be able to use it to spend funds without the password.

### Importing mnemonics from other key generation utilities

Some key-generation tools, e.g. [Subkey](https://www.substrate.io/kb/integrate/subkey), support hard and soft key derivation as well as passwords that encrypt the mnemonic phrase such that the mnemonic phrase itself is insufficient to spend funds.
The extension supports these advanced features. When you import an account from a seed, you can add these derivation paths or password to the end of the mnemonic in the following format: <mnemonic phrase>//<hard>/<soft>///<password> That is, hard-derivation paths are prefixed with `//`, soft paths with `/`, and the password with `/` The extension will still ask you to enter a password for this account. As before, this password only encrypts the private key on disk. It is not required to be the same password as the one that encrypts the mnemonic phrase.
Accounts can also be derived from existing accounts – `Derive New Account` option in account's dropdown menu should be selected. After providing the password of the parent account, along with name and password of the derived account, enter derivation path in the following format: <hard>/<soft> The path will be added to the mnemonic phrase of the parent account.const git = gitExtension.getAPI(1); **Note:** To ensure that the `vscode.git` extension is activated before your extension, add `extensionDependencies` ([docs](https://code.visualstudio.com/api/references/extension-manifest)) into the `package.json` of your extension: json "extensionDependencies": ["vscode.git"]

# GitHub Codespaces ♥️ React

Welcome to your shiny new Codespace running React! We've got everything fired up and running for you to explore React.

You've got a blank canvas to work on from a git perspective as well. There's a single initial commit with the what you're seeing right now - where you go from here is up to you!

Everything you do here is contained within this one codespace. There is no repository on GitHub yet. If and when you’re ready you can click "Publish Branch" and we’ll create your repository and push up your project. If you were just exploring then and have no further need for this code then you can simply delete your codespace and it's gone forever.

This project was bootstrapped for you with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

We've already run this for you in the `Codespaces: server` terminal window below. If you need to stop the server for any reason you can just run `npm start` again to bring it back online.

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) in the built-in Simple Browser (`Cmd/Ctrl + Shift + P > Simple Browser: Show`) to view your running application.

The page will reload automatically when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)
# Building Node.js

Depending on what platform or features you need, the build process may
differ. After you've built a binary, running the
test suite to confirm that the binary works as intended is a good next step.

If you can reproduce a test failure, search for it in the
[Node.js issue tracker](https://github.com/nodejs/node/issues) or
file a new issue.

## Table of contents

* [Supported platforms](#supported-platforms)
  * [Input](#input)
  * [Strategy](#strategy)
  * [Platform list](#platform-list)
  * [Supported toolchains](#supported-toolchains)
  * [Official binary platforms and toolchains](#official-binary-platforms-and-toolchains)
    * [OpenSSL asm support](#openssl-asm-support)
  * [Previous versions of this document](#previous-versions-of-this-document)
* [Building Node.js on supported platforms](#building-nodejs-on-supported-platforms)
  * [Prerequisites](#prerequisites)
  * [Unix and macOS](#unix-and-macos)
    * [Unix prerequisites](#unix-prerequisites)
    * [macOS prerequisites](#macos-prerequisites)
    * [Building Node.js](#building-nodejs-1)
    * [Installing Node.js](#installing-nodejs)
    * [Running Tests](#running-tests)
    * [Running Coverage](#running-coverage)
    * [Building the documentation](#building-the-documentation)
    * [Building a debug build](#building-a-debug-build)
    * [Building an ASan build](#building-an-asan-build)
    * [Speeding up frequent rebuilds when developing](#speeding-up-frequent-rebuilds-when-developing)
    * [Troubleshooting Unix and macOS builds](#troubleshooting-unix-and-macos-builds)
  * [Windows](#windows)
    * [Windows Prerequisites](#windows-prerequisites)
      * [Option 1: Manual install](#option-1-manual-install)
      * [Option 2: Automated install with Boxstarter](#option-2-automated-install-with-boxstarter)
    * [Building Node.js](#building-nodejs-2)
  * [Android](#android)
* [`Intl` (ECMA-402) support](#intl-ecma-402-support)
  * [Build with full ICU support (all locales supported by ICU)](#build-with-full-icu-support-all-locales-supported-by-icu)
    * [Unix/macOS](#unixmacos)
    * [Windows](#windows-1)
  * [Trimmed: `small-icu` (English only) support](#trimmed-small-icu-english-only-support)
    * [Unix/macOS](#unixmacos-1)
    * [Windows](#windows-2)
  * [Building without Intl support](#building-without-intl-support)
    * [Unix/macOS](#unixmacos-2)
    * [Windows](#windows-3)
  * [Use existing installed ICU (Unix/macOS only)](#use-existing-installed-icu-unixmacos-only)
  * [Build with a specific ICU](#build-with-a-specific-icu)
    * [Unix/macOS](#unixmacos-3)
    * [Windows](#windows-4)
* [Configuring OpenSSL config appname](#configure-openssl-appname)
* [Building Node.js with FIPS-compliant OpenSSL](#building-nodejs-with-fips-compliant-openssl)
* [Building Node.js with external core modules](#building-nodejs-with-external-core-modules)
  * [Unix/macOS](#unixmacos-4)
  * [Windows](#windows-5)
* [Note for downstream distributors of Node.js](#note-for-downstream-distributors-of-nodejs)

## Supported platforms

This list of supported platforms is current as of the branch/release to
which it belongs.

### Input

Node.js relies on V8 and libuv. We adopt a subset of their supported platforms.

### Strategy

There are three support tiers:

* **Tier 1**: These platforms represent the majority of Node.js users. The
  Node.js Build Working Group maintains infrastructure for full test coverage.
  Test failures on tier 1 platforms will block releases.
* **Tier 2**: These platforms represent smaller segments of the Node.js user
  base. The Node.js Build Working Group maintains infrastructure for full test
  coverage. Test failures on tier 2 platforms will block releases.
  Infrastructure issues may delay the release of binaries for these platforms.
* **Experimental**: May not compile or test suite may not pass. The core team
  does not create releases for these platforms. Test failures on experimental
  platforms do not block releases. Contributions to improve support for these
  platforms are welcome.

Platforms may move between tiers between major release lines. The table below
will reflect those changes.

### Platform list

Node.js compilation/execution support depends on operating system, architecture,
and libc version. The table below lists the support tier for each supported
combination. A list of [supported compile toolchains](#supported-toolchains) is
also supplied for tier 1 platforms.

**For production applications, run Node.js on supported platforms only.**

Node.js does not support a platform version if a vendor has expired support
for it. In other words, Node.js does not support running on End-of-Life (EoL)
platforms. This is true regardless of entries in the table below.

| Operating System | Architectures    | Versions                          | Support Type                                    | Notes                                |
| ---------------- | ---------------- | --------------------------------- | ----------------------------------------------- | ------------------------------------ |
| GNU/Linux        | x64              | kernel >= 4.18[^1], glibc >= 2.28 | Tier 1                                          | e.g. Ubuntu 20.04, Debian 10, RHEL 8 |
| GNU/Linux        | x64              | kernel >= 3.10, musl >= 1.1.19    | Experimental                                    | e.g. Alpine 3.8                      |
| GNU/Linux        | x86              | kernel >= 3.10, glibc >= 2.17     | Experimental                                    | Downgraded as of Node.js 10          |
| GNU/Linux        | arm64            | kernel >= 4.18[^1], glibc >= 2.28 | Tier 1                                          | e.g. Ubuntu 20.04, Debian 10, RHEL 8 |
| GNU/Linux        | armv7            | kernel >= 4.18[^1], glibc >= 2.28 | Tier 1                                          | e.g. Ubuntu 20.04, Debian 11         |
| GNU/Linux        | armv6            | kernel >= 4.14, glibc >= 2.24     | Experimental                                    | Downgraded as of Node.js 12          |
| GNU/Linux        | ppc64le >=power8 | kernel >= 4.18[^1], glibc >= 2.28 | Tier 2                                          | e.g. Ubuntu 20.04, RHEL 8            |
| GNU/Linux        | s390x            | kernel >= 4.18[^1], glibc >= 2.28 | Tier 2                                          | e.g. RHEL 8                          |
| GNU/Linux        | loong64          | kernel >= 5.19, glibc >= 2.36     | Experimental                                    |                                      |
| Windows          | x64, x86 (WoW64) | >= Windows 10/Server 2016         | Tier 1                                          | [^2],[^3]                            |
| Windows          | x86 (native)     | >= Windows 10/Server 2016         | Tier 1 (running) / Experimental (compiling)[^4] |                                      |
| Windows          | x64, x86         | Windows 8.1/Server 2012           | Experimental                                    |                                      |
| Windows          | arm64            | >= Windows 10                     | Tier 2                                          |                                      |
| macOS            | x64              | >= 11.0                           | Tier 1                                          | For notes about compilation see [^5] |
| macOS            | arm64            | >= 11.0                           | Tier 1                                          |                                      |
| SmartOS          | x64              | >= 18                             | Tier 2                                          |                                      |
| AIX              | ppc64be >=power8 | >= 7.2 TL04                       | Tier 2                                          |                                      |
| FreeBSD          | x64              | >= 13.2                           | Experimental                                    |                                      |

<!--lint disable final-definition-->

[^1]: Older kernel versions may work. However, official Node.js release
    binaries are [built on RHEL 8 systems](#official-binary-platforms-and-toolchains)
    with kernel 4.18.

[^2]: On Windows, running Node.js in Windows terminal emulators
    like `mintty` requires the usage of [winpty](https://github.com/rprichard/winpty)
    for the tty channels to work (e.g. `winpty node.exe script.js`).
    In "Git bash" if you call the node shell alias (`node` without the `.exe`
    extension), `winpty` is used automatically.

[^3]: The Windows Subsystem for Linux (WSL) is not
    supported, but the GNU/Linux build process and binaries should work. The
    community will only address issues that reproduce on native GNU/Linux
    systems. Issues that only reproduce on WSL should be reported in the
    [WSL issue tracker](https://github.com/Microsoft/WSL/issues). Running the
    Windows binary (`node.exe`) in WSL will not work without workarounds such as
    stdio redirection.

[^4]: Running Node.js on x86 Windows should work and binaries
    are provided. However, tests in our infrastructure only run on WoW64.
    Furthermore, compiling on x86 Windows is Experimental and
    may not be possible.

[^5]: Our macOS x64 Binaries are compiled with 11.0 as a target. Xcode 13 is
    required to compile.

<!--lint enable final-definition-->

### Supported toolchains

Depending on the host platform, the selection of toolchains may vary.

| Operating System | Compiler Versions                                              |
| ---------------- | -------------------------------------------------------------- |
| Linux            | GCC >= 10.1                                                    |
| Windows          | Visual Studio >= 2022 with the Windows 10 SDK on a 64-bit host |
| macOS            | Xcode >= 13 (Apple LLVM >= 12)                                 |

### Official binary platforms and toolchains

Binaries at <https://nodejs.org/download/release/> are produced on:

| Binary package          | Platform and Toolchain                                                                                      |
| ----------------------- | ----------------------------------------------------------------------------------------------------------- |
| aix-ppc64               | AIX 7.2 TL04 on PPC64BE with GCC 10                                                                         |
| darwin-x64              | macOS 11, Xcode 13 with -mmacosx-version-min=11.0                                                           |
| darwin-arm64 (and .pkg) | macOS 11 (arm64), Xcode 13 with -mmacosx-version-min=11.0                                                   |
| linux-arm64             | RHEL 8 with GCC 10[^6]                                                                                      |
| linux-armv7l            | Cross-compiled on RHEL 8 x64 with [custom GCC toolchain](https://github.com/rvagg/rpi-newer-crosstools)[^7] |
| linux-ppc64le           | RHEL 8 with gcc-toolset-10[^6]                                                                              |
| linux-s390x             | RHEL 8 with gcc-toolset-10[^6]                                                                              |
| linux-x64               | RHEL 8 with gcc-toolset-10[^6]                                                                              |
| win-x64 and win-x86     | Windows Server 2022 (x64) with Visual Studio 2022                                                           |

<!--lint disable final-definition-->

[^6]: Binaries produced on these systems are compatible with glibc >= 2.28
    and libstdc++ >= 6.0.25 (`GLIBCXX_3.4.25`). These are available on
    distributions natively supporting GCC 8.1 or higher, such as Debian 10,
    RHEL 8 and Ubuntu 20.04.

[^7]: Binaries produced on these systems are compatible with glibc >= 2.28
    and libstdc++ >= 6.0.28 (`GLIBCXX_3.4.28`). These are available on
    distributions natively supporting GCC 9.3 or higher, such as Debian 11,
    Ubuntu 20.04.

<!--lint enable final-definition-->

#### OpenSSL asm support

OpenSSL-1.1.1 requires the following assembler version for use of asm
support on x86\_64 and ia32.

For use of AVX-512,

* gas (GNU assembler) version 2.26 or higher
* nasm version 2.11.8 or higher in Windows

AVX-512 is disabled for Skylake-X by OpenSSL-1.1.1.

For use of AVX2,

* gas (GNU assembler) version 2.23 or higher
* Xcode version 5.0 or higher
* llvm version 3.3 or higher
* nasm version 2.10 or higher in Windows

Please refer to <https://docs.openssl.org/1.1.1/man3/OPENSSL_ia32cap/> for details.

If compiling without one of the above, use `configure` with the
`--openssl-no-asm` flag. Otherwise, `configure` will fail.

### Previous versions of this document

Supported platforms and toolchains change with each major version of Node.js.
This document is only valid for the current major version of Node.js.
Consult previous versions of this document for older versions of Node.js:

* [Node.js 21](https://github.com/nodejs/node/blob/v21.x/BUILDING.md)
* [Node.js 20](https://github.com/nodejs/node/blob/v20.x/BUILDING.md)
* [Node.js 18](https://github.com/nodejs/node/blob/v18.x/BUILDING.md)

## Building Node.js on supported platforms

### Prerequisites

* [A supported version of Python][Python versions] for building and testing.
* Memory: at least 8GB of RAM is typically required when compiling with 4 parallel jobs (e.g: `make -j4`)

### Unix and macOS

#### Unix prerequisites

* `gcc` and `g++` >= 10.1 or newer
* GNU Make 3.81 or newer
* [A supported version of Python][Python versions]
  * For test coverage, your Python installation must include pip.

Installation via Linux package manager can be achieved with:

* Ubuntu, Debian: `sudo apt-get install python3 g++ make python3-pip`
* Fedora: `sudo dnf install python3 gcc-c++ make python3-pip`
* CentOS and RHEL: `sudo yum install python3 gcc-c++ make python3-pip`
* OpenSUSE: `sudo zypper install python3 gcc-c++ make python3-pip`
* Arch Linux, Manjaro: `sudo pacman -S python gcc make python-pip`

FreeBSD and OpenBSD users may also need to install `libexecinfo`.

#### macOS prerequisites

* Xcode Command Line Tools >= 13 for macOS
* [A supported version of Python][Python versions]
  * For test coverage, your Python installation must include pip.

macOS users can install the `Xcode Command Line Tools` by running
`xcode-select --install`. Alternatively, if you already have the full Xcode
installed, you can find them under the menu `Xcode -> Open Developer Tool ->
More Developer Tools...`. This step will install `clang`, `clang++`, and
`make`.

#### Building Node.js

If the path to your build directory contains a space, the build will likely
fail.

To build Node.js:

```bash
./configure
make -j4
```

We can speed up the builds by using [Ninja](https://ninja-build.org/). For more
information, see
[Building Node.js with Ninja](doc/contributing/building-node-with-ninja.md).

The `-j4` option will cause `make` to run 4 simultaneous compilation jobs which
may reduce build time. For more information, see the
[GNU Make Documentation](https://www.gnu.org/software/make/manual/html_node/Parallel.html).

The above requires that `python` resolves to a supported version of
Python. See [Prerequisites](#prerequisites).

After building, setting up [firewall rules](tools/macos-firewall.sh) can avoid
popups asking to accept incoming network connections when running tests.

Running the following script on macOS will add the firewall rules for the
executable `node` in the `out` directory and the symbolic `node` link in the
project's root directory.

```bash
sudo ./tools/macos-firewall.sh
```

#### Installing Node.js

To install this version of Node.js into a system directory:

```bash
[sudo] make install
```

#### Running tests

To verify the build:

```bash
make test-only
```

At this point, you are ready to make code changes and re-run the tests.

If you are running tests before submitting a pull request, use:

```bash
make -j4 test
```

`make -j4 test` does a full check on the codebase, including running linters and
documentation tests.

To run the linter without running tests, use
`make lint`/`vcbuild lint`. It will lint JavaScript, C++, and Markdown files.

To fix auto fixable JavaScript linting errors, use `make lint-js-fix`.

If you are updating tests and want to run tests in a single test file
(e.g. `test/parallel/test-stream2-transform.js`):

```bash
tools/test.py test/parallel/test-stream2-transform.js
```

You can execute the entire suite of tests for a given subsystem
by providing the name of a subsystem:

```bash
tools/test.py child-process
```

You can also execute the tests in a test suite directory
(such as `test/message`):

```bash
tools/test.py test/message
```

If you want to check the other options, please refer to the help by using
the `--help` option:

```bash
tools/test.py --help
```

> Note: On Windows you should use `python3` executable.
> Example: `python3 tools/test.py test/message`

You can usually run tests directly with node:

```bash
./node test/parallel/test-stream2-transform.js
```

> Info: `./node` points to your local Node.js build.

Remember to recompile with `make -j4` in between test runs if you change code in
the `lib` or `src` directories.

The tests attempt to detect support for IPv6 and exclude IPv6 tests if
appropriate. If your main interface has IPv6 addresses, then your
loopback interface must also have '::1' enabled. For some default installations
on Ubuntu, that does not seem to be the case. To enable '::1' on the
loopback interface on Ubuntu:

```bash
sudo sysctl -w net.ipv6.conf.lo.disable_ipv6=0
```

You can use
[node-code-ide-configs](https://github.com/nodejs/node-code-ide-configs)
to run/debug tests if your IDE configs are present.

#### Running coverage

It's good practice to ensure any code you add or change is covered by tests.
You can do so by running the test suite with coverage enabled:

```bash
./configure --coverage
make coverage
```

A detailed coverage report will be written to `coverage/index.html` for
JavaScript coverage and to `coverage/cxxcoverage.html` for C++ coverage.

If you only want to run the JavaScript tests then you do not need to run
the first command (`./configure --coverage`). Run `make coverage-run-js`,
to execute JavaScript tests independently of the C++ test suite:

```bash
make coverage-run-js
```

If you are updating tests and want to collect coverage for a single test file
(e.g. `test/parallel/test-stream2-transform.js`):

```bash
make coverage-clean
NODE_V8_COVERAGE=coverage/tmp tools/test.py test/parallel/test-stream2-transform.js
make coverage-report-js
```

You can collect coverage for the entire suite of tests for a given subsystem
by providing the name of a subsystem:

```bash
make coverage-clean
NODE_V8_COVERAGE=coverage/tmp tools/test.py --mode=release child-process
make coverage-report-js
```

The `make coverage` command downloads some tools to the project root directory.
To clean up after generating the coverage reports:

```bash
make coverage-clean
```

#### Building the documentation

To build the documentation:

This will build Node.js first (if necessary) and then use it to build the docs:

```bash
make doc
```

If you have an existing Node.js build, you can build just the docs with:

```bash
NODE=/path/to/node make doc-only
```

To read the man page:

```bash
man doc/node.1
```

If you prefer to read the full documentation in a browser, run the following.

```bash
make docserve
```

This will spin up a static file server and provide a URL to where you may browse
the documentation locally.

If you're comfortable viewing the documentation using the program your operating
system has associated with the default web browser, run the following.

```bash
make docopen
```

This will open a file URL to a one-page version of all the browsable HTML
documents using the default browser.

```bash
make docclean
```

This will clean previously built doc.

To test if Node.js was built correctly:

```bash
./node -e "console.log('Hello from Node.js ' + process.version)"
```

#### Building a debug build

If you run into an issue where the information provided by the JS stack trace
is not enough, or if you suspect the error happens outside of the JS VM, you
can try to build a debug enabled binary:

```bash
./configure --debug
make -j4
```

`make` with `./configure --debug` generates two binaries, the regular release
one in `out/Release/node` and a debug binary in `out/Debug/node`, only the
release version is actually installed when you run `make install`.

To use the debug build with all the normal dependencies overwrite the release
version in the install directory:

```bash
make install PREFIX=/opt/node-debug/
cp -a -f out/Debug/node /opt/node-debug/node
```

When using the debug binary, core dumps will be generated in case of crashes.
These core dumps are useful for debugging when provided with the
corresponding original debug binary and system information.

Reading the core dump requires `gdb` built on the same platform the core dump
was captured on (i.e. 64-bit `gdb` for `node` built on a 64-bit system, Linux
`gdb` for `node` built on Linux) otherwise you will get errors like
`not in executable format: File format not recognized`.

Example of generating a backtrace from the core dump:

```bash
$ gdb /opt/node-debug/node core.node.8.1535359906
(gdb) backtrace
```

#### Building an ASan build

[ASan](https://github.com/google/sanitizers) can help detect various memory
related bugs. ASan builds are currently only supported on linux.
If you want to check it on Windows or macOS or you want a consistent toolchain
on Linux, you can try [Docker](https://www.docker.com/products/docker-desktop/)
(using an image like `gengjiawen/node-build:2020-02-14`).

The `--debug` is not necessary and will slow down build and testing, but it can
show clear stacktrace if ASan hits an issue.

```bash
./configure --debug --enable-asan && make -j4
make test-only
```

#### Speeding up frequent rebuilds when developing

Tips: The `ccache` utility is widely used and should generally work fine.
If you encounter any difficulties, consider disabling `mold` as a
troubleshooting step.

If you plan to frequently rebuild Node.js, especially if using several
branches, installing `ccache` can help to greatly reduce build
times. Set up with:

On GNU/Linux:

Tips: `mold` can speed up the link process, which can't be cached, you may
need to install the latest version but not the apt version.

```bash
sudo apt install ccache mold   # for Debian/Ubuntu, included in most Linux distros
export CC="ccache gcc"         # add to your .profile
export CXX="ccache g++"        # add to your .profile
export LDFLAGS="-fuse-ld=mold" # add to your .profile
```

Refs:

1. <https://ccache.dev/performance.html>
2. <https://github.com/rui314/mold>

On macOS:

```bash
brew install ccache            # see https://brew.sh
export CC="ccache cc"          # add to ~/.zshrc or other shell config file
export CXX="ccache c++"        # add to ~/.zshrc or other shell config file
```

This will allow for near-instantaneous rebuilds when switching branches back
and forth that were built with cache.

When modifying only the JS layer in `lib`, it is possible to externally load it
without modifying the executable:

```bash
./configure --node-builtin-modules-path "$(pwd)"
```

The resulting binary won't include any JS files and will try to load them from
the specified directory. The JS debugger of Visual Studio Code supports this
configuration since the November 2020 version and allows for setting
breakpoints.

#### Troubleshooting Unix and macOS builds

Stale builds can sometimes result in `file not found` errors while building.
This and some other problems can be resolved with `make distclean`. The
`distclean` recipe aggressively removes build artifacts. You will need to
build again (`make -j4`). Since all build artifacts have been removed, this
rebuild may take a lot more time than previous builds. Additionally,
`distclean` removes the file that stores the results of `./configure`. If you
ran `./configure` with non-default options (such as `--debug`), you will need
to run it again before invoking `make -j4`.

If you received the error `nodejs g++ fatal error compilation terminated cc1plus`
during compilation, this is likely a memory issue and you should either provide
more RAM or create swap space to accommodate toolchain requirements or reduce
the number of parallel build tasks (`-j<n>`).

### Windows

#### Tips

You may need disable vcpkg integration if you got link error about symbol
redefine related to zlib.lib(zlib1.dll), even you never install it by hand,
as vcpkg is part of CLion and Visual Studio now.

```powershell
# find your vcpkg
# double check vcpkg install the related file
vcpkg owns zlib.lib
vcpkg owns zlib1.dll
vcpkg integrate remove
```

Refs:

1. <https://github.com/nodejs/node/issues/24448>
2. <https://github.com/microsoft/vcpkg/issues/37518> / <https://github.com/microsoft/vcpkg/discussions/37546>
3. [vcpkg](https://github.com/microsoft/vcpkg/)

#### Windows Prerequisites

##### Option 1: Manual install

* The current [version of Python][Python versions] from the
  [Microsoft Store](https://apps.microsoft.com/store/search?publisher=Python+Software+Foundation)
* The "Desktop development with C++" workload from
  [Visual Studio 2022 (17.6 or newer)](https://visualstudio.microsoft.com/downloads/)
  or the "C++ build tools" workload from the
  [Build Tools](https://aka.ms/vs/17/release/vs_buildtools.exe),
  with the default optional components
* Basic Unix tools required for some tests,
  [Git for Windows](https://git-scm.com/download/win) includes Git Bash
  and tools which can be included in the global `PATH`.
* The [NetWide Assembler](https://www.nasm.us/), for OpenSSL assembler modules.
  If not installed in the default location, it needs to be manually added
  to `PATH`. A build with the `openssl-no-asm` option does not need this, nor
  does a build targeting ARM64 Windows.

Optional requirements to build the MSI installer package:

* The .NET SDK component from [Visual Studio 2022](https://visualstudio.microsoft.com/downloads/)
  * This component can be installed via the Visual Studio Installer Application

Optional requirements for compiling for Windows on ARM (ARM64):

* Visual Studio 17.6.0 or newer
  > **Note:** There is [a bug](https://github.com/nodejs/build/issues/3739) in `17.10.x`
  > preventing Node.js from compiling.
* Visual Studio optional components
  * Visual C++ compilers and libraries for ARM64
  * Visual C++ ATL for ARM64
* Windows 10 SDK 10.0.17763.0 or newer

Optional requirements for compiling with ClangCL:

* Visual Studio optional components
  * C++ Clang Compiler for Windows
  * MSBuild support for LLVM toolset

NOTE: Currently we only support compiling with Clang that comes from Visual Studio.

##### Option 2: Automated install with Boxstarter

A [Boxstarter](https://boxstarter.org/) script can be used for easy setup of
Windows systems with all the required prerequisites for Node.js development.
This script will install the following [Chocolatey](https://chocolatey.org/)
packages:

* [Git for Windows](https://chocolatey.org/packages/git) with the `git` and
  Unix tools added to the `PATH`
* [Python 3.x](https://chocolatey.org/packages/python)
* [Visual Studio 2022 Build Tools](https://chocolatey.org/packages/visualstudio2022buildtools)
  with [Visual C++ workload](https://chocolatey.org/packages/visualstudio2022-workload-vctools)
* [NetWide Assembler](https://chocolatey.org/packages/nasm)

To install Node.js prerequisites using
[Boxstarter WebLauncher](https://boxstarter.org/weblauncher), visit
<https://boxstarter.org/package/nr/url?https://raw.githubusercontent.com/nodejs/node/HEAD/tools/bootstrap/windows_boxstarter>
with a supported browser.

Alternatively, you can use PowerShell. Run those commands from
an elevated (Administrator) PowerShell terminal:

```powershell
Set-ExecutionPolicy Unrestricted -Force
iex ((New-Object System.Net.WebClient).DownloadString('https://boxstarter.org/bootstrapper.ps1'))
get-boxstarter -Force
Install-BoxstarterPackage https://raw.githubusercontent.com/nodejs/node/HEAD/tools/bootstrap/windows_boxstarter -DisableReboots
refreshenv
```

The entire installation using Boxstarter will take up approximately 10 GB of
disk space.

#### Building Node.js

* Remember to first clone the Node.js repository with the Git command
  and head to the directory that Git created; If you haven't already
  ```powershell
  git clone https://github.com/nodejs/node.git
  cd node
  ```

> \[!TIP]
> If you are building from a Windows machine, symlinks are disabled by default, and can be enabled by cloning
> with the `-c core.symlinks=true` flag.
>
> ```powershell
> git clone -c core.symlinks=true <repository_url>
> ```

* If the path to your build directory contains a space or a non-ASCII character,
  the build will likely fail

To start the build process:

```powershell
.\vcbuild
```

To run the tests:

```powershell
.\vcbuild test
```

To test if Node.js was built correctly:

```powershell
Release\node -e "console.log('Hello from Node.js', process.version)"
```

### Android

Android is not a supported platform. Patches to improve the Android build are
welcome. There is no testing on Android in the current continuous integration
environment. The participation of people dedicated and determined to improve
Android building, testing, and support is encouraged.

Be sure you have downloaded and extracted
[Android NDK](https://developer.android.com/ndk) before in
a folder. Then run:

```bash
./android-configure <path to the Android NDK> <Android SDK version> <target architecture>
make -j4
```

The Android SDK version should be at least 24 (Android 7.0) and the target
architecture supports \[arm, arm64/aarch64, x86, x86\_64].

## `Intl` (ECMA-402) support

[Intl](doc/api/intl.md) support is
enabled by default.

### Build with full ICU support (all locales supported by ICU)

This is the default option.

#### Unix/macOS

```bash
./configure --with-intl=full-icu
```

#### Windows

```powershell
.\vcbuild full-icu
```

### Trimmed: `small-icu` (English only) support

In this configuration, only English data is included, but
the full `Intl` (ECMA-402) APIs. It does not need to download
any dependencies to function. You can add full data at runtime.

#### Unix/macOS

```bash
./configure --with-intl=small-icu
```

#### Windows

```powershell
.\vcbuild small-icu
```

### Building without Intl support

The `Intl` object will not be available, nor some other APIs such as
`String.normalize`.

#### Unix/macOS

```bash
./configure --without-intl
```

#### Windows

```powershell
.\vcbuild without-intl
```

### Use existing installed ICU (Unix/macOS only)

```bash
pkg-config --modversion icu-i18n && ./configure --with-intl=system-icu
```

If you are cross-compiling, your `pkg-config` must be able to supply a path
that works for both your host and target environments.

### Build with a specific ICU

You can find other ICU releases at
[the ICU homepage](https://icu.unicode.org/download).
Download the file named something like `icu4c-**##.#**-src.tgz` (or
`.zip`).

To check the minimum recommended ICU, run `./configure --help` and see
the help for the `--with-icu-source` option. A warning will be printed
during configuration if the ICU version is too old.

#### Unix/macOS

From an already-unpacked ICU:

```bash
./configure --with-intl=[small-icu,full-icu] --with-icu-source=/path/to/icu
```

From a local ICU tarball:

```bash
./configure --with-intl=[small-icu,full-icu] --with-icu-source=/path/to/icu.tgz
```

From a tarball URL:

```bash
./configure --with-intl=full-icu --with-icu-source=http://url/to/icu.tgz
```

#### Windows

First unpack latest ICU to `deps/icu`
[icu4c-**##.#**-src.tgz](https://icu.unicode.org/download) (or `.zip`)
as `deps/icu` (You'll have: `deps/icu/source/...`)

```powershell
.\vcbuild full-icu
```

### Configure OpenSSL appname

Node.js can use an OpenSSL configuration file by specifying the environment
variable `OPENSSL_CONF`, or using the command line option `--openssl-conf`, and
if none of those are specified will default to reading the default OpenSSL
configuration file `openssl.cnf`. Node.js will only read a section that is by
default named `nodejs_conf`, but this name can be overridden using the following
configure option:

```bash
./configure --openssl-conf-name=<some_conf_name>
```

## Building Node.js with FIPS-compliant OpenSSL

Node.js supports FIPS when statically or dynamically linked with OpenSSL 3 via
[OpenSSL's provider model](https://docs.openssl.org/3.0/man7/crypto/#OPENSSL-PROVIDERS).
It is not necessary to rebuild Node.js to enable support for FIPS.

See [FIPS mode](doc/api/crypto.md#fips-mode) for more information on how to
enable FIPS support in Node.js.

## Building Node.js with external core modules

It is possible to specify one or more JavaScript text files to be bundled in
the binary as built-in modules when building Node.js.

### Unix/macOS

This command will make `/root/myModule.js` available via
`require('/root/myModule')` and `./myModule2.js` available via
`require('myModule2')`.

```bash
./configure --link-module '/root/myModule.js' --link-module './myModule2.js'
```

### Windows

To make `./myModule.js` available via `require('myModule')` and
`./myModule2.js` available via `require('myModule2')`:

```powershell
.\vcbuild link-module './myModule.js' link-module './myModule2.js'
```

## Building to use shared dependencies at runtime

By default Node.js is built so that all dependencies are bundled into
the Node.js binary itself. This provides a single binary that includes
the correct versions of all dependencies on which it depends.

Some Node.js distributions, however, prefer to manage dependencies.
A number of `configure` options are provided to support this use case.

* For dependencies with native code, the first set of options allow
  Node.js to be built so that it uses a shared library
  at runtime instead of building and including the dependency
  in the Node.js binary itself. These options are in the
  `Shared libraries` section of the `configure` help
  (run `./configure --help` to get the complete list).
  They provide the ability to enable the use of a shared library,
  to set the name of the shared library, and to set the paths that
  contain the include and shared library files.

* For dependencies with JavaScript code (including WASM), the second
  set of options allow the Node.js binary to be built so that it loads
  the JavaScript for dependencies at runtime instead of being built into
  the Node.js binary itself. These options are in the `Shared builtins`
  section of the `configure` help
  (run `./configure --help` to get the complete list). They
  provide the ability to set the path to an external JavaScript file
  for the dependency to be used at runtime.

It is the responsibility of any distribution
shipping with these options to:

* ensure that the shared dependencies available at runtime
  match what is expected by the Node.js binary. A
  mismatch may result in crashes or unexpected behavior.
* fully test that Node.js operates as expected with the
  external dependencies. There may be little or no test coverage
  within the Node.js project CI for these non-default options.

## Note for downstream distributors of Node.js

The Node.js ecosystem is reliant on ABI compatibility within a major release.
To maintain ABI compatibility it is required that distributed builds of Node.js
be built against the same version of dependencies, or similar versions that do
not break their ABI compatibility, as those released by Node.js for any given
`NODE_MODULE_VERSION` (located in `src/node_version.h`).

When Node.js is built (with an intention to distribute) with an ABI
incompatible with the official Node.js builds (e.g. using a ABI incompatible
version of a dependency), please reserve and use a custom `NODE_MODULE_VERSION`
by opening a pull request against the registry available at
<https://github.com/nodejs/node/blob/HEAD/doc/abi_version_registry.json>.

[Python versions]: https://devguide.python.org/versions/
