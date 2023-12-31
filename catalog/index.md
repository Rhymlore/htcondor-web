---
layout: subpage
title: ClassAd Catalog
---

<h2>HTCondor Standalone ClassAd Catalog</h2>

The ClassAd Catalog is a simple but powerful system for tracking and discovering resources in a distributed system.  It is a standalone system based on <a href="http://research.cs.wisc.edu/htcondor">HTCondor technology</a>.  We use this system to keep track of distributed resources such as Kangaroo nodes.  You are welcome to use it for your own purposes.  This software is released under the GNU <a href="COPYING">General Public License</a>.
<p>

<h2>Overview</h2>

A catalog system is centered around a well-known catalog server.  Providers of resources periodically send UDP update messages describing themselves to the server.  Updates are kept for a short time, typically fifteen minutes, and then discarded.  To remain in the catalog, a provider must continue to send updates.  Consumers may contact the server via TCP to query for available resources.  Once found, a consumer may contact a provider directly.  We use the catalog to keep track of disks and CPUs, but you could use it to keep track of almost anything you can think of.
<p>
(HTCondor experts should recognize that this system is very similar to the HTCondor collector daemon and status utilities.)
<p>
<center>
<img src="{{ '/assets/images/classad-catalog.gif' | relative_url }}"></img>
</center>
<p>
The catalog uses the <a href="http://research.cs.wisc.edu/htcondor/classad">ClassAd language</a>, which is the <i>lingua franca</i> of the <a href="http://research.cs.wisc.edu/htcondor">HTCondor Project</a>.  This language allows one to express arbitrary structured data (much like XML), but with a type and expression system that allows one to compose complex queries.  You can learn all about the details of ClassAds <a href="http://research.cs.wisc.edu/htcondor/classad">on another page</a>.

<h2>Example</h2>

Let's suppose that you have started a catalog server on a machine called "catalog.project.org" like so:
<pre>
        % catalog_server
</pre>
<p>
Now, suppose that a storage resource has described itself in the classad language as follows:
<pre>
[
        Name = "Barney";
        UpdateAddress = "www.xxx.yyy.zzz";
        DiskFree = 2048;
        AllowsAnonymous = true;
        Owner = "thain";
        SpeaksFTP = true;
        LoadAverage = 0.75;
]
</pre>
If this classad is stored in the file "info.ad", then it could be sent to the catalog server as follows:
<pre>
        % catalog_update -c catalog.project.org < info.ad
</pre>
Then, any of these queries could be used to read the ad back:
<pre>
        % catalog_query -c catalog.project.org -q '(DiskFree>1000)'
        % catalog_query -c catalog.project.org -q '(AllowsAnonymous && Owner!="badguy@cs.wisc.edu" )'
        % catalog_query -c catalog.project.org -q '(SpeaksFTP && LoadAverage<5.0 )'
</pre>

<!--
<h2>Sample Server</h2>

We run a sample catalog server at <tt>kangaroo.cs.wisc.edu</tt> port 9098.
You are welcome to use this server for testing and experimentation.
You can view the current contents of this catalog in one of four ways:
<ul>
<li> <a href=catalog.classad>Complete ClassAds</a>
<li> <a href=catalog.xml>Complete XML</a>
<li> <a href=catalog.html>Selected fields in HTML</a>
<li> <a href=catalog.txt>Selected fields in ASCII</a>
</ul>
-->

<h2>Downloads</h2>

You may download the catalog software in binary form:
<ol>
    <li><a href="catalog-0.9-x86-linux.tar.gz">catalog-0.9 for x86 Linux</a></li>
</ol>

Or, in source form, you need two components:

<ol>
    <li><a href="classads-0.9.2-special.tar.gz">classads-0.9.2-special.tar.gz</a> (A slightly modified ClassAds library)</li>
    <li><a href="catalog-0.9.1.tar.gz">catalog-0.9.1.tar.gz</a> (The catalog software itself)</li>
</ol>

To insert data into the catalog, you may need some small programs
to convert data into ClassAd form.  Here is a program that fetches
status from an IBP depot and formats it suitably for <tt>catalog_update</tt>:

<ol>
    <li><a href="ibp_probe.c">ibp_probe.c</a></li>
</ol>

Questions and comments may be sent to <tt>thain at cs.wisc.edu</tt>
