---
layout: container-default
title: HTCondor - Install Instructions - Ubuntu 18 Development
meta:
- '<meta name="robots" content="noindex">'
---

<span class="text-danger">This page is deprecated, visit <a href="https://htcondor.org/downloads/htcondor">the HTCondor download page</a> for updated instructions.</span>
<hr>

<h1>Install Instructions</h1>


<!-- Page body -->

<h3>Ubuntu 18.04 (Bionic Beaver)</h3>
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
                <pre># echo "deb http://research.cs.wisc.edu/htcondor/ubuntu/8.9/bionic bionic contrib" >> /etc/apt/sources.list
# echo "deb-src http://research.cs.wisc.edu/htcondor/ubuntu/8.9/bionic bionic contrib" >> /etc/apt/sources.list</pre>
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
		Note that if condor is NOT running, the only output of this ps command will look like this:
		<pre>$ ps auxww | grep condor
user    1466  0.0  0.0  14736  1048 pts/1    S+   13:05   0:00 grep condor</pre>
		If condor is running, you will see several lines of output, something like this:
		<pre>user    1433  0.0  0.0  14736  1092 pts/1    S+   13:05   0:00 grep condor
user    6404  0.0  0.0  72488 12956 ?        Ss    2020   0:55 condor_master -f
user   27159  0.0  0.0  27888  6084 ?        S     2020   1:11 condor_procd -A /var/log/procd_pipe -L /var/log/ProcLog -R 1000000 -S 60 -D -C 28297
user   27201  0.0  0.0  60744 12620 ?        Ss    2020   4:04 condor_collector
user   27202  0.0  0.0  62016 14124 ?        Ss    2020   0:35 condor_schedd
user   27203  0.0  0.0  60784 12576 ?        Ss    2020   2:20 condor_negotiator
user   27204  0.0  0.3 103864 55784 ?        Ss    2020   3:14 condor_startd
</pre>
    </li>
</ol>

<p>
    Instructions on how to install other Linux distributions can be found on the <a href="{{ '/instructions' | relative_url }}">Install Instructions page</a>.
</p>
