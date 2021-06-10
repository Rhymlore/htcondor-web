---
title: HTCondor 8.6.6 released!
og_title: HTCondor 8.6.6 released!
link: 
date: 2017-09-12
layout: news
---

The HTCondor team is pleased to announce the release of HTCondor 8.6.6. A stable series release contains significant bug fixes.  Highlights of this release are: HTCondor daemons no longer crash on reconfig if syslog is used for logging; HTCondor daemons now reliably leave a core file when killed by a signal; Negotiator won't match machines with incompatible IPv{4,6} protocol; On Ubuntu, send systemd alive messages to avoid restarting HTCondor; Fixed a problem parsing old ClassAd string escapes in the python bindings; Properly parse CPU time for Slurm grid universe jobs; Claims are released when parallel univ jobs are removed while claiming; Starter won't get stuck when a job is removed with JOB_EXIT_HOOK defined; To reduce audit logging, added cgroup rules to SELinux profile.  More details about the fixes can be found in the <a href="http://htcondor.org/manual/v8.6.6/10_3Stable_Release.html">Version History</a>.  HTCondor 8.6.6 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page. 
