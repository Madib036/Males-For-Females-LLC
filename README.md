# OSPO Discussions

![Octocats Collaborating](https://octodex.github.com/images/collabocats.jpg)

## Introduction

This was a public repository for discussions relating to Open Source Program Offices on GitHub.

# Primer Primitives

This repo contains values for color, spacing, and typography primitives for use with [Primer][primer], GitHub's design system.

## Install

This repository is distributed on [npm][npm]. After [installing npm][install-npm], you can install `@primer/primitives` with this command.

```sh
$ npm install --save @primer/primitives
```

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

# Google Pay API sample app for Android

## Overview
This sample demonstrates basic usage of the Google Pay API for Android.

The Google Pay API can be used to request any credit or debit card stored in
your customer's Google account, including Android device tokens managed in
the Google Pay app on Android.

For more information, visit the following link:

https://developers.google.com/pay/api/android/overview

## Instructions

In Android Studio, open the `kotlin` or `java` directory to get started.

Make sure you read the comments in `Constants.java` and `PaymentsUtil.java` before
you continue. These files **must** be modified prior to running the app, as per
the instructions provided in the comments.

## Requirements

In order to build and run this sample app, make sure you:

-   Have Android Studio 3.0 or greater installed.
-   Have a device running Android 4.4 (KitKat) or greater.
-   Have Google Play services version 16.0.0 or greater installed on this device.

To be able to fully test the API, you will also need to:

-   [Add a payment method to your Google Account](https://support.google.com/pay/answer/7625139).
-   [Install and add a payment method to the Google Pay app](https://support.google.com/pay/answer/7625139?co=GENIE.Platform%3DAndroid) (optional).
-   Consult your payment processor's documentation to learn about whether they support the Google Pay API.

## Support

For any questions or issues, please refer to our [How to get help](https://developers.google.com/pay/api/support) page. 


# How to Contribute

We'd love to accept your patches and contributions to this project. There are
just a few small guidelines you need to follow.

## Contributor License Agreement

Contributions to this project must be accompanied by a Contributor License
Agreement. You (or your employer) retain the copyright to your contribution;
this simply gives us permission to use and redistribute your contributions as
part of the project. Head over to <https://cla.developers.google.com/> to see
your current agreements on file or to sign a new one.

You generally only need to submit a CLA once, so if you've already submitted one
(even if it was for a different project), you probably don't need to do it
again.

## Code reviews

All submissions, including submissions by project members, require review. We
use GitHub pull requests for this purpose. Consult
[GitHub Help](https://help.github.com/articles/about-pull-requests/) for more
information on using pull requests.

## Community Guidelines

This project follows
[Google's Open Source Community Guidelines](https://opensource.google.com/conduct/).

# iOS 26.2 RC - iOS 18.7.3 & iOS 17.7.7, iOS 16.7.12 Verified Jailbreak Tools, Download, Reviews & Jailbreak Solutions - (iOS 18.1 - iOS 18.8)

Updated iOS 26.2, iOS 26.1 - iOS 18, 18.1, 18.2, 18.3, 18.4, 18.5, 18.6, 18.7.3 - iOS 17 Jailbreak Methods, Benefits, Status, and Jailbreak Solutions Research Data.

<meta name="google-site-verification" content="N5fkQW_mArfKg_c68CbB-YfIWX_Fts0dXkJkTQuKUoE"/>

![Jailbreak iOS 26.3 beta 4, iOS 18, 18.1,18.2,18.3, 18.4, 18.5, 18.7.3 Online - How to Jailbreak 17.8, 16.7.12, 15.8](https://github.com/user-attachments/assets/942ef641-e611-4c6b-a32b-ad8fe61a20d6)



## iOS 26.3 RC - iOS 18.7.3- iOS 17.7.12 Jailbreak Guide Introduction:

Apple has released iOS 26.3 RC and iOS 18.7.3, now available to developers. IOS 26, Apple includes innovative features; users are curious about the possibilities and benefits of jailbreaking their iOS 26 devices, including iOS 17.7.13 and iOS 18.7.3 

This comprehensive guide is based on our research data about iOS versions. It will drive you into iOS 26.3 RC(26.1), iOS 18.7.3, iOS 17.7.13 ( iOS 17, 17.1, 17.2, 17.3, 17.4, 17.5, 17.6 -  iOS 18, iOS 18.1, 18.2, 18.3, 18.4, 18.5, 18.6.1) & beta jailbreaks, discussing its advantages, Alternatives, status, preparation, safety measures, differences between tethered and untethered jailbreaks, best practices, prospects, and FAQs.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Community-Created Solutions for iOS Jailbreaking:

- iOS 14 - iOS 18.7.3/iOS 26.2 RC - [Jailbreak Tweak Master  ](https://udidmaster.com/pro/install.php)
- iOS 26.2 - iOS 11 Jailbreak AppStore(unc0ver, TrollStore, MisakaX, Redensa, Zjailbreak, More..) - [ZEE Jailbreak Store](https://zeejb.com/store/)
- iOS 15 - iOS 18.7.3/iOS 26.2 RC - [Terminal Jailbreak Tool](https://zeejb.com/updates/terminal-jailbreak-tool/)(Jailbreak Repo Extractor)
- iOS 15 - iOS 17 & Up - [Misaka iOS](https://github.com/iOS17/MisakaX) & tvOS customisation tool for KFD & MDC
- iOS 14.0-16.1.2 (excluding 15.7.2) - [MacDirtyCow](https://github.com/topics/macdirtycow)
- iOS 14 - iOS 17.0 (Excluding iOS 17.0.1)  - [TrollStore](https://github.com/iOS17/TrollStore) Permanently sign and install any application
- iOS 16 - iOS 26.2 RC - [Ksign iOS](https://github.com/iOS17/Ksign-iOS)([Ksign Patcher](https://zeejb.com/updates/ksign-ios/) for Online Install)






### Latest Update:
- 26.3 RC has been released to developers. (The first iOS version to use Apple's new year-based versioning scheme) -[ How to Jailbreak iOS 26.3](https://github.com/iOS17/Jailbreak-iOS-26)
- iOS 18.7.3 released. (Includes a new setting for Liquid Glass transparency)
- iOS 17.7.13 Released.
- iOS 16.7.12

The Complete Guide to iOS 26, iOS 26.3, 18 - 18.1, 18.2, 18.4, 18.4.1, 18.5, 18.7.3 Jailbreak
You can stay updated with the latest Jailbreak updates by following us on Twitter. - [Follow iOS 17 - iOS 26.3 Jailbreak](https://twitter.com/JailbreakBuddy)


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



-------------------------------------------------------------------------------------------------------------------------------------
- [Learn More about how to jailbreak iOS 18.4 beta 4 ](https://kekuk.com/how-to-jailbreak-ios-18-4/)
- [iOSGods world's most extensive third-party app store library - iOS 18.7.3 - iOS 15](https://github.com/iOS17/iOSGods/)
- [MisakaX customization tool for iOS 18.7.3 - iOS 17.7.13: No Jailbreak Needed!](https://github.com/iOS17/MisakaX)
- [Def1nit3lyN0tAJa1lbr3akTool Jailbreak Released for iOS 15.7 - iOS 16.7.11](https://zeejb.com/def1nit3lyn0taja1lbr3aktool-jailbreak-tool/)
- [iOS 17 - iOS 18.7.3, iOS 26.3 RC How to Sideload IPA file?](https://github.com/iOS17/sideloadly)
- [Copy iPhone Images and Manage iPhone/iPad Device on a MAC, The 3uTools for Mac iOS 26.3](https://github.com/iOS17/i4Tools)
-------------------------------------------------------------------------------------------------------------------------------------

Updated 2025 DEC

## iOS 26 - iOS 26.2 beta Jailbreak Status:

About the security content of iOS 26.2 and iPadOS 26.2
<img width="1632" height="514" alt=" iOS 26.2 and iPadOS 26.2 Jailbreak Status" src="https://github.com/user-attachments/assets/ceae6ba4-795b-41d3-ba70-3ae73a5900b3" />

According to the security content from Apple for iOS 16.2 and iPadOS 16.2, a vulnerability has been identified that impacts the following devices: iPhone 11 and later, iPad Pro 12.9-inch (3rd generation) and later, iPad Pro 11-inch (1st generation) and later, iPad Air (3rd generation) and later, iPad (8th generation) and later, as well as iPad mini (5th generation) and later. 
**Impact:** A malicious app could potentially gain root privileges. 
**Description:** This issue, an integer overflow, has been addressed by the implementation of 64-bit timestamps.

### Current Compatibility of Jailbreak Tools for iOS 26 - iOS 26.2

| Jailbreak Tool     | Compatible with iOS 26 - iOS 26.2? | Notes |
|--------------------|------------------------------|-------|
| unc0ver jailbreak  | No                           | unc0ver native support ends before iOS 15–26.2 era (“unsupported” for iOS 26.2)  |
| Odyssey Jailbreak  | No                           | Odyssey has no released support for iOS 26.1+  |
| Chimera            | No                           | Chimera only supports older versions far below iOS 16  |
| Xina15             | No                           | XinaA15 jailbreak stops at earlier iOS versions (pre-16)  |
| Palera1n           | Yes (very limited)           | Works for certain older devices (A11 and below) on iOS 15 – 17.7(iOS 26 Limited) via Checkm8 exploit; not full modern support  |
| Checkra1n          | No                           | Checkra1n classic jailbreak does *not* support iOS 26.2; limited/virtual options exist but no native support  |

### Current Compatibility of Jailbreak Solutions Tools for iOS 26 - iOS 26.2 

| Jailbreak Solutions Tool     | Compatible with iOS 26 - iOS 26.2? | Notes |
|--------------------|------------------------------|-------|
| Jailbreak Tweak Master  | Yes ✅                           | Version 3.4.2 is supported for iOS 26.2 and below. It may be possible to install Cydia Lite and Sileo Lite package managers.|
| ZeeStore  | Yes ✅                           | Newly released iOS jailbreak solution tool may allow users to install unc0ver dark, Misakax, Misaka26, Cydia, Sileo package managers, and Live Container (live support).  |
| Terminal Jailbreak Tool            | Yes ✅                           | Another jailbreak solution tool supports iOS 16.2 and below. Users can install jailbreak-like tweaks, icons, and home screen customizations, as well as repositories.  |
| misaka26             | 26.1 Yes ✅ / 26.2 NO ❌                        | misaka26. An ultimate customization tool, utilizing the bug that makes TrollRestore possible. iOS /iPadOS 16.0 - 26.1 & 26.2 beta 1. Supported iOS 16.0 ~ 26.1  |



### iOS 18.7.3 - iOS 18 Jailbreak Status:

### iOS 17.7.13 - iOS 17 Jailbreak Status:

![iOS 17.7.13 Jailbreak Status](https://github.com/iOS17/Jailbreak/assets/135683347/2588016d-df84-4140-b8ac-7d7ab2cf4988)
**According to iOS 17.7.13 security information ** ([https://support.apple.com/en-us/HT214059](https://support.apple.com/en-us/HT214059)), a kernel-level issue may be used for jailbreaking, but confirmation is pending.
(Available for iPhone XS and later, iPad Pro 12.9-inch 2nd generation and later, iPad Pro 10.5-inch, iPad Pro 11-inch 1st generation and later, iPad Air 3rd generation and later, iPad 6th generation and later, and iPad mini 5th generation and later)

## iOS 16.7.12 - iOS 16 Jailbreak Status:







############## READ MORE ###############
| [ How to Jailbreak iOS 15 - iOS 16.5.1 XinaM1ne Jailbreak tool](https://github.com/iOS17/Xinam1ne-Jailbreak/) |

| [unc0ver Jailbreak for iOS 17 - iOS 17.4.1?](https://github.com/iOS17/unc0ver-jailbreak)

| [Download: Esign For iOS 17.4 Released](https://esigncert.zeejb.com/)  |

| [ How to install Esign iOS for iOS 17.4.1](https://github.com/iOS17/Esign/) |


#############################


################# OFFER #################
>**Udidmaster's team offers you Apple P12 Developer and Distribution Certificates at a low price. ** You can use these certificate files to sign and install IPA files, and also those that support the Esign iOS app, Gbox, Feather iOS, APPDB, Cripzi Signer, Sideloadly, AltSote, Kawa Signer, and LightningSign, like IPA signing tools.**

![Free Download Gbox Esign Certificates P12 for iOS 26.2, 18.6 - iOSA 17.7, iOS 26 Sideloadling AppStore Alternative](https://github.com/iOS17/Jailbreak/assets/135683347/01246746-cc1c-4850-b040-ea071394760a)

** [Download Free .p12 Certificates Now](https://esigncert.zeejb.com/) **

With the Premium AppleP12 Certificates, you can sign unlimited Tweaked IPA files, like Jodel++, Spotify++, Twitter++, YouTube Mod, Games Mods, Jailbreaks, and much more.
Learn More: - [Esign iOS app complete review (How to install Esign)](https://zeejb.com/esign-app/)

If your device is running on Old iOS versions, such as iOS 17 or iOS 18. Do you need to upgrade the[ iOS 26 beta- UIDimaster Certificate to join their developer team.](https://udidmaster.com/)

#######################################################################################################

![Jailbreak IOS 26,  17 - 17.7.6, iOS 18 - 18.4.1, 18.5 and its beta Palera1n, serotonin, Def1nit3lyN0tAJa1lbr3akTool, nako, Redensa, misaka, Jailbreak Repo Manager , unc0ver, chimera, checkm8, taurine, dopamine, xina17, xina, checkra1n, Xinam1ne, Pangu](https://github.com/iOS17/Jailbreak/assets/135683347/040ad272-8b9b-4eef-95f0-90d53217ef6b)
 
## iOS 17, iOS 17.1, 17.2, 17.3, 17.4, and 17.7 (17.6.1) supported devices!

**The iPhone 8 and iPhone X have been discontinued.**

![Jailbreak IOS 17 and its beta, iOS 17.3, iOS 17.1, ioS 17.2 supported device list Palera1n, unc0ver, chimera, checkm8, taurine, dopamine, xina17, xina, checkra1n Jailbreak Guide](https://github.com/iOS17/Jailbreak/blob/main/IMG_266E30344626-1.jpeg)

# Complete Guide to Jailbreak iOS 17 - iOS 17.5 using Palera1n, Serotonin, NekoJB, Redensa, and Dopamine in 2024

Hey there! **Are you ready to learn how to jailbreak your iOS 17 - iOS 17.8.1** devices(Including iOS 17.1, 17.2, and iOS 17.3+) using the latest **Palera1n, Serotonin, and NekoJB Redensa Dopamine** tools in 2025? Look no further than **our Complete Guide, packed with step-by-step instructions and helpful tips** to make the process a breeze. Get ready to unlock new possibilities on your device!

**Check if your device is compatible with the latest jailbreak tools - [Free Online  iOS 21.2, iOS 18 - iOS 8 Jailbreak Finder App](https://kekuk.com/ipa/jbfinder.php)**

**Please keep in mind that no working jailbreak tools are currently available in the community for iOS 17 - iOS 17.8.1, 18,26.1 and up. However, if you own an iPad (6th generation), you can jailbreak iPadOS 17-17.8.1 and iPadOS 18 with the most recent release of the palera1n jailbreak tool.

![jailbreak iPadOS 17 - 17.6.1 & iPadOS 18 with the most recent release of the palera1n jailbreak tool](https://github.com/user-attachments/assets/41dd4890-8716-4d54-8a12-2c80d2e3cbce)


We strongly recommend staying on the most recently available lower iOS version, as working exploits are available for iOS 17 to iOS 17.8.1.**




Looking to jailbreak iOS 18, 17.8.1 - 16, and below in 2024? Follow this step-by-step guide using the Palera1n tool. Avoid fake methods and achieve full access by following our recommended rootful guide.

To jailbreak your iOS 17 device, you must utilize the Palera1n tool or any other reliable tool derived from its source code. 

**At present, there are no other workable methods available for jailbreaking iOS 16 to iOS 17. Be cautious of misleading information on other platforms, as claims about jailbreaking iOS 16 - 18.1 through different means are false and non-existent.**

For a seamless process, Palera1n initially installs a rootless environment. However, if you'd like complete access, you can refer to the Palera1n Rootful guide for comprehensive instructions on how to get this.

Read More - [The Complete Guide to Palera1n Jailbreak - iOS 17.0 to iOS 17.8.1 AND IOS 18.1 Beta 4](https://github.com/iOS17/Palera1n-Jailbreak/)

## Palera1n Rootful Guide 

1. [Download the Palera1n jailbreak tool](https://github.com/palera1n/palera1n/releases) designed specifically for iPadOS 18 -  iOS 17. [Palera1n Complete Guide](https://zeejb.com/palera1n-jailbreak/)
2. Save the downloaded file to your Desktop for quick access.
3. **Open the terminal application** and execute the following commands. "sudo /bin/sh -c "$(curl -fsSL https://static.palera.in/scripts/install.sh)"
4. Double-click on the palera1n-macos-universal application.
5. Access  → System Preferences → Privacy & Security.
6. In the Security section, permit the palera1n-macos-universal application by selecting "Allow anyway."
7. Open the palera1n-macos-universal app within the terminal.
8. Enter DFU mode​​​​​​​ as instructed on your screen.
9. Carefully follow the provided on-screen instructions.
10. Access the Home Screen and install packages using the Palera1n Loader.

### Palera1n For Linux Guide
1. Download the help.txt
2. Open up a terminal
3. Run "sudo systemctl stop usbmuxd"
4. Then Run "sudo usbmuxd -f -p"
5. Open up a new terminal window
6. Clone the repo with git clone --recursive https://github.com/palera1n/palera1n && cd palera1n *If you’ve already cloned the repo, just run cd palera1n\
7. Run sudo ./palera1n.sh --tweaks <iOS version you're on> --semi-tethered
*Put your device in DFU Mode before running this command
*Put your device in DFU Mode before running this command

We compiled a list of jailbreak guides and information from various websites & community posts. Please note that we are not affiliated with or endorsed by these guides. Our goal is to provide resources that will be useful to you.

[iOS 17.1 Jailbreak Guide Blog](https://zeejb.com/ios-17-1-jailbreak)
[iOS 17.2 Jailbreak Guide Blog](https://zeejb.com/jailbreak-ios-17-2/)

[How To JAILBREAK iOS 17.0 - 17.1 With TWEAKS!](https://www.youtube.com/watch?v=dTLmwSC6Qko)

## iOS 17 - 17.8.1 Serotonin Jailbreak Status:

Serotonin is a tweak injection and/or semi-jailbreak tool developed by [hrtowii1](https://github.com/mineek/Serotonin). 

It is designed for arm64e devices (iPhone XS to iPhone 15 Pro Max) running iOS 16.0 to 16.6.11. It utilizes the KFD exploit from RootHide and Bootstrap to address hooks launched in SpringBoard's posix_spawnp intelligently.

Serotonin then implements its own SpringBoard, using Springboardhook to facilitate various enhancements, tweaks, and loading of Ellekit.

However, Serotonin does not support iOS 17.0 and above devices. The exact reason for this is that no working jailbreak exploit has been released for these versions. This could be due to various factors, such as changes in iOS system architecture, security improvements, or a lack of exploits required for these versions. 

It is also possible that the developers are still working on adding support for these versions. For more accurate information, it is best to check the official sources or contact the developers directly.

## iOS 17 - 17.8.1 / iOS 26.1 beta 4 Redensa Jailbreak Status:

Redensa is not a jailbreak tool. It is a web clip application that works on the iOS Safari browser. Our team has analyzed this web clip app and categorized it as a jailbreak alternative solution. You can install Redensa as a jailbreak solution for iOS 17 - iOS 17.4.1 running devices. However, it is essential to download the web clip application only through verified servers to avoid any security issues.

Moreover, if you come across any new jailbreak tools, you can check their compatibility with your device and iOS version by using the AI Jailbreak Tool released by the Zeejb team. It is the only reliable source to find the best match for your device.


## I. Benefits of Jailbreaking Your iPhone/iPad in iOS 26.1, iOS18.7, iOS 17, iOS 17.1, iOS 17.2, 17.3, 17.4 - 17.8.1:
Jailbreaking your iOS 17 device opens up a whole new world of possibilities. Here are some noteworthy benefits:

## Break Free from Restrictions and Expand Your Device's Capabilities

### Key Benefits of Jailbreaking:

- **Customization:**
    - Personalize your home screen with themes, icons, and layouts.
    - Modify system-wide elements, such as fonts, sounds, and animations.
    - Enhance functionality with custom gestures and shortcuts.
- **App Store Alternatives:**
    - Access a wider range of apps and games not available on the official App Store.
    - Discover niche apps and emulators for retro gaming.
    - Install apps that have been removed from the App Store.
- **System-Level Tweaks:**
    - Enhance performance and battery life with optimized settings.
    - Enhance functionality with features such as call recording and background app refresh.
    - Enhance privacy and security with enhanced controls.
    - Remove unwanted stock apps and features.
 
## The best Jailbreak solutions for iOS 17 and up

Jailbreak solutions play a pivotal role in unleashing the true potential of your iOS device.  These innovative tools offer users the freedom to customize, enhance, and personalize their iPhones and iPads beyond the limitations imposed by Apple's iOS ecosystem. 

| **Name**       | **Description**                                                                                                                                                                   |   **Download Link**                                           | **Supports ARM64** | **Supports ARM64e**|
|:--------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------:|:------------------:|:-------------------:|
| Esign Pro     | Esign Pro is a popular iOS on-device signer, enabling the installation of any IPA file with either a globally available certificate or your developer certificate. Notably, these apps remain installed until your developer certificate expires (1 year). | [Esign Pro](https://esigncert.zeejb.com)                    | ✅                  | ✅                   |
| Appdb Pro     | AppDb Pro is an online IPA installation service, widely known as the easiest way to install IPA files on your device. Its main advantage lies in the up-to-date appdb database, offering many iOS and Mac OS applications. With an Appdb Pro premium membership, you can download over 1000 apps, games, tweaks, and more without limitations. | [Appdb Pro](https://appdbpro.com/download/AppDB-PRO.mobileconfig) | ✅                  | ✅                   |
| 9 Installer   | 9 Installеr (nine Installеr) is a newly released modern app installer and customizer designed for iOS 14 through iOS 26.1, iOS 18.7, iOS 17 - 17.8.1 It offers a wide array of applications available within the jailbreak community. With Nine Installer, you can easily install any of these listed applications on your iPhone and iPad, even on the latest models. | [9 Installer](https://9installer.cobdy.com/9installerFr.mobileconfig) | ✅                  | ✅                   |
| Cripzi Pro     | Cripzi Repo Signer is a newly released online jailbreak solution for beta versions of iOS from iOS 11 to iOS 17 - iOS 26.1, iOS 18.7 It is the most advanced and convenient tool for signing your favorite applications to your phone and iPad                                                         | [Cripzi Pro](https://udidmaster.com/cripzi/Free/Cripzi.mobileconfig) | ✅                  | ✅                   |



_____________________________READ MORE_____________________________________
[Dopamine Jailbreak for iOS 17- iOS 16.7.1/iOS 26.1, iOS 18
](https://github.com/iOS17/Dopamine-Jailbreak)
___________________________________________________________________________


By circumventing restrictions, jailbreaking grants access to a world of possibilities.  Users can install third-party apps, customize their device's appearance, boost performance, and enjoy features that are not available in the official App Store.  From powerful system tweaks to exclusive themes, the possibilities are endless. 

Thе importancе of jailbrеak solutions еxtеnds bеyond pеrsonalization.  Thеy еmpowеr dеvеlopеrs and еnthusiasts to crеatе and sharе thеir applications,  twеaks,  and modifications,  contributing to a vibrant and crеativе community.  This fosters innovation and continually pushes the boundaries of what iOS devices can achieve. 

However, it's essential to approach jailbreaking responsibly, as it involves risks such as security vulnerabilities and warranty concerns.  Yet, for those who seek to unlock the full potential of their devices and are willing to explore this realm of customization, jailbreak solutions remain an invaluable resource.  Jailbreak solutions play a pivotal role in unleashing the true potential of your iOS device.  These innovative tools offer users the freedom to customize, enhance, and personalize their iPhones and iPads beyond the limitations imposed by Apple's iOS ecosystem. 

![image](https://github.com/iOS17/Jailbreak/assets/135683347/23d11ff2-348a-4ace-b601-489ab8517ead)

##iOS 17 Releases :


| Version | Build | Release Date | Release Notes | More Details |
|---|---|---|---|---|
| 17.0 | 21A326 | - | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | - |
| 21A327 | - | September 22, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | Initial release for iPhone 15, iPhone 15 Plus, iPhone 15 Pro, and iPhone 15 Pro Max |
| 21A329 | - | September 18, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | All models except iPhone 15 and 15 Pro |
| 21A331 | - | - | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | iPhone 15 and 15 Pro models only |
| 17.0.1 | 21A340 | September 21, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | Security content |
| 17.0.2 | 21A350 | - | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | iPhone 15 and 15 Pro models only |
| 21A351 | - | September 26, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | All models except iPhone 15 and 15 Pro |
| 17.0.3 | 21A360 | October 4, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | Security content |
| 17.1 | 21B74 | October 25, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | Release notes |
| 21B80 | - | - | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | iPhone 15 and 15 Pro models only |
| 17.1.1 | 21B91 | November 7, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | Release notes |
| 17.2 beta 1 | 21C5029g | October 26, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | - |
| 17.1.2 | 21B101 | November 30, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | Release notes |
| 17.2 RC | 21C62 | December 5, 2023 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | - |
| 17.3 beta 3 | 21D5044a | January 9, 2024 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | - |
| 17.4.1 | 21E236 | March 21, 2024 | [Link to release notes](https://github.com/iOS17/Releases): [Link to more details](https://github.com/iOS17/Releases) | Security updates |
| 17.5 | 21F5048f | 2 April 2024 | [Link to release notes](https://support.apple.com/en-us/118723): [Link to more details](https://support.apple.com/en-us/118723) | New Pride Radiance wallpaper, Apple News enhancements, other features, bug fixes, and security updates |
| 17.5.1 | 21F91 | May 20, 2024 | [Link to release notes](https://support.apple.com/en-us/118723): [Link to more details](https://support.apple.com/en-us/118723) | Important bug fixes, addresses issue with deleted photos reappearing in Photos library |
|17.6 beta 2 | - | - | - |
|17.7.2|21H221 | 19 Nov 2024 | [Link to release notes](https://support.apple.com/en-us/122405): [Link to more details](https://support.apple.com/en-us/118723) |updates to Phone, Messages, and FaceTime that give you new ways to express yourself |


		
Read More : [iPhone 15 jailbreak Guide](https://github.com/JailbreakiPhones/15)




## II. iOS 17 - 17.7.2 - iOS 18 - IOS 26.1	Jailbreak Status:

Grеat nеws! It appears that iOS 17 may have been successfully jailbroken by the CorelliumHQ Team.  They shared this tweet on September 19, 2023, which is just one day after Apple officially released iOS 17.  This suggests that there's a possibility of jailbreaking iOS 17, but we shouldn't expect the jailbreaking tool to be made public anytime soon.  It's worth noting that the CorеlliumHQ Team has posted similar tweets with previous iOS versions but has never released a jailbreak tool.  This implies that it's not a fake jailbreak and might indeed be a legitimate one.  In any case,  this news serves as great motivation for both jailbreak developers and users.  

**
iOS 17.0 is out! 

If you want jailbroken iOS 17, you need Corellium! **

![image](https://github.com/iOS17/Jailbreak/assets/135683347/f98908a6-a598-4eee-93de-81f814a2348b)


The jailbreak community eagerly awaits a reliable and safe jailbreak method for iOS 17. Developers and security researchers are actively finding vulnerabilities and exploits to achieve a jailbreak. Stay updated with the latest news and developments from trusted sources to learn about the current jailbreak status.

## III. iOS 17 - 17.1 beta 3 Jailbreak Possibilities:

Despite the challenges posed by Apple's security measures, the iOS 17 jailbreak community remains resilient. While the possibilities depend on the success of exploiting vulnerabilities, past experiences suggest that features like system-wide theming, advanced customization options, and exclusive app tweaks could be on the horizon.

## IV. How to Prepare Your Device for iOS 17 - 17.1 beta 3 Jailbreak:

Before attempting to jailbreak your iOS 17 device, it is crucial to take some preparatory steps to ensure a smooth and safe experience. 

**These include:**

- Backup: Safeguard your data by creating a complete backup of your device using iCloud or iTunes.
- Update and Compatibility: Install the latest version of iOS 17 and verify your device's compatibility with the jailbreak tool.
- Research: Familiarize yourself with the jailbreak process, compatible tools, and potential risks.
- Remove Security Measures: Temporarily disable any passcodes, Touch ID, or Face ID authentication to prevent conflicts during the jailbreak process.

## Get Ready for Jailbreak: A Step-by-Step Guide

### Checklist for Preparation:

- **Back up your device:** Create a full backup using iCloud or iTunes to safeguard your data in case of any issues.
- **Check compatibility:** Ensure your device is running iOS 17-17.1 beta three and is compatible with the upcoming jailbreak tool.
- **Disable automatic updates:** Prevent your device from automatically installing new iOS versions that might patch vulnerabilities used for jailbreaking.
- **Turn off Find My iPhone:** This feature might interfere with the jailbreak process. You can temporarily disable it in your device settings.
- **Gather necessary tools:** Download and install any required software or apps, such as AltStore or Sideloadly, for sideloading jailbreak apps.
- **Research and choose a jailbreak tool:** Please consider the available jailbreak tools and their compatibility with your device and iOS version.
- **Follow trusted instructions:** When the jailbreak tool is released, carefully follow the instructions provided by the developers to ensure a smooth process.

**Additional tips:**

- **Free up space:** Ensure you have sufficient storage space on your device for the jailbreak process and any additional tweaks.
- **Close unnecessary apps:** Running background apps might consume resources and potentially hinder the jailbreak process.
- **Charge your device:** Ensure your device has a sufficient battery charge to avoid interruptions during the jailbreak.
- **Exercise patience:** Jailbreaking can sometimes involve trial and error, so be patient and don't give up if you encounter initial difficulties.


## V. How to Jailbreak Your iOS 17 Device Safely and Securely:

When it comes to jailbreaking, safety should be a top priority. Follow these general steps to ensure a secure jailbreak experience:

- Verify the Jailbreak Tool: Only download jailbreak tools from reputable sources and verify their authenticity.
- Read Instructions Carefully: Follow the provided instructions meticulously to avoid mistakes or unnecessary risks.
- Stay Updated: Keep an eye on the jailbreak community for the latest tool updates and bug fixes.
- Beware of Tweaks: Be cautious while installing tweaks and modifications, ensuring they come from trusted sources to avoid potential security vulnerabilities.

## VI. Differences Between Tethered and Untethered iOS 17 Jailbreak:

Understanding the distinction between tethered and untethered jailbreaks is crucial for your jailbreaking experience:

### Tethered Jailbreak: 
- Requires the device to be connected to a computer every time it is rebooted.
### Untethered Jailbreak: 
- Allows the device to boot independently without relying on a computer, providing a more convenient experience.


## VII. Best Practices for Maintaining a Jailbroken iOS 17 Device:

Once your iOS 17 device is successfully jailbroken, it's essential to adopt best practices to ensure its stability and security:

- Install Reputable Tweaks: Choose well-established and frequently updated tweaks to minimize compatibility issues and security risks.
- Regularly Update Tweaks: Keep your tweaks up to date to benefit from bug fixes, new features, and enhanced stability.
- Exercise Caution with Sources: Download tweaks from trusted repositories to minimize the risk of malware or malicious modifications.
- Avoid Piracy: Support developers by purchasing tweaks and avoiding pirated versions, which can introduce security vulnerabilities.

## VIII. Future of iOS 17 Jailbreak and Its Impact on the Mobile Industry:

As Apple continues to enhance iOS security, the future of iOS 17 jailbreak remains uncertain. However, the jailbreak community has consistently demonstrated resilience and creativity, driving innovation and pushing the boundaries of what iOS devices can do. While the impact of jailbreaking on the mobile industry is significant, it continues to foster healthy competition and encourage Apple to improve its ecosystem.

## iOS 17.2 (b3)Jailbreak Status:

According to the status of @MasterMike88 X, iOS 17.2 B3 can be jailbroken. He used an iPad 6th Generation (A10-Chip) device to test it. As a result, we can expect the Officeial Palera1n Jailbreak to be available after Apple releases Major iOS 17.2 to the public.

![iOS 17.2 Jailbreak Done Palera1n?](https://github.com/iOS17/Jailbreak/assets/135683347/bfc800ad-eebf-485a-b75e-cdcd91971357)


## Frequently Asked Questions (FAQs):

**General:**

* **Is jailbreaking legal?** Jailbreaking itself is legal in most countries, but installing certain tweaks or pirated apps might be illegal. Check your local laws before proceeding.
* **Is it safe to jailbreak?** While generally safe, jailbreaking can introduce some risks like instability, security vulnerabilities, and potential bricking. Research thoroughly and back up your device before attempting it.
* **Will I lose my warranty by jailbreaking?** Jailbreaking may void your device warranty, so proceed at your own risk. Consider waiting for your warranty to expire before jailbreaking.

**Technical:**

* **Which jailbreak tool should I use?** It depends on your device and iOS version. Research available tools and check their compatibility before choosing one.
* **How can I troubleshoot common jailbreak errors?** Refer to the documentation or community forums of the specific jailbreak tool you used for troubleshooting tips.
* **Can I restore my device to stock after jailbreaking?** Yes, you can usually restore your device to its original state using iTunes or iCloud backup.

**Benefits and Features:**

* **What are some cool tweaks I can install after jailbreaking?** Explore popular tweak repositories for a vast range of customization options, app extensions, and system-level tweaks.
* **Can jailbreaking improve my device's performance?** Certain tweaks can optimize performance and battery life, although results may vary.
* **Can I install alternative app stores like Cydia after jailbreaking?** Yes, Cydia and other alternative app stores offer access to apps and tweaks not found on the official App Store.

## Conclusion: Unleash the Power of Your iOS Device

Jailbreaking opens up a world of possibilities for customizing and expanding the capabilities of your iOS device. While it requires some research and careful

iOS 17 is available on September 18th, 2023 for these devices:

- iPhone 14
- iPhone 14 Plus
- iPhone 14 Pro 
- iPhone 14 Pro Max
- iPhone 13
- iPhone 13 mini
- iPhone 13 Pro
- iPhone 13 Pro Max
- iPhone 12 
- iPhone 12 mini
- iPhone 12 Pro
- iPhone 12 Pro Max
- iPhone 11
- iPhone 11 Pro
- iPhone 11 Pro Max
- iPhone XS
- iPhone XS Max
- iPhone XR 
- iPhone SE (2nd gen or later)
- iPad (6th generation)

# Jailbreak iOS 17: Achievements 
## Palera1n Jailbreak For iOS 17
![image](https://github.com/iOS17/Jailbreak/assets/135683347/f726a760-9bb4-47c8-aedb-12cbb37b57cb)

Can we Jailbreak iOS 17 with palera1n?

Yes, it's possible to jailbreak iOS 17 on Checkm8-supported devices due to an existing hardware vulnerability.  The Palera1n team has recently confirmed that their Palera1n tool now works seamlessly with the latest iOS 17, including iOS 17 beta 3.  Suppose your device runs this particular iOS version and utilizes an A11 chip or lower. In that case, you can use the Palera1n jailbreak method to free your iDevice, allowings you to install both Cydia and Sileo.  Since Checkm8 relies on a hardware-based exploit, it remains unaffected by Apple's attempts to patch the bug through iOS updates.

**
NOTE - The PaleRain team has recently confirmed that the PaleRain Jailbreak isn't currently compatible with the newly released iOS 17 Beta 4.  If you intend to jailbreak iPadOS 17, it's advisable to remain on a version preceding Beta 4 for the time being.  **

[Palera1n Jailbreak Guide](https://zeejb.com/palera1n-jailbreak/)

[Download Palera1n Jailbreak](https://github.com/palera1n/palera1n/tags)