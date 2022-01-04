---
title: HTCondor 9.0.8 released!
og_title: HTCondor 9.0.8 released!
link: 
date: 2021-12-02
layout: news
release_type: HTCondor
release_number: 9.0.8
---

The HTCondor Team is pleased to announce the HTCondor 9.0.8 LTS release.
A Long Term Support (LTS) release contains significant bug fixes.

Highlights of this release are:
- Fix bug where huge values of ImageSize and others would end up negative
- Fix bug in how MAX\_JOBS\_PER\_OWNER applied to late materialization jobs
- Fix bug where the schedd could choose a slot with insufficient disk space
- Fix crash in ClassAd substr() function when the offset is out of range
- Fix bug in Kerberos code that can crash on macOS and could leak memory
- Fix bug where a job is ignored for 20 minutes if the startd claim fails

More details about the fixes can be found in the <a href="https://htcondor.readthedocs.io/en/v9_0/version-history/stable-release-series-90.html#version-9-0-8"> Version History</a>.

HTCondor 9.0.8 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page.
