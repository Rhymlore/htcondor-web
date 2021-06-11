---
title: condor_status bug in 6.1.10 found
og_title: condor_status bug in 6.1.10 found
link: 
date: 1999-11-01
layout: news
---

Condor version 6.1.10 contains a minor bug in the condor_status program.  For some sites, this causes condor_status to have a segmentation fault, be killed by SIGSEGV, and to drop a core file when trying to display the totals at the end of condor_status.  If you are upgrading to 6.1.10 from a previous version, please save your old condor_status binary and install that into your Condor bin directory once you have completed your upgrade.  Version 6.1.11 will fix this bug.
