---
title: Condor Version 6.1.15 released!
og_title: <a href=\"downloads/\">Condor Version 6.1.15 released!</a>
link: downloads/
date: 2000-08-01
layout: news
---

As our 6.1 development series winds down, we have released 6.1.15 which provides several enhancements, as well as numerous bug fixes, including the fix that avoids the 2.2.14 Linux kernel bug. <p> For complete details, you can read about <a href="manual/latest-dev/9_Version_History.html">what's new</a> in this version.  <hr> If you install the Unix version of Condor 6.1.15 into a new pool, you will have ADD the following three lines into your condor_config.local file on your central manger: <pre>DAEMON_LIST   = MASTER, COLLECTOR, NEGOTIATOR, STARTD, SCHEDD COLLECTOR     = $(SBIN)/condor_collector NEGOTIATOR    = $(SBIN)/condor_negotiator</pre> Naturally, if you run fewer things on your central manager, you should take them out of the DAEMON_LIST.