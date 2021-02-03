---
layout: default
title: HTCondor - Install Instructions - Ubuntu 16 Previous
---

<h1>Install Instructions</h1>


<!-- Page body -->

<h3>Ubuntu 16.04 (Xenial Xerus)</h3>
<ol>
    <li>
        Setup the repository
        <ol type="a">
            <li>
                Install the HTCondor repository key
                <pre>$ wget -qO - https://research.cs.wisc.edu/htcondor/ubuntu/HTCondor-Release.gpg.key | sudo apt-key add -</pre>
            </li>
            <li>
                Add the HTCondor repository (running as the root user)
                <pre># echo "deb http://research.cs.wisc.edu/htcondor/ubuntu/8.6/xenial xenial contrib" >> /etc/apt/sources.list
# echo "deb-src http://research.cs.wisc.edu/htcondor/ubuntu/8.6/xenial xenial contrib" >> /etc/apt/sources.list</pre>
            </li>
        </ol>
    </li>
    <li>
        Install HTCondor
        <pre>$ sudo apt-get update
$ sudo apt-get install condor</pre>
    </li>
    <li>
        Check that it is running
        <pre>$ ps ax | grep condor</pre>
    </li>
</ol>

<p>
    Instructions on how to install other Linux distributions can be found on the <a href="{{ '/instructions' | relative_url }}">Install Instructions page</a>.
</p>
