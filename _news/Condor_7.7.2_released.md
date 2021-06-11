---
title: Condor 7.7.2 released
og_title: Condor 7.7.2 released
link: 
date: 2011-10-12
layout: news
---

The Condor team is pleased to announce the release of Condor version 7.7.2.  This is the third release in the development series.  This release dynamically links more libraries than before, resulting in a 30 percent decrease in download size on most operating systems.  Please be aware that due to a difference in older condor_master binaries, condor_masters older than 7.7.2, including all 7.6 releases, can not re-exec a 7.7.2 master.  That is, if you try to upgrade a pre-7.7.2 system just by copying over binaries, the condor_master will shutdown, and must be manually restarted.  7.7.2 masters can re-exec themselves without incident.  The <a href="manual/latest-dev/9_Version_History.html">Version History</a>  has a list of the major changes.  Condor binaries and source code are available from <a href="downloads/">our Downloads page.</a> 
