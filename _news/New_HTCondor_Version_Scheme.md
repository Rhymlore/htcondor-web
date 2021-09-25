---
title: New HTCondor Version Scheme
og_title: New HTCondor Version Scheme
link: 
date: 2021-09-22
layout: news
---

Starting with HTCondor 9.2.0, HTCondor will adopt a new version scheme to
facilitate quicker patch releases.  The version number will still retain the
MAJOR.MINOR.PATCH form with slightly different meanings.

- The MAJOR number increments for each new Long Term Support (LTS) release.
A new LTS release may have backward-incompatible changes and may require
updates to configuration files.  The current LTS release is 9.0.6.
The next one will be 10.0.0.

- The MINOR number increments during the development of new features. This
number stays at 0 for LTS releases. The current release is 9.2.0.

- The PATCH number increments when we have targeted fixes.  If there is a
specific need to be addressed before 9.3.0 is tested and ready, we would
issue a 9.2.1 patch release.  Patch releases for the LTS are fully reviewed
and tested for a seamless upgrade.

These releases will be served out of three repositories.
- The LTS release and its patches (X.0.Z) are in the existing Stable channel.
- The development releases (X.Y.0) are in the existing Current channel.
- A new Updates channel will contain development patch releases (X.Y.Z).

