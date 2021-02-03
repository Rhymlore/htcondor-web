---
layout: default
title: HTCondor - Install Instructions - EL6 Previous
---

<h1>Install Instructions</h1>


<!-- Page body -->

<h3>EL6 (Red Hat Enterprise Linux 6, CentOS 6, Scientific Linux 6)</h3>
<ol>
    <li>
        Setup the repository
        <ol type="a">
            <li>
                Import the signing key
                <pre># wget https://research.cs.wisc.edu/htcondor/yum/RPM-GPG-KEY-HTCondor
# rpm --import RPM-GPG-KEY-HTCondor</pre>
            </li>
            <li>
                Get the repository file
                <pre># cd /etc/yum.repos.d
# wget https://research.cs.wisc.edu/htcondor/yum/repo.d/htcondor-previous-rhel6.repo</pre>
                NOTE: if you have the EPEL repository enabled, add exclude=condor* to the EPEL repo file
            </li>
        </ol>
    </li>
    <li>
        Install HTCondor
        <pre># yum install condor-all</pre>
    </li>
    <li>
        Start it running
        <pre># chkconfig condor on
# service condor start</pre>
    </li>
    <li>
        Check that it is running
        <pre>$ ps ax | grep condor</pre>
    </li>
</ol>

<p>
    Instructions on how to install other Linux distributions can be found on the <a href="{{ '/instructions' | relative_url }}">Install Instructions page</a>.
</p>