---
layout: subpage
title: DAGMan
---

<p>
DAGMan (Directed Acyclic Graph Manager) is a meta-scheduler for
HTCondor.  It manages dependencies between jobs at a higher level than
the HTCondor Scheduler.
</p>

<p>
A directed acyclic graph (DAG) can be used to represent a set of
programs where the input, output, or execution of one or more programs
is dependent on one or more other programs. The programs are nodes
(vertices) in the graph, and the edges (arcs) identify the
dependencies. HTCondor finds machines for the execution of programs, but
it does not schedule programs (jobs) based on dependencies. The
Directed Acyclic Graph Manager (DAGMan) is a meta-scheduler for HTCondor
jobs. DAGMan submits jobs to HTCondor in an order represented by a DAG
and processes the results. An input file defined prior to submission
describes the DAG, and a HTCondor submit description file for each
program in the DAG is used by HTCondor.
</p>

<p>
Each node (program) in the DAG needs its own HTCondor submit description
file. As DAGMan submits jobs to HTCondor, it uses a single HTCondor log
file to enforce the ordering required for the DAG. The DAG itself is
defined by the contents of a DAGMan input file. DAGMan is responsible
for scheduling, recovery, and reporting for the set of programs
submitted to HTCondor.
</p>

<h2> DAGMan Documentation </h2>

<p>
HTCondor is fully documented in the <a
href="https://htcondor.readthedocs.io/en/latest">HTCondor manual</a>.
<!-- Note:  the link below will break if the manual sections change! -->
The <a
href="https://htcondor.readthedocs.io/en/latest/users-manual/dagman-workflows.html">
DAGMan Workflows section</a>
describes DAGMan in great detail.
</p>

<h2> Downloading DAGMan </h2>

<p>
DAGMan is part of the HTCondor software, which can be downloaded
<a href="http://research.cs.wisc.edu/htcondor/downloads">here</a>.
</p>