---
layout: default
permalink: /security/
title: HTCondor - HTCondor Security
---

<h2>
  HTCondor Security Resources
</h2>
<p>
This page contains information about security policies and procedures in the HTCondor system.
</p>

<h3> Overview </h3>
<p>
We at HTCondor appreciate the community's efforts to help us find and fix
security problems.  Following these general guidelines will keep things simple
and straightforward.
<p>


<h3>Duration of Support</h3>
<p>
HTCondor will provide security fixes for the current stable series.  After
beginning a new stable series, we will also continue to support the previous
stable series for six months.  Please see our online manual on the
<a href="https://htcondor.readthedocs.io/en/latest/version-history/introduction-version-history.html#htcondor-version-number-scheme">
HTCondor Version Number Scheme</a> for more information.
<p>


<h3> Discovery and Reporting </h3>
<p>
If you suspect or have confirmed a security problem with the HTCondor software,
please email us at <a href="email:htcondor-security@cs.wisc.edu">htcondor-security@cs.wisc.edu</a>.
As the person who discovered the vulnerability, we will work with you to
establish a mutally agreeable timeline for announcing the vulnerability and
releasing a new version.
</p>

<p>
Given the nature of security vulnerabilities, we prefer that you keep your
findings strictly confidential.  Please work with the HTCondor team to assess
the full impact and create a timeline.
<p>


<h3> Fixing the Problem </h3>
<p>
It is the responsiblity of the HTCondor developers to fix the problem.
However, you may send your patch to
<a href="email:htcondor-security@cs.wisc.edu">htcondor-security@cs.wisc.edu</a>
for review by the HTCondor developers.
</p>


<h3> Coordinating with Downstream Providers </h3>
<p>
Before the public announcment, the HTCondor team will coordinate with
downstream providers of the HTCondor software to let them know a new release is
imminent, and we may provide updated source code and/or binaries to
various parties at our discretion.
</p>

<h3> Publicly Announcing and Releasing </h3>
<p>
All public announcements will be made Monday through Thursday between 9AM and
5PM central time.  The announcement will be sent to the HTCondor-users and
HTCondor-world mailing lists; the HTCondor team keeps a web page listing
<a href="{{ '/security/vulnerabilities/' | relative_url }}">all
announced vulnerabilities</a>.
</p>

<p>
When announcing the existence of a vulnerability, we will supply high-level
details.  The idea is to give just enough
information so people can assess their risk and exposure, without giving away
enough information to actually exploit the problem.  These goals can be at odds
with each other, and we generally tend towards being more vague if there is
such a conflict.
</p>

<p>
The binaries and source code that fix the problem will be available from the
HTCondor download page when the announcement is made.
</p>


<h3> Embargo </h3>
<p>
After publicly announcing the vulnerability and making the new version available,
the full details will be embargoed for a minimum of 30 days.  The embargo will
be lifted at a date that is agreed upon by the HTCondor team and the person
reporting the vulnerability.  After that point, full details may be made public
by any party and the vulnerability report posted on the HTCondor web site will
be updated.
</p>