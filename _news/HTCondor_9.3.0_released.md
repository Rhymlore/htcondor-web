---
title: HTCondor 9.3.0 released!
og_title: HTCondor 9.3.0 released!
link: 
date: 2021-11-03
layout: news
release_type: HTCondor
release_number: 9.3.0
---

The HTCondor team is pleased to announce the release of HTCondor 9.3.0.
This release contains all of the bug fixes from the 9.0.7 LTS release.

NOTE: Globus GSI has been removed from this release. If you are currently
using GSI, you must migrate to a different authorization mechanism.

Enhancements in the release include:
- Discontinue support for Globus GSI
- Discontinue support for grid type 'nordugrid', use 'arc' instead
- MacOS version strings now include the major version number (10 or 11)
- File transfer plugin sample code to aid in developing new plugins
- Add generic knob to set the slot user for all slots

A complete list of new features and fixed bugs can be found in the <a href="https://htcondor.readthedocs.io/en/v9_1/version-history/development-release-series-91.html#version-9-3-0">Version History</a>.

HTCondor 9.3.0 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page.
