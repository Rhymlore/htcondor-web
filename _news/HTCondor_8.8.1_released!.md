---
title: HTCondor 8.8.1 released!
og_title: HTCondor 8.8.1 released!
link: 
date: 2019-02-19
layout: news
release_type: HTCondor
release_number: 8.8.1
---

The HTCondor team is pleased to announce the release of HTCondor 8.8.1. A stable series release contains significant bug fixes.  Highlights of this release are: Fixed excessive CPU consumption with GPU monitoring; GPU monitoring is off by default; enable with "use feature: GPUsMonitor"; HTCondor now works with the new CUDA version 10 libraries; Fixed a bug where sometimes jobs would not start on a Windows execute node; Fixed a bug that could cause DAGman to go into an infinite loop on exit; The JobRouter doesn't forward the USER attribute between two UID Domains; Made Collector.locateAll() more efficient in the Python bindings; Improved efficiency of the negotiation code in the condor_schedd.  More details about the fixes can be found in the <a href="http://htcondor.org/manual/v8.8.1/StableReleaseSeries88.html"> Version History</a>.  HTCondor 8.8.1 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page. 
