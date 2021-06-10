---
title: Condor Version 6.0.3 Released
og_title: <a href=\"downloads/\">Condor Version 6.0.3 Released</a>
link: downloads/
date: 1998-11-01
layout: news
---

This is the new, stable version of Condor.  It fully supports Solaris 2.5.1 and 2.6 on Intel and Sparc platforms, Linux for Intel (libc5 and glibc), SGI IRIX 6.2 through 6.4, Digital Unix 4.0, and HPUX 10.20. You can read about <a href="manual/latest-stable/9_Version_History.html">what's new</a> in this version.  This version only fixes bugs in Condor's interaction with NIS, and with the benchmarking code that was causing a floating point exception (SIGFPE) on extremely fast machines (like the fastest Alphas).  If you don't use NIS, or you weren't having problems with the condor_startd exiting with signal 8, there's no need to upgrade.
