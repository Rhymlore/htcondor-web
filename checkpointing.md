---
layout: subpage
title: Checkpointing
---

<h3>Overview</h3>

The ability to cause a job to <EM>vacate</EM> a non-idle
workstation and <EM>migrate</EM> to an idle workstation is central to
HTCondor's job scheduling.
To allow these migrating jobs to continue their progress,
HTCondor must be able to continue a vacated job without
a complete loss of computation time.
HTCondor does this by using a <EM>checkpoint</EM>
of a job's state.
A checkpoint is generated just before a job vacates
a machine.
The checkpoint is then used 
as a starting point for the job after migration.

HTCondor gives a program the
ability to checkpoint itself by providing a checkpointing library
which contains a signal handler for SIGTSTP, the HTCondor checkpoint
signal.  When a HTCondor job receives a checkpoint signal, it writes a
checkpoint file, which contains the process's data and stack segments,
as well as information about open files, pending signals, and CPU
state.  When the job is restarted, the state contained in the
checkpoint file is restored (by startup code in the checkpoint
library) and the process resumes the computation at the point
where the checkpoint was generated.
Programs submitted to be run by the HTCondor system are re-linked (but not
re-compiled) to include this library.

A technical description of the checkpointing and process migration
mechanisms implemented in HTCondor is given in this
<A HREF="doc/ckpt97.ps">technical report</A>.

<h3>Standalone Checkpointing</h3>

The HTCondor distribution includes a checkpointing library, 
to provide checkpoints for Unix
processes that are not submitted for execution under HTCondor.
Information on using standalone checkpointing is available
in the
<A HREF="{{ '/manual/' | relative_url }}">manual</A>.

<h3>Periodic Checkpointing</h3>

In addition to writing a checkpoint at vacate time, HTCondor can be
configured to write checkpoints periodically while the job is
executing, to provide additional reliability.

<h3>Checkpoint Server</h3>

By default, a checkpoint is written to a file on the local disk of the
machine where the job was submitted.  A checkpoint server has been
developed to serve as a repository for checkpoints.  When a host is
configured to use a checkpoint server, jobs submitted on that machine
write and read checkpoints to and from the server rather than the
local disk of the submitting machine, taking the burden of storing
checkpoint files off of the submitting machines and placing it instead
on server machines (with disk space dedicated to the purpose of
storing checkpoints).

<h3>Other Checkpointing Resources</h3>

<UL>
<LI>
<A HREF="http://www.cs.utk.edu/~plank/ckp.html">Checkpointing Research at the University of Tennessee</A>
</LI>
</UL>

