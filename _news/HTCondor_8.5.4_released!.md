---
title: HTCondor 8.5.4 released!
og_title: HTCondor 8.5.4 released!
link: 
date: 2016-05-02
layout: news
---

The HTCondor team is pleased to announce the release of HTCondor 8.5.4. This development series release contains new features that are under development. This release contains all of the bug fixes from the 8.4.6 stable release. For sites using partitionable slots, one of the fixes from the 8.4.6 release corrects a serious regression in version 8.5.3.  Highlights of the release are: Fixed a bug that delays schedd response when significant attributes change; Fixed a bug where the group ID was not set in Docker universe jobs; Limit update rate of various attributes to not overload the collector; To make job router configuration easier, added implicit "target" scoping; To make BOSCO work, the blahp does not generate limited proxies by default; condor_status can now display utilization per machine rather than per slot; Improve performance of condor_history and other tools.  Further details can be found in the <a href="manual/v8.5.4/10_2Development_Release.html">Version History</a>. HTCondor 8.5.4 binaries and source code are available from our <a href="downloads/">Downloads</a> page. 