---
layout: subpage
title: Version Numbering Scheme
---

<p>There will be two HTCondor versions available at any given
time, a <strong>"stable series"</strong> version, and a
<strong>"development series"</strong> version.
People expecting a stable
production system should obviously download the stable version; most
people are encouraged to use this version. We will only offer our paid
support for versions of HTCondor from the stable release series.  Only
people who are interested in the latest research, including new
features that haven't been fully tested, should download the
development version. We will make our best effort to ensure that the
development series works, but we can make no guarantees.
</p>

<p>
Every HTCondor version number consists of three period-separated numerals:
<ul>
<li>The first number represents the major version number, and will
change very infrequently.</li>
<li><strong>The second number determines whether a version of HTCondor is
"stable" or "development". Even numbers represent stable versions,
while odd numbers represent development versions.</strong></li>
<li>The final number represents the minor version (aka point release number) within that series.</li>
</ul>
</p>

<p>
So, for example, v8.7.3 would represent the third release in the v8.7 development series, and
v8.8.0 would represent the first release in the v8.8 stable series.
</p>

<p><strong>On the stable series, new minor version releases will only
be made for bug fixes</strong>. No new enhancements will be added to the
stable series in order to minimize any chance of regressions.  Futhermore,
all releases on the same stable series are interoperable within the same
HTCondor pool.
People are encouraged to install new stable versions of
HTCondor when they appear, since they probably fix bugs that affect
you.
</p>

<p>On the development series, new minor version releases will contain all bug fixes to
date from the stable series, plus new features / enhancements.
While we try very hard to make certain releases within the same development series 
are compatible in the same pool, we do not guarantee compatibility like we do
in the stable series (sometimes adding new features requires us to break backwards
compatibility).
</p>

<p>After the feature set of the development series is satisfactory
to the HTCondor Team, we will put a code freeze in place, and from that
point forward only bug fixes will be made to that development
series. When we have fully tested this version, we will release a new
stable series, reset the minor version number, and start work on a new
development release from there.
</p>

<p>For example, 8.2.0, was the first release of the "8.2" stable
series. Some bugs were found and fixed, resulting in release of 8.2.1.
While 8.2.1 was available, we worked on the "8.3" development
series, and soon, a "8.3.0" development version was available for
those who wanted new enhancements. Other versions of 8.3 followed quickly, with lots
of changes, new features, etc.  When the dust settled a year later, we froze the
8.3 series, went into beta testing and finally, when we were happy
with everything, released 8.4.0, the next stable series, containing
all the bug fixes from 8.2.x and all the new features from 8.3.x. At that
point, we began work on the 8.5 development series and the whole
process was repeated...
</p>

<p>As usual, if you have any questions about any of this, please send
them to <A HREF="mailto:htcondor-admin@cs.wisc.edu">htcondor-admin@cs.wisc.edu</A>
</p>