---
title: HTCondor 9.0.5 released!
og_title: HTCondor 9.0.5 released!
link: 
date: 2021-08-18
layout: news
release_type: HTCondor
release_number: 9.0.5
---

The HTCondor team is pleased to announce the release of HTCondor 9.0.5.
A stable series release contains significant bug fixes.

Highlights of this release are:
- Other authentication methods are tried if mapping fails using SciTokens
- Fix rare crashes from successful condor\_submit, which caused DAGMan issues
- Fix bug where ExitCode attribute would be suppressed when OnExitHold fired
- condor\_who now suppresses spurious warnings coming from netstat
- The online manual now has detailed instructions for installing on MacOS
- Fix bug where misconfigured MIG devices confused condor\_gpu\_discovery
- The transfer\_checkpoint\_file list may now include input files

More details about the fixes can be found in the <a href="https://htcondor.readthedocs.io/en/v9_0/version-history/stable-release-series-90.html#version-9-0-5"> Version History</a>.

HTCondor 9.0.5 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page. 
