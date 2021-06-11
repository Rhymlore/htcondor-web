---
title: HTCondor 8.4.5 released!
og_title: HTCondor 8.4.5 released!
link: 
date: 2016-03-22
layout: news
---

The HTCondor team is pleased to announce the release of HTCondor 8.4.5. A stable series release contains significant bug fixes.  Highlights of this release are: fixed a bug that would cause the condor_schedd to send no flocked jobs; fixed a bug that caused a 60 second delay using tools when DNS lookup failed; prevent using accounting groups with embedded spaces that crash the negotiator; fixed a bug that could cause use of ports outside the port range on Windows; fixed a bug that could prevent dynamic slot reuse when using many slots; fixed a bug that prevented correct utilization reports from the job router; tune kernel when using cgroups to avoid OOM killing of jobs doing heavy I/O; a few other bug fixes, consult the version history.  Further details can be found in the <a href="manual/v8.4.5/10_3Stable_Release.html">Version History</a>. HTCondor 8.4.5 binaries and source code are available from our <a href="downloads/">Downloads</a> page. 
