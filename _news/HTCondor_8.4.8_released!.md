---
title: HTCondor 8.4.8 released!
og_title: HTCondor 8.4.8 released!
link: 
date: 2016-07-05
layout: news
release_type: HTCondor
release_number: 8.4.8
---

The HTCondor team is pleased to announce the release of HTCondor 8.4.8. A stable series release contains significant bug fixes.  Highlights of this release are: Fixed a memory leak triggered by the python htcondor.Schedd().query() call; Fixed a bug that could cause Bosco file transfers to fail; Fixed a bug that could cause the schedd to crash when using schedd cron jobs; condor_schedd now rejects jobs when owner has no account on the machine; Fixed a new bug in 8.4.7 where remote condor_history failed without -limit; Fixed bugs triggered by the reconfiguration of the high-availability daemon; Fixed a bug where condor_master could hang when using shared port on Windows; Fixed a bug with the -xml option on condor_q and condor_status; A few other bug fixes, consult the version history.  Further details can be found in the <a href="manual/v8.4.8/10_3Stable_Release.html">Version History</a>. HTCondor 8.4.8 binaries and source code are available from our <a href="downloads/">Downloads</a> page. 
