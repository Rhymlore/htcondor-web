---
layout: Markdown
permalink:
title: HTCSS Security
---

This page contains information about security policies and procedures in the HTCSS.


### Overview

We at HTCondor appreciate the community's efforts to help us find and fix
security problems.  Following these general guidelines will keep things simple
and straightforward.

### Duration of Support

HTCondor will provide security fixes for the current stable series.  After
beginning a new stable series, we will also continue to support the previous
stable series for six months.  Please see our online manual on the
<a href="https://htcondor.readthedocs.io/en/latest/version-history/introduction-version-history.html#htcondor-version-number-scheme">
HTCondor Version Number Scheme</a> for more information.


### Discovery and Reporting

If you suspect or have confirmed a security problem with the HTCondor software,
please email us at <a href="email:htcondor-security@cs.wisc.edu">htcondor-security@cs.wisc.edu</a>.
As the person who discovered the vulnerability, we will work with you to
establish a mutally agreeable timeline for announcing the vulnerability and
releasing a new version.

Given the nature of security vulnerabilities, we prefer that you keep your
findings strictly confidential.  Please work with the HTCondor team to assess
the full impact and create a timeline.

### Fixing the Problem

It is the responsiblity of the HTCondor developers to fix the problem.
However, you may send your patch to
<a href="email:htcondor-security@cs.wisc.edu">htcondor-security@cs.wisc.edu</a>
for review by the HTCondor developers.



### Coordinating with Downstream Providers

Before the public announcment, the HTCondor team will coordinate with
downstream providers of the HTCondor software to let them know a new release is
imminent, and we may provide updated source code and/or binaries to
various parties at our discretion.


### Publicly Announcing and Releasing

All public announcements will be made Monday through Thursday between 9AM and
5PM central time.  The announcement will be sent to the HTCondor-users and
HTCondor-world mailing lists; the HTCondor team keeps a web page listing
<a href="{{ '/security/vulnerabilities/' | relative_url }}">all
announced vulnerabilities</a>.

When announcing the existence of a vulnerability, we will supply high-level
details.  The idea is to give just enough
information so people can assess their risk and exposure, without giving away
enough information to actually exploit the problem.  These goals can be at odds
with each other, and we generally tend towards being more vague if there is
such a conflict.

The binaries and source code that fix the problem will be available from the
HTCondor download page when the announcement is made.


### Embargo

After publicly announcing the vulnerability and making the new version available,
the full details will be embargoed for a minimum of 30 days.  The embargo will
be lifted at a date that is agreed upon by the HTCondor team and the person
reporting the vulnerability.  After that point, full details may be made public
by any party and the vulnerability report posted on the HTCondor web site will
be updated.
