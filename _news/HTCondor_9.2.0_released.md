---
title: HTCondor 9.2.0 released!
og_title: HTCondor 9.2.0 released!
link: 
date: 2021-09-23
layout: news
release_type: HTCondor
release_number: 9.2.0
---

The HTCondor team is pleased to announce the release of HTCondor 9.2.0.
This release contains all of the bug fixes from the 9.0.6 LTS release
and the 9.1.4, 9.1.5, 9.1.6 limited patch releases.

Enhancements in the release include:
- Add SERVICE node that runs alongside the DAG for the duration of the DAG
- Fix problem where proxy delegation to older HTCondor versions failed
- Jobs are now re-run if the execute directory unexpectedly disappears
- HTCondor counts the number of files transfered at the submit node
- Fix a bug that caused jobs to fail when using newer Singularity versions

A complete list of new features and fixed bugs can be found in the <a href="https://htcondor.readthedocs.io/en/v9_1/version-history/development-release-series-91.html#version-9-2-0"> Development Version History</a> and the <a href="https://htcondor.readthedocs.io/en/v9_1/version-history/stable-release-series-90.html#version-9-0-6"> Stable Version History</a>.

HTCondor 9.2.0 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page.
