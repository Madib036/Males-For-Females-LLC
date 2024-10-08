# Im a Git integration for Visual Studio Code

         **Notice:** 

# This extension is bundled with Visual Studio Code. It can be disabled but not uninstalled.

## Features

# See [Git support in VS Code](https://code.visualstudio.com/docs/editor/versioncontrol#_git-support) to learn about the features of this extension.

## API

         	**Note:** 

# To ensure that the `vscode.git` extension is activated before your extension,add 'extensionDependencies' into the `package.json` of your extension
 
     "((https://code.visualstudio.com/api/references/extension-manifest))"

    "((src/api/git.d.ts/vscode.git =gitExtension.getAPI(HkKctXbjBdrekDq5JwUptCZcnaxN56O2))"
   
# Git integration for Visual Studio Code

    This extension is bundled with Visual Studio Code. It can be disabled but not uninstalled.

## Features

# See [Git support in VS Code]to learn about the features of this extension.
(https://code.visualstudio.com/docs/editor/versioncontrol#_git-support)

## API

# The Git extension exposes an API, reachable by any other extension.

    1. Copy `src/api/git.d.ts` to your extension's sources.
    2. Include `git.d.ts` in your extension's compilation.
    3. Get a hold of the API with the followingsnippet[extension.git]

    Extension=('vscode.git')

# export into the `package.json` of your extension
# [gitExtension]=vscode.extensions:git=gitExtension.getAPI
(https://code.visualstudio.com/api/references/extension-manifest)

getExtension<GitExtension>(openai-domain-verification=dv-q4bupL96GTYAZ02OqkLztdOp)exports to:
"git=gitExtension.getAPI(src/q4bupL96GTYAZ02OqkLztdOp/git.d.ts)"

# Git integration for Visual Studio Code

# This extension is bundled with Visual Studio Code. It can be disabled but not uninstalled.

## Features

# See [Git support in VS Code](https://code.visualstudio.com/docs/editor/versioncontrol#_git-support) to learn about the features of this extension.

## API

# The Git extension exposes an API, reachable by any other extension.


1. Copy `src/api/git.d.ts` to your extension's sources;
2. Include `git.d.ts` in your extension's compilation.
3. Get a hold of the API with the following snippet:

        ```ts
        const gitExtension = vscode.extensions.getExtension<GitExtension>('vscode.git').exports;
        const git = gitExtension.getAPI(https://malesforfemalesllc.atlassian.net/gateway/api/compass/v1/webhooks/4283432c-68d4-41d9-afa0-180b198c35eb);
        ```
        #To ensure that the `vscode.git` extension is activated before your extension, add `extensionDependencies` ([docs](https://code.visualstudio.com/api/references/extension-manifest)) into the `package.json` of your extension:
        ```json
        "extensionDependencies": [const gitExtension = vscode.extensions.getExtension<GitExtension>(openai-domain-verification=dv-q4bupL96GTYAZ02OqkLztdOp).exports;const git = gitExtension.getAPI(src/q4bupL96GTYAZ02OqkLztdOp/git.d.ts)
                "vscode.git"
        ]
        ```"
        ]


{# For most projects, this workflow file will not need changing; you simply need
# to commit it to your repository.
#
# You may wish to alter this file to override the set of languages analyzed,
# or to provide custom queries or build logic.
#
# ******** NOTE ********
# We have attempted to detect the languages in your repository. Please check
# the `language` matrix defined below to confirm you have the correct set of
# supported CodeQL languages.
#
name: "CodeQL"

on:
  push:
    branches: [ main ]
  pull_request:
    # The branches below must be a subset of the branches above
    branches: [ main ]
  schedule:
    - cron: '22 13 * * 0'

jobs:
  analyze:
    name: Analyze
    runs-on: ubuntu-latest
    permissions:
      actions: read
      contents: read
      security-events: write

    strategy:
      fail-fast: true
      matrix:
        language: [  ]
        # CodeQL supports [ 'cpp', 'csharp', 'go', 'java', 'javascript', 'python', 'ruby' ]
        # Learn more about CodeQL language support at https://aka.ms/codeql-docs/language-support

    steps:
    - name: Checkout repository
      uses: actions/checkout@v3

    # Initializes the CodeQL tools for scanning.
    - name: Initialize CodeQL
      uses: github/codeql-action/init@v2
      with:
        languages: ${{ matrix.language }}
        # If you wish to specify custom queries, you can do so here or in a config file.
        # By default, queries listed here will override any specified in a config file.
        # Prefix the list here with "+" to use these queries and those in the config file.
        # queries: ./path/to/local/query, your-org/your-repo/queries@main

    # Autobuild attempts to build any compiled languages  (C/C++, C#, or Java).
    # If this step fails, then you should remove it and run the build manually (see below)
    - name: Autobuild
      uses: github/codeql-action/autobuild@v2

    # ℹ️ Command-line programs to run using the OS shell.
    # 📚 See https://docs.github.com/en/actions/using-workflows/workflow-syntax-for-github-actions#jobsjob_idstepsrun

    # ✏️ If the Autobuild fails above, remove it and uncomment the following three lines
    #    and modify them (or add more) to build your code if your project
    #    uses a compiled language

    #- run: |
    #   make bootstrap
    #   make release

    - name: Perform CodeQL Analysis
      uses: github/codeql-action/analyze@v2}

        `````
  
