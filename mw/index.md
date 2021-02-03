---
layout: default
title: HTCondor - Master-Worker
---

<!-- Page body -->
<table width="800" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td width="170" valign="top"> <a href="index.html"><img
 src="MWLogo.gif" height="227" width="158" border="0"></a>
      <p> </p>
      <ul>
        <li><a href="usersguide.pdf">User's guide</a> </li>
        <li><a href="overview.html">Overview</a> </li>
        <li><a href="papers.html">MW Papers </a> </li>
        <li><a href="mw/examples/matmul/Matmul.html">Example App Docs</a> </li>
<!--        <li><a href="mwconsensus.html">MW-Discussion</a> </li> -->
        <li><a href="talks/dec99.ps.gz">Winter 1999 Talk</a> </li>
        <li><a href="talks/jun99/index.htm">Summer 1999 Talk</a> </li>
        <li><a href="talks/feb99/index.htm">Spring 1999 Talk</a> </li>
        <li><a href="talks/mar00/index.htm">March 2000 Talk</a> </li>
        <li><A href="talks/feb04/mw.pdf">February 2004 Talk</a> </li>
        <li><A href="talks/04Feb-SIAMPP-SanFran.pdf">February 2004 Talk</a> </li>
        <li><A href="talks/05Jan-PAREO-Montreal.pdf">January 2005 Talk</a> </li>
        <li><a href="solvers.html">Solvers Using MW</a> </li>
        <li><a href="doc/html">Documentation</a> </li>
		<li><a href="issues.html">Known Issues</a> </li>
        <li><a href="mw-0.3.0.tgz">Source Code (gzipped tarball)</a> </li>
      </ul>
      </td>
      <td width="10"> <br>
      </td>
      <td valign="top">
      <h2>The MW Homepage</h2>
This page contains information, documentation, and source
code for the MW project.



      <h3>What is MW?</h3>
MW is a tool for making a master-worker style application that works
in the distributed, opportunistic environment of HTCondor.  MW
applications use HTCondor as a resource management tool, and can use
either <a href="../pvm/"> HTCondor-PVM</a> or MW-File a file-based, remote
I/O scheme for message passing. Writing a parallel application for use
in the HTCondor system can be a lot of work.  Since the workers are not
dedicated machines, they can leave the computation at any time. 
Machines can arrive at any time, too, and they can be suspended and
resume computation.  Machines can also be of varying architechtures
and speeds.  MW will handle all this variation and uncertainty in the
opportunistic environment of HTCondor.
      <p> The master, or MWDriver, is basically a layer that sits above
the program's resource management and message passing mechanisms and
below your application.  It handles things like nodes going up/down,
suspending/resuming, and the starting and stopping of jobs.  It does
this by managing a set of user-defined tasks and a pool of workers. The
workers do user-defined work on the tasks that they're given.  The
MWDriver simply matches tasks to workers.</p>
      <p> To learn more, read the <a href="usersguide.pdf">users guide</A>, or look at the <a href="overview.html">overview</a>.
You can refer to several <a href="papers.html">papers</a> that we have
written that explain the rationale behind our design choices.  Other
information can be found in overview talks given in <a
 href="talks/dec99.ps.gz"> December 99 </a>, <a
 href="talks/jun99/index.htm">June 99</a>, <a href="talks/feb99/index.htm">February
99</a>,  <a href="talks/mar00/index.htm">March 2000</a>, and most recently
<A href="talks/feb04/mw.pdf">February 2004</a>.  Documentation
(constructed with  <a href="http://www.zib.de/Visual/software/doc++/index.html">Doc++</a>) for MW base classes is 
 <a href="doc/html/">here</a>. Here is  an <a
 href="mw/examples/matmul/Matmul.html">example application</a>. 
</p>

<p>
Most of the real applications using MW that people have built so far
are to solve mathematical Optimization problems.  To see some of these
real-world solvers, see our <a href="solvers.html">solvers</a>
page.</p>

      <p> The diagram below indicates the relationships between
HTCondor, PVM, and the MWDriver.</p>
      <p> <img src="MWPicture.gif" height="315" width="420"> </p>



      <h3>MW News</h3>
      <ul>

<!--
		<li><b>MW is hiring!</b>  We are seeking a systems programmer to work
		on MW development and to assist MW users. (6/2/04). Apply for this
		position via the official University <A
		HREF="http://www.ohr.wisc.edu/pvl/pv_047550.html">position vacancy
		listing</A>.
-->
		<li>MW Version 0.2.2 released -- download source from menu on the left.  
		New version has support for running on native MS-Windows 
		(without cygwin), many bugfixes, and new "blackbox" example for 
		running standalone executables as workers
		(1/9/2006)</li>

		<li>MW Version 0.2.1 released -- download source from menu on the left.  
		New version has minor bugfixes, <A href="usersguide.pdf"> users guide</A>
		and cleaned up examples.  (7/10/2005)</li>

		<li>MW Version 0.2 released -- download source from menu on the left.  
		New version supports 64 bit architecture, Windows (via cygwin),
		and new chirp mode with MW-Files, which allows MW-File to work on
		clipped version of condor. (5/31/2005)</li>
	

        <li>MW is now distributed under an LGPL license.
(10/04/2002) </li>
        <li><b>Interactive Master-Worker (IMW)</b> Prototype available.
IMW, written by <A href="mailto:chang@cs.wisc.edu">Jichuan Chang</a>,
 is a lightweight interactive master-worker framework written in Java 
(except for a C++ HTCondor User Log Reader) which utilizes HTCondor's Java
Universe. Here is a brief <a href="./IMW.html">introduction</a>, 
and a <a href="README.IMW">README</a>. 
You can <a href="./IMW.tar.gz">download</a> and try it. (05/31/2002) <br>
        </li>
        <li>MW mailing list "mw@cs.wisc.edu" created! <br>
To join the list, please send a blank email message to 	
<t>mw-subscribe@cs.wisc.edu</t>, or else
<a href="http://lists.cs.wisc.edu/mailman/listinfo/mw">visit this page</a>
to fill out a subscription.
Please also use the list to send MW bug reports. <br>
        </li>
        <li>MW-Independent is  back! MW-Independent implements the
resource and 	communication (RMComm) layer using memory copy, and
bundles the master/workers 	into a single process. It can be used to
debug an MW application code before submitting 	your job to
HTCondorPvm/MW-File/MW-Socket. </li>
        <li>Pre-compiled MW libraries installed in the UW HTCondor Pool
(cs.wisc.edu). Look under  /unsup/condor/mw. </li>

      </ul>

      <h3>MW People</h3>
      <ul>
        <li>Jeff Linderoth: <a href="mailto:jtl3@lehigh.edu">email</a>, <a
 href="http://www.lehigh.edu/~jtl3">web page</a>. </li>
        <li> Wen-Han Goh: <A href="mailto:weh-han@cs.wisc.edu">email</a>.
        <li>Peter Keller <a href="mailto:psilord@cs.wisc.edu">email</a>,<a
 href="http://www.upl.cs.wisc.edu/%7Epsilord">web page</a>. </li>
        <li>Greg Thain: 
<script language="Javascript">
 document.write("<a href=\"mailto:gtha");
 document.write("in@cs.wisc");
 document.write(".edu\">");
 document.write("email </a>");
</script>
            <A href="http://www.cs.wisc.edu/~gthain/">web page</a>.
        <li>Steve Wright: <A href="mailto:swright@cs.wisc.edu">email</a>, <A href="http://www.cs.wisc.edu/~swright/">web page</a>.
      </ul>


      <h3>MW Alumni</h3>
      <ul>
        <li>Mike Yoder.
<!--
 <a href="mailto:yoderm@cup.hp.com">email</a>,<a href="http://www.cs.wisc.edu/%7Eyoderme">web page</a>. 
-->
</li>
        <li>Sanjeev Kulkarni.
<!--
<a href="mailto:sanjeevk@cs.wisc.edu">email</a>,<a href="http://www.cs.wisc.edu/%7Esanjeevk">web page</a>. 
-->
</li>
        <li>Jichuan Chang: <a href="mailto:chang@cs.wisc.edu">email</a>,<a
 href="http://www.cs.wisc.edu/%7Echang">web page</a> </li>
        <li>Jean-Pierre Goux: <a href="mailto:jp.goux@powernext.fr">email</a>.  </li>
        <li>Alan Bailey: <a href="mailto:awbailey@cs.wisc.edu">email</a> <a
 href="http://www.cs.wisc.edu/%7Eawbailey/">web page</a>.</li>
        <li>Minyi Xu: <a href="mailto:minyi@cs.wisc.edu">email</a> <a
 href="http://www.cs.wisc.edu/%7Eminyi">web page</a>.<br>
        </li>
      </ul>
      </td>
    </tr>
  </tbody>
</table>
</body>
<center>
This material is based upon work supported by the National Science Foundation under Grant No. 0330538.
</center>

    </div>

    <!-- ##### Footer ##### -->

    <div id="footer">
        For comments or questions about this website, please
	<a href="mailto:htcondor-admin@cs.wisc.edu">email htcondor-admin@cs.wisc.edu</a><br />
	This work is supported by <a href="https://www.nsf.gov/div/index.jsp?div=OAC">NSF</a> under Cooperative Agreement <a href="https://www.nsf.gov/awardsearch/showAward?AWD_ID=2030508">OAC-2030508</a> as part of the <a href="https://path-cc.io/">PATh Project</a>. <br />
      <script type="text/javascript">
	      document.write("Updated &raquo; "+lastMod(document.lastModified))
      </script>
    </div>



    </div> <!-- end of div#container -->
  </body>
</html>
