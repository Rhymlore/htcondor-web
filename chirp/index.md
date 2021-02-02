---
layout: default
title: HTCondor - Chirp Protocol
---

<!-- Page body -->
<h1>The Chirp I/O Protocol</h1>

Chirp is a lightweight I/O protocol and filesystem for grid computing.
It consists of familiar operations such as open(), read(), write(), and close().
In addition, Chirp provides a variety of authentication methods,
allowing remote users to identify themselves with strong
Globus or Kerberos credentials.
<p>
    <b><a href="https://ccl.cse.nd.edu/software/chirp">Most information about Chirp, including software, publications, manuals, and more can be found at the University of Notre Dame.</a></b>
</p>
<p>
    There are currently several implementations of Chirp available:
    <ul>
        <li>
            <a href="https://ccl.cse.nd.edu/software/chirp">The Chirp Filesystem for Grid Computing</a> is a standalone implementation of the Chirp protocol that can be easily deployed in a grid, cluster, or other distributed system.  It includes multiple client access methods, a rich authentication and authorization system, and a number of system management tools.
        </li>
        <li>
            <a href="https://ccl.cse.nd.edu/software/parrot">Parrot</a></b> - Chirp is the native protocol used by <a href=https://ccl.cse.nd.edu/software/parrot>Parrot</a> a system for attaching applications to grid storage.  Parrot captures the system calls of ordinary applications and redirects them transparently to Chirp servers, so that any application can simply access <tt>/chirp</tt> like a normal file system.
        </li>
        <li>
            <a href="https://research.cs.wisc.edu/htcondor">HTCondor</a> - HTCondor also has an internal implementation of the Chirp protocol, which allows batch jobs to access their home storage while executing on a remote machine. If a HTCondor job is submitted with <tt>+WantIOProxy=True</tt> in its submit file, then HTCondor provides a proxy at the execution site that accepts the Chirp protocol and provides access to the submitter's storage.  Users can invoke the <tt>condor_chirp</tt> command at runtime to load and store files, as well as update the job's classad.
        </li>
        <li>
            <a href="https://root.cern.ch">ROOT</a> - The ROOT I/O library is used in high energy physics for managing access to persistent storage.  A  Chirp module in the library is used to connect high-energy physics applications to Chirp servers.
        </li>
        <li>
            <b>Chirp Protocol.</b> The Chirp protocol itself is independent of both Parrot and HTCondor. 
            <ul>
                <li><a href="https://ccl.cse.nd.edu/software/manuals/chirp_protocol.html">Chirp Protocol Version 2</a></li>
                <li><a href="https://research.cs.wisc.edu/htcondor/chirp/PROTOCOL">Chirp Protocol Version 1</a></li>
            </ul>
        </li>
    </ul>
</p>

