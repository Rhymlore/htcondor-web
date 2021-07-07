---
title: HTCondor 8.8.2 released!
og_title: HTCondor 8.8.2 released!
link: 
date: 2019-04-11
layout: news
---

The HTCondor team is pleased to announce the release of HTCondor 8.8.2. A stable series release contains significant bug fixes.  Highlights of this release are: Fixed problems with condor_ssh_to_job and Singularity jobs; Fixed a problem that could cause condor_annex to crash; Fixed a problem where the job queue would very rarely be corrupted; condor_userprio can report concurrency limits again; Fixed the GPU discovery and monitoring code to map GPUs in the same way; Made the CHIRP_DELAYED_UPDATE_PREFIX configuration knob work again; Fixed restarting HTCondor from the Service Control Manager on Windows; Fixed a problem where local universe jobs could not use condor_submit; Restored a deprecated Python interface that is used to read the event log; Fixed a problem where condor_shadow reuse could confuse DAGMan.  More details about the fixes can be found in the <a href="http://htcondor.org/manual/v8.8.2/StableReleaseSeries88.html"> Version History</a>.  HTCondor 8.8.2 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page. 