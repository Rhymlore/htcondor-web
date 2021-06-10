---
title: Condor 7.7.1 released!
og_title: Condor 7.7.1 released!
link: 
date: 2011-09-12
layout: news
---

The Condor team is pleased to announce the release of Condor 7.7.1.  This is the second release in the development series.  This release of Condor now dynamically links the executables to the system security libraries, including openssl.  In the past, these libraries have been statically linked into the binaries.  As a result, system security updates will immediately benefit Condor.  The downside is that binaries built for a given platform may not be as portable to other platforms as in the past.  We have also seen a very rare, intermittent problem with DAGMan where the DAGMan program will ignore a successful job completion, and wait forever.  We hope to resolve this problem in the next development release.  The <a href="manual/latest-dev/9_Version_History.html">Version History</a>  has a list of the major changes.  Condor binaries and source code are available  from <a href="downloads/">our Downloads page.</a> 
