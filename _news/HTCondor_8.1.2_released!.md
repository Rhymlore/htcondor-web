---
title: HTCondor 8.1.2 released!
og_title: HTCondor 8.1.2 released!
link: 
date: 2013-10-31
layout: news
release_type: HTCondor
release_number: 8.1.2
---

The HTCondor team is pleased to announce the release of HTCondor 8.1.2. This development release contains all the bug fixes from the stable release version 8.0.4. Major new features include: partitionable slots can now be split into dynamic slots at negotiation time using new consumption policies; new condor_chirp commands permit updates to job ClassAd attributes to occur in a delayed fashion, reducing the overhead of making the update; there are many Python binding improvements including a new Negotiator class; condor_ssh_to_job now works for grid universe jobs on amazon EC2 resources; new command line options for condor_config_val and condor_history allow them to query remote machines; increased the scalability of the condor_shared_port daemon, condor_queue, and condor_status by increasing concurrency. A complete list of bugs fixed and features can be found in the  <a href="manual/v8.1.2/10_3Development_Release.html">Version History</a>. HTCondor 8.1.2 binaries and source code are available from our <a href="downloads/">Downloads</a> page. 
