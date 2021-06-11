---
title: Checkpointing bug in Condor Version 6.1.9
og_title: Checkpointing bug in Condor Version 6.1.9
link: 
date: 1999-11-01
layout: news
---

Condor 6.1.9 contains a bug in the checkpointing code for "standard" jobs.  Once a job checkpoints for the first time, it will no longer be able to checkpoint again.  If you are using the standard universe (relinking your jobs with condor_compile), you are going to have problems with 6.1.9.  A new version will be released very soon to fix this bug.
