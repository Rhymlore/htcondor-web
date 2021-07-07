---
title: HTCondor 8.8.9 released!
og_title: HTCondor 8.8.9 released!
link: 
date: 2020-05-07
layout: news
---

The HTCondor team is pleased to announce the release of HTCondor 8.8.9. A stable series release contains significant bug fixes.  Highlights of this release are: Proper tracking of maximum memory used by Docker universe jobs Fixed preempting a GPU slot for a GPU job when all GPUs are in use; Fixed a Python crash when queue_item_data iterator raises an exception; Fixed a bug where slot attribute overrides were ignored; Calculates accounting group quota correctly when more than 1 CPU requested; Updated HTCondor Annex to accommodate API change for AWS Spot Fleet; Fixed a problem where HTCondor would not start on AWS Fargate; Fixed where the collector could wait forever for a partial message; Fixed streaming output to large files (>2Gb) when using the 32-bit shadow.  More details about the fixes can be found in the <a href="http://htcondor.org/manual/v8.8.9/StableReleaseSeries88.html"> Version History</a>.  HTCondor 8.8.9 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page. 