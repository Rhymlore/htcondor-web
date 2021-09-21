---
title: HTCondor 8.2.10 released!
og_title: HTCondor 8.2.10 released!
link: 
date: 2015-10-22
layout: news
release_type: HTCondor
release_number: 8.2.10
---

The HTCondor team is pleased to announce the release of HTCondor 8.2.10. A stable series release contains significant bug fixes.  Highlights of this release are: an updated RPM to work with SELinux on EL7 platforms; fixes to the condor_kbdd authentication to the X server; a fix to allow the condor_kbdd to work with shared port enabled; avoid crashes when using more than 1024 file descriptors on EL7; fixed a memory leak in the ClassAd split() function; condor_vacate will error out rather than ignore conflicting arguments; a bug fix to the JobRouter to properly process the queue on restart; a bug fix to prevent sending spurious data on a SOAP file transfer; a bug fix to always present jobs in order in condor_history.  A complete list of fixed bugs can be found in the <a href="manual/v8.2.10/10_3Stable_Release.html">Version History</a>. HTCondor 8.2.10 binaries and source code are available from our <a href="downloads/">Downloads</a> page. 
