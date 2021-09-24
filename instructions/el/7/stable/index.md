---
layout: container-default
title: HTCondor - Install Instructions - EL7 Stable
---

<h1>Install Instructions</h1>


<!-- Page body -->

<h3>EL7 (Red Hat Enterprise Linux 7, CentOS 7, Scientific Linux 7)</h3>
<ol>
    <li>
        Setup the repositories
        <ol type="a">
            <li>
                Install EPEL repository (as the root user or use sudo)
                <pre>yum install -y https://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm</pre>
            </li>
            <li>
                Install the HTCondor repository (as the root user or use sudo)
                <pre>yum install -y https://research.cs.wisc.edu/htcondor/repo/8.8/el7/release/htcondor-release-8.8-1.el7.noarch.rpm</pre>
            </li>
        </ol>
    </li>
    <li>
        Install HTCondor (as the root user or use sudo)
        <pre>yum install -y minicondor # or condor</pre>
        The minicondor is preconfigured for a single node pool.
        The condor package, for a multi-node pool, requires additional configuration to become functional - please <a href="https://htcondor.readthedocs.io/en/latest/admin-manual/quick-start-condor-pool.html?highlight=quick%20start#quick-start-setting-up-an-htcondor-pool">see the HTCondor Manual</a>.
    </li>
    <li>
        Start it running (as the root user or use sudo)
        <pre>systemctl start condor # starts HTCondor now via systemd, or do "condor_master" without systemd
systemctl enable condor # Make HTCondor start automatically via systemd when booting</pre>
    </li>
    <li>
        Check that it is running (as a normal user)
        <pre>condor_q # Should list out the jobs in the pool</pre>
        <pre>condor_status # Should list out the nodes in the pool</pre>
        You may also check HTCondor's systemd status (as the root user or use sudo)
        <pre>systemctl status condor</pre>
    </li>
</ol>

<p>
    Instructions on how to install other Linux distributions can be found on the <a href="{{ '/instructions' | relative_url }}">Install Instructions page</a>.
</p>