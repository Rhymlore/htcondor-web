---
title: HTCondor 8.9.12 released!
og_title: HTCondor 8.9.12 released!
link: 
date: 2021-03-25
layout: news
release_type: HTCondor
release_number: 8.9.12
---

The HTCondor team is pleased to announce the release of HTCondor 8.9.12. This development series release contains new features that are under development. This release contains all of the bug fixes from the 8.8.13 stable release.  WARNING: We have changed the default security model in this release. It is not a drop-in replacement for any earlier release. Please read the <a href="https://htcondor-wiki.cs.wisc.edu/index.cgi/wiki?p=UpgradingToEightNineTwelve">notes</a> before proceeding with an upgrade. Manual intervention may be required.   Enhancements in the release include: Host based security is no longer the default security model; Hardware accelerated integrity and AES encryption used by default; Normally, AES encryption is used for all communication and file transfers; Fallback to Triple-DES or Blowfish when interoperating with older versions; Simplified and automated new HTCondor installations; HTCondor now detects instances of multi-instance GPUs; Fixed memory leaks (collector updates in 8.9 could leak a few MB per day); Many other enhancements and bug fixes, see version history for details.  A complete list of new features and fixed bugs can be found in the version history.  Try out our  <a href="https://htcondor.readthedocs.io/en/latest/getting-htcondor/index.html"> new helpful installation scripts</a>.  Further details can be found in the <a href="https://htcondor.readthedocs.io/en/latest/version-history/development-release-series-89.html#version-8-9-12"> Development Version History</a> and the <a href="https://htcondor.readthedocs.io/en/latest/version-history/stable-release-series-88.html#version-8-8-13"> Stable Version History</a>. HTCondor 8.9.12 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page. 
