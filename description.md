---
layout: subpage
title: What is HTCondor?
---

<p>
HTCondor is a specialized workload management system for compute-intensive
jobs.  Like other full-featured batch systems, HTCondor provides a job
queueing mechanism, scheduling policy, priority scheme, resource monitoring,
and resource management.  Users submit their serial or parallel jobs to
HTCondor, HTCondor places them into a queue, chooses when and where to run
the jobs based upon a policy, carefully monitors their progress, and ultimately
informs the user upon completion.
<p>
While providing functionality similar to that of a more traditional batch
queueing system, HTCondor's novel architecture allows it to succeed in areas
where traditional scheduling systems fail.  HTCondor can be used to manage a
cluster of dedicated compute nodes (such as a "Beowulf" cluster). In addition,
unique mechanisms enable HTCondor to effectively harness wasted CPU
power from otherwise idle desktop workstations.  For instance, HTCondor can be
configured to only use desktop machines where the keyboard and mouse are
idle.  Should HTCondor detect that a machine is no longer available (such as a
key press detected), in many circumstances HTCondor is able to transparently
produce a checkpoint and migrate a job to a different machine which would otherwise be
idle.  HTCondor does not require a shared file system across machines - if no
shared file system is available, HTCondor can transfer the job's data files on
behalf of the user, or HTCondor may be able to transparently redirect all the
job's I/O requests back to the submit machine.  As a result, HTCondor can be used
to seamlessly combine all of an organization's computational power into
one resource.
<p>
The <a href="classad/classad.html">ClassAd mechanism</a> in HTCondor provides an extremely flexible and
expressive framework for matching resource requests (jobs) with resource
offers (machines).  Jobs can easily state both job requirements and job
preferences.  Likewise, machines can specify requirements and preferences
about the jobs they are willing to run.  These requirements and preferences
can be described in powerful expressions, resulting in HTCondor's adaptation
to nearly any desired policy.
<p>
HTCondor can be used to build Grid-style computing environments that cross
administrative boundaries.   HTCondor's "flocking" technology allows
multiple HTCondor compute installations to work together.   HTCondor
incorporates many of the emerging Grid and Cloud-based computing methodologies and
protocols.  For instance, <a href="doc/condorg-hpdc10.pdf">HTCondor-G</a> is fully interoperable with resources
managed by <a href="http://www.globus.org">Globus</a>.
<p>
HTCondor is the product of <a href="publications.html">years of research</a> by the <a href="http://chtc.cs.wisc.edu">Center for High Throughput Computing</a> in the <a href="http://www.cs.wisc.edu">Department of Computer Sciences</a> at the 
<a href="https://www.wisc.edu/">University of
Wisconsin-Madison (UW-Madison)</a>, and it was first installed as a production
system in the UW-Madison Department of Computer Sciences <a href="doc/remoteunix.ps">over 15 years
ago</a>. This HTCondor installation has since served as a major source of
computing cycles to UW-Madison faculty and students.  
Additional
HTCondor installations have been established over the years across our campus
and the world. Hundreds of organizations in industry, government, and
academia have used HTCondor to establish compute installations ranging in size
from a handful to many thousands of workstations.
<p>
The <a href="downloads/">HTCondor software, source code,</a> and <a href="manual/">complete documentation</a> are freely available <a href="license.html">under an open source license</a>.
Linux, MacOS, and Windows platforms are supported.
