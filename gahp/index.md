---
layout: subpage
title: Grid Ascii Helper Protocol
---

<img src="{{ '/assets/images/GAHP_logo.jpg' | relative_url }}" align="right" height="239" />

<H2>Introduction</H2>

<P>
    The object of the Grid ASCII Helper Protocol (GAHP) is to allow the
    use of the client library or package of a grid or cloud service via
    a simple ASCII-based protocol. A process which implements GAHP is
    referred to as a GAHP server. GAHP is designed to handle both
    synchronous (blocking) and asynchronous (non-blocking) calls.
</P>

<P>
    The first GAHP specification focused on the GRAM and GASS grid
    services of the Globus Toolkit. Later GAHP specifications were
    then developed to communicate with other grid and cloud
    services.

</P>

<H2> Why GAHP? </H2>

<P>
    Although most grid and cloud services provide client libraries or
    modules in various languages that can be incorporated directly into
    applications that wish to use those services, there are several
    distinct advantages to using an independent GAHP server process
    instead. For instance, parts of the native API may provide only
    synchronous/blocking calls. Users who require a
    non-blocking/asynchronous interface must make use of multiple
    threads. Even if the native module is thread-safe, thread safety
    requires that _all_ modules linked into the process be both
    re-entrant and in agreement upon a threading model.
    This may be a significant barrier when trying to integrate the
    service client module into legacy non-thread-safe code, or when
    attempting to link with commercial libraries which either have no
    support for threads or define their own threading model. But because
    the GAHP server runs as a separate process, it can be easily
    implemented as a multi-threaded server, and still present an
    asynchronous non-blocking protocol. Worse yet, there may not be a
    client module available in the language of the application wishing
    to use the service. With a GAHP server, langauage choice is
    immaterial.
</P>

<P>
    GAHP facilitates the construction of multi-tier systems.  A first
    tier client can easily send ASCII commands via a socket (perhaps
    securely via an SSH or SSL tunnel) to a second tier running a GAHP
    server, allowing grid or cloud services to be consolidated at the
    second or third tier with minimal effort.
</P>

<P>
    Furthermore, GAHP, like many other simple ASCII-based protocols,
    supports the concept of component-based development independent of
    the software language used with minimal complexity. When a grid
    service has client modules available in multiple languages, those
    interfaces can look very different from each other. By using GAHP, a
    body of software could be written once with one interface and then
    subsequently utilize a GAHP server written in C, Java, or Perl --
    and said GAHP server could be running locally or as a daemon on a
    remote host.
</P>

<H2>Downloads</H2>

There are several GAHP protocols available, each designed to communicate with
a specific remote job submission system. At the time of this writing they are:
<ul>
<li><b>Globus 2 GAHP</b> (the original GAHP). The GT2 GAHP protocol spec is <a href="gahp_protocol.txt">here</A>.</li>
<li><b>Globus 3.2 GAHP</b>. The GT3.2 GAHP protocol spec is <a href="gt3_gahp_protocol.txt">here</A>.</li>
<li><b>Globus 4 GAHP</b>. <i>Spec coming soon</i></li>
<li><b>C-GAHP</b> (HTCondor GAHP). The C-GAHP protocol spec is <a href="cgahp_protocol.txt">here</a></li>
<li><b>BLAHP</b> (from INFN). The BLAHP protocol spec is <a href="blahp_protocol.txt">here</a></li>
<li><b>EC2 GAHP</b> (Amazon's Elastic Compute Cloud). The EC2 GAHP protocol spec is <a href="ec2_gahp_protocol.txt">here</a></li>
<li><b>GCE GAHP</b> (Google Compute Engine). The GCE GAHP protocol spec is <a href="gce_gahp_protocol.txt">here</a></li>
<li><b>Azure GAHP</b> (Microsoft Azure Cloud). The Azure GAHP protocol spec is <a href="azure_gahp_protocol.txt">here</a><br>
  Documentation from Microsoft:
  <ul>
  <li><a href="AzureGAHPCommands.docx">Azure GAHP Commands</a></li>
  <li><a href="AzureGAHPSetup.docx">Installation and Setup for the Azure GAHP</a></li>
  </ul>
</li>
</ul>
<p>

	The HTCondor Project at University of Wisconsin-Madison has developed the following GAHP server implementations:
<TABLE border="1">
<TR><TH>Name</TH><TH>Grid system</TH><TH>Implemenation</TH><TH>Availability</TH><TH>Source Code</TH></TR>
<TR><TD>GT2 GAHP</TD><TD>Globus 2 GRAM</TD><TD>C</TD><TD>HTCondor 6.4.*</TD><TD><a href="http://research.cs.wisc.edu/htcondor/gahp/gahp_server-src.tar">Source code</A></TD></TR>
<TR><TD>GT3.2 GAHP</TD><TD>Globus 3.2 WS GRAM</TD><TD>Java</TD><TD>HTCondor 6.7.* </TD><TD><A href="gt3.2-gahp.tar">Source code</a></TD></TR>
<TR><TD>GT4 GAHP</TD><TD>Globus 4 WS GRAM</TD><TD>Java</TD><TD>TBA (or by <a href="mailto:htcondor-admin@cs.wisc.edu">request</a>)</TD><TD>&nbsp;</TD></TR>
<TR><TD>C-GAHP</TD><TD>HTCondor</TD><TD>C++</TD><TD>HTCondor 6.7.9</TD><TD><a href="http://research.cs.wisc.edu/htcondor/gahp/cgahp_src.tar">Source code</A></TD></TR>
<TR><TD>Unicore GAHP</TD><TD>UNICORE</TD><TD>Java</TD><TD>HTCondor 6.9.x+</TD><TD><a href="http://research.cs.wisc.edu/htcondor/gahp/ugahp060314.tar.gz">Gzipped Tar Source code</A></TD></TR>
<TR><TD>EC2 GAHP</TD><TD>Elastic Compute Cloud</TD><TD>C++</TD><TD>HTCondor 7.1.x</TD><TD><a href="https://htcondor-wiki.cs.wisc.edu/index.cgi/dir?d=src/ec2_gahp">Source code</A></TD></TR>
<TR><TD>GCE GAHP</TD><TD>Google Compute Engine</TD><TD>C++</TD><TD>HTCondor 8.1.4</TD><TD><a href="https://htcondor-wiki.cs.wisc.edu/index.cgi/dir?d=src/gce_gahp">Source code</A></TD></TR>
<TR><TD>Azure GAHP</TD><TD>Azure Cloud</TD><TD>Python</TD><TD>HTCondor 8.7.x</TD><TD><a href="https://htcondor-wiki.cs.wisc.edu/index.cgi/dir?d=src/azure_gahp">Source code</A></TD></TR>

</TABLE>

<P>

	The National Computing Science Alliance (NCSA) has developed a GAHP
	server written in pure Java, using the Java CoG.  Any platform with a
	Java 1.2 virtual machine available can run this GAHP server.  
	Contact <a href="mailto:jalameda@ncsa.uiuc.edu">jalameda@ncsa.uiuc.edu</a>
	for up-to-date information about this Java CoG-based GAHP server.

<p>
Our collaborators at <a href="http://www.infn.it/">INFN</A> have developed a GAHP server (unoficially called BLAHP) for submitting to PBS & LSF schedulers. Please contact Francesco Prelz (<a href="mailto:Francesco.Prelz@mi.infn.it">Francesco.Prelz@mi.infn.it</a>) for more info.
</p>

