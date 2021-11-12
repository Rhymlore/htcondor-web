---
title: HTCondor 9.0.7 released!
og_title: HTCondor 9.0.7 released!
link: 
date: 2021-11-02
layout: news
release_type: HTCondor
release_number: 9.0.7
---

The HTCondor Team is pleased to announce the HTCondor 9.0.7 LTS release.
A Long Term Support (LTS) release contains significant bug fixes.

Highlights of this release are:
- Fix bug where condor\_gpu\_discovery could crash with older CUDA libraries
- Fix bug where condor\_watch\_q would fail on machines with older kernels
- condor\_watch\_q no longer has a limit on the number of job event log files
- Fix bug where a startd could crash claiming a slot with p-slot preemption
- Fix bug where a job start would not be recorded when a shadow reconnects

More details about the fixes can be found in the <a href="https://htcondor.readthedocs.io/en/v9_0/version-history/stable-release-series-90.html#version-9-0-7"> Version History</a>.

HTCondor 9.0.7 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page.
