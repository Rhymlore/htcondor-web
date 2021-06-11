---
title: HTCondor 8.8.11 released!
og_title: HTCondor 8.8.11 released!
link: 
date: 2020-10-21
layout: news
---

The HTCondor team is pleased to announce the release of HTCondor 8.8.11. A stable series release contains significant bug fixes.  Highlights of this release are: HTCondor now properly tracks usage over vanilla universe checkpoints; New ClassAd equality and inequality operators in the Python bindings; Fixed a bug where removing in-use routes could crash the job router; Fixed a bug where condor_chirp would abort after success on Windows; Fixed a bug where using MACHINE_RESOURCE_NAMES could crash the startd; Improved condor c-gahp to prioritize commands over file transfers; Fixed a rare crash in the schedd when running many local universe jobs; With GSI, avoid unnecessary reverse DNS lookup when HOST_ALIAS is set; Fix a bug that could cause grid universe jobs to fail upon proxy refresh.  More details about the fixes can be found in the <a href="https://htcondor.readthedocs.io/en/v8_8/version-history/stable-release-series-88.html#version-8-8-11"> Version History</a>.  HTCondor 8.8.11 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page. 
