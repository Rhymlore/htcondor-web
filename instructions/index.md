---
layout: subpage
title: Install Instructions
---

<p>
    HTCondor is in the Debian and Ubuntu repositories as well as Enterprise Linux’s EPEL, but these versions may
    lag behind our current releases. If you want a newer version, please consider using one of our repositories
    installed via your package manager.
</p>

<p>
    We have repositories for the current and previous versions of Enterprise Linux, Debian, and Ubuntu LTS and each
    distribution will have 3 release series available: Development, Stable, and Previous. If you're unsure which
    one to choose, go with stable series.
</p>

<ul>
    <li>
        The Development series is updated every 6-8 weeks and has new features under development. We do run it in our
        production environment before release. However, we have the resources to quickly address the problems found.
    </li>
    <li>
        The Stable series is updated several times during the year, whenever a bug has sufficient impact on one of our
        users.
    </li>
    <li>
        The Previous repository contains the last release of the previous Stable series.
    </li>
</ul>

<p>
    The main package (condor on Enterprise Linux systems,
    htcondor on Debian/Ubuntu system) needs to be configured before
    running HTCondor.
    There is a minicondor package (minihtcondor on Debian/Ubuntu) that
    configures HTCondor to run on a single node.
</p>

<p>
    Except for EL6, we only support 64-bit Intel architectures.
</p>

<h3>Enterprise Linux</h3>
<ul>
    <li>
        EL6 (Red Hat Enterprise Linux 6, CentOS 6, Scientific Linux 6)
        <a href="el/6/stable">Stable</a>
        <a href="el/6/previous">Previous</a>
    </li>
    <li>
        EL7 (Red Hat Enterprise Linux 7, CentOS 7, Scientific Linux 7)
        <a href="el/7/stable">Stable</a>
        <a href="el/7/development">Development</a>
        <a href="el/7/previous">Previous</a>
    </li>
    <li>
        EL8 (Red Hat Enterprise Linux 8, CentOS 8)
        <a href="el/8/stable">Stable</a>
        <a href="el/8/development">Development</a>
    </li>
</ul>

<h3>Debian</h3>
<ul>
    <li>
        Debian 9 (Stretch)
        <a href="debian/9/stable">Stable</a>
        <a href="debian/9/development">Development</a>
        <a href="debian/9/previous">Previous</a>
    </li>
    <li>
        Debian 10 (Buster)
        <a href="debian/10/stable">Stable</a>
        <a href="debian/10/development">Development</a>
    </li>
</ul>

<h3>Ubuntu</h3>
<ul>
    <li>
        Ubuntu 16.04 (Xenial Xerus)
        <a href="ubuntu/16/stable">Stable</a>
        <a href="ubuntu/16/development">Development</a>
        <a href="ubuntu/16/previous">Previous</a>
    </li>
    <li>
        Ubuntu 18.04 (Bionic Beaver)
        <a href="ubuntu/18/stable">Stable</a>
        <a href="ubuntu/18/development">Development</a>
        <a href="ubuntu/18/previous">Previous</a>
    </li>
    <li>
        Ubuntu 20.04 (Focal Fossa)
        <a href="ubuntu/20/stable">Stable</a>
        <a href="ubuntu/20/development">Development</a>
    </li>
</ul>

<p>
    HTCondor documentation and manuals may be downloaded, or viewed online from the
    <a href="https://htcondor.readthedocs.io/en/latest/">HTCondor Manual</a>.
</p>