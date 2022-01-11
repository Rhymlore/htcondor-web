---
title: Serious bug in v6.9.4 impacts standard universe jobs
og_title: Serious bug in v6.9.4 impacts standard universe jobs
link: 
date: 2007-10-19
layout: news
---

A bug introduced in the most recent developer release, Condor v6.9.4, can cause jobs running in Condor's Standard Universe to write corrupt data.  The Condor Team has written a patch that will be included in v6.9.5 which is forthcoming; if you need the patch sooner, please <a href="htcondor-support/" data-proofer-ignore>contact us</a>.  This bug only impacts jobs that write binary (non-ASCII) files and are submitted to the Standard Universe.
