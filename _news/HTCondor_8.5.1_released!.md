---
title: HTCondor 8.5.1 released!
og_title: HTCondor 8.5.1 released!
link: 
date: 2015-12-21
layout: news
---

The HTCondor team is pleased to announce the release of HTCondor 8.5.1. This development series release contains new features that are under development. This release contains all of the bug fixes from the 8.4.3 stable release.  Enhancements in the release include: the shared port daemon is enabled by default; the condor_startd now records the peak memory usage instead of recent; the condor_startd advertises CPU submodel and cache size; authorizations are automatically setup when "Match Password" is enabled; added a schedd-constraint option to condor_q.  With the shared port daemon enabled, all HTCondor daemons share a single inbound network port. This change makes it much easier to construct a firewall configuration that allows HTCondor use.  Further details can be found in the <a href="manual/v8.5.1/10_2Development_Release.html">Version History</a>. HTCondor 8.5.1 binaries and source code are available from our <a href="downloads/">Downloads</a> page. 