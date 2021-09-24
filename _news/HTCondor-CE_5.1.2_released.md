---
title: HTCondor-CE 5.1.2 released!
og_title: HTCondor-CE 5.1.2 released!
link: 
date: 2021-09-23
layout: news
release_type: HTCondor-CE
release_number: 5.1.2
---

The HTCondor team is pleased to announce the release of HTCondor-CE 5.1.2.

Highlights of this release are:
- Fixed the default memory and CPU requests when using job router transforms
- Apply default MaxJobs and MaxJobsIdle when using job router transforms
- Improved SciTokens support in submission tools
- Fixed --debug flag in condor\_ce\_run
- Update configuration verification script to handle job router transforms
- Corrected ownership of the HTCondor PER\_JOBS\_HISTORY\_DIR
- Fix bug passing maximum wall time requests to the local batch system

A complete list of new features and fixed bugs can be found in the <a href="https://htcondor.github.io/htcondor-ce/v5/releases/#512"> version history</a>.

HTCondor-CE 5.1.2 binaries are available from our <a href="http://htcondor.org/yum/">YUM Repository</a>.
