---
layout: subpage
title: BirdBath
---

<img src="{{ '/assets/images/birdbath.gif' | relative_url }}" align="right" height="239" />
<span name="top"></span>

<!-- Now just status, and no one should be using 6.7.5 anyway...
<h2>BirdBath Merged</h2>

<p>

As of March 2nd 2005 and the release of HTCondor 6.7.5, HTCondor includes
the BirdBath daemons and no new releases will be made via this
site. The site will remain to provide example code and as a possible
supplement to the HTCondor Manual.

</p>

<p>

<b>Important for HTCondor 6.7.5 users:</b> While HTCondor 6.7.5 contains
the BirdBath daemons, it does not contain the WSDL files necessary
to use them.

</p>

<p>

WSDL files for HTCondor 6.7.5:

<ul>
  <li>
  <a href="condorSchedd-6.7.5.wsdl">Schedd's WSDL</a>
  </li>
  <li>
  <a href="condorCollector-6.7.5.wsdl">Collector's WSDL</a>
  </li>
</ul>

</p>

<hr noshade>
-->

<!-- Not just developer code anymore...
<span name="notice">
<b>Notice:</b> This is pre-release developer snapshot software. It
does not necessarily live up to the standards of HTCondor production
software. It is not recommended that these daemons be run in a
production HTCondor pool. It is entirely possible that the APIs will
change before this software is included in a HTCondor release.
</span>
-->

<span name="overview"></span>
<h3>Overview</h3>

<p>

<b>BirdBath</b> is HTCondor's entry into the world of Web Services. Its
goal is to augment some of the core HTCondor daemons with Simple Object
Access Protocol (SOAP) interfaces so that they can be queried and
controlled through programs other than the standard HTCondor
command-line tools. The main interfaces are currently to the Schedd
for submitting and querying jobs, and the Collector for accessing
information about a HTCondor pool.

</p>

<p>

Information about configuring HTCondor's SOAP API is available in the
HTCondor manual.

</p>

<span name="status"></span>
<h3>Status</h3>

<p>

As of March 2nd 2005, BirdBath is part of HTCondor. It was in the 6.7
developer series as of 6.7.5, and is part of the 6.8 stable series.

</p>

<!-- Old info...
<ul>
  <li>
      <b>November 15 2004</b>: This release will work with the HTCondor
      6.7.2 development release. The most important change is to the
      "transaction problem." These daemons have a fix that keeps them
      from crashing when a condor_q is run at the same time as a SOAP
      transaction. Multiple simultaneous SOAP transactions will still
      cause some problems. Also important to note, the Windows
      authentication mechanisms in HTCondor 6.7 are not backward
      compatible with 6.6 daemons. Additionally, bugs have been fixed
      in how files are opened in the spool directory on Windows. This
      will likely be the last separate build of these daemons before
      they are integrated with the 6.7 development series.
  </li>
  <li>
      <b>June 29 2004</b>: A RequestReschedule() operation was added
      to the Schedd. This operation can be used just as
      condor_reschedule is used. Also, when submitting a scheduler
      universe job a client must call RequestReschedule() in order for
      the job to be started immediately.
  </li>
  <li>
      <b>June 17 2004</b>: A bug was fixed in how a job's spool
      directory was being created. If you really, really want you
      should be able to run the schedd as root and have everything
      continue to work now. Also, the WSDL was changed to have
      operation responses come back inside a &lt;operationResponse&gt;
      tag, instead of some other non-sense. The response message was a
      problem for ZSI. Axis and .Net never seemed to care about the
      malformed response messages.
  </li>
  <li>
      <b>June 1 2004</b>: The code was updated to run with the new
      HTCondor 6.7 developer series. This means you now need a 6.7
      installation to use the daemons. Also, the condorCore,
      condorSchedd and condorCollector namespaces were collapsed into
      a "condor" namespace. This change means that the WSDL files do
      not contain circular import requirements. The changes to clients
      using the new WSDL files should be minimal, if they are even
      apparent at all. There were no significant bugs or functionality
      changes made since the May 21 2004 snapshot. The examples still
      need to be updated. Examples will always be for the most recent
      snapshot.
  </li>
  <li>
      <b>May 21 2004</b>: A bug was fixed in how the MyType and TargetType
      attributes of ClassAds are handled. The <b>WSDL was changed</b>
      to make Requirements, FileInfoArray, ClassAdStruct, and
      ClassAdStructArray actual SOAP Arrays. This was done to broaden
      the number of SOAP toolkits (including .Net) that can correctly
      use the WSDL. The changes needed to make existing code work with
      the new WSDL should be minimal, and should actually simplify
      code. In Axis this change means getItem() is no longer needed to
      access these array types. <b>Windows binaries are now
      available.</b>
  </li>
  <li>
      <b>May 13 2004</b>: Two HTCondor daemons have been fitted with
      SOAP interfaces. These are the Collector (condor_collector) and
      the Schedd (condor_schedd). A detailed description of the <a
      href="JobSubmissionAPI-R2.html">Schedd's API</a> (<a
      href="JobSubmissionAPI-R2.pdf">pdf</a>) is currently available,
      and one is in the works for the Collector's API.
  </li>
</ul>
-->

<!-- No one should be downloading this stuff...
<span name="download">
<h3>Download</h3>
</span>

<p>

The most recent snapshot is <em>6.7.3 Nov 15 2004 PRE-RELEASE-UWCS
SOAP-3-BRANCH</em>, which works with a HTCondor 6.7
installation. Drop-in replacements for condor_collector and
condor_schedd are available:

</p>

<ul>
  <li>
      Linux 2.4.x (glibc 2.3) compiled on Red Hat 9
      <ul>
        <li>
            Collector: <a
            href="linux_condor_collector-Nov-15-2004.bz2">linux_condor_collector-Nov-15-2004.bz2</a>
            and associated <a
            href="condorCollector-Nov-15-2004.wsdl">WSDL</a>
        </li>
        <li>
            Schedd: <a
            href="linux_condor_schedd-Nov-15-2004.bz2">linux_condor_schedd-Nov-15-2004.bz2</a>
            and associated <a
            href="condorSchedd-Nov-15-2004.wsdl">WSDL</a>
        </li>
      </ul>
  </li>
  <li>
      Windows 2000/XP compiled with Visual Studio 6.0
      <ul>
        <li>
            Collector: <a
            href="windows_condor_collector-Nov-15-2004.zip">windows_condor_collector-Nov-15-2004.zip</a>
            and associated <a
            href="condorCollector-Nov-15-2004.wsdl">WSDL</a>
        </li>
        <li>
            Schedd: <a
            href="windows_condor_schedd-Nov-15-2004.zip">windows_condor_schedd-Nov-15-2004.zip</a>
            and associated <a
            href="condorSchedd-Nov-15-2004.wsdl">WSDL</a>
        </li>
      </ul>
  </li>
</ul>

<p>

Old version:

</p>

<ul>
  <li>
      Linux 2.4.x (glibc 2.3) compiled on Red Hat 9
      <ul>
        <li>
            Collector:
	    <ul>
	      <li>
	      <a
	      href="linux_condor_collector-Jun-29-2004.bz2">linux_condor_collector-Jun-29-2004.bz2</a>
	      and associated <a
	      href="condorCollector-Jun-29-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="linux_condor_collector-Jun-17-2004.bz2">linux_condor_collector-Jun-17-2004.bz2</a>
		  and associated <a
		  href="condorCollector-Jun-17-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="linux_condor_collector-Jun-1-2004.bz2">linux_condor_collector-Jun-1-2004.bz2</a>
		  and associated <a
		  href="condorCollector-Jun-1-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="linux_condor_collector-May-21-2004.bz2">linux_condor_collector-May-21-2004.bz2</a>
		  and associated <a
		  href="condorCollector-May-21-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="condor_collector-May-13-2004.bz2">condor_collector-May-13-2004.bz2</a>
		  and associated <a
		  href="condorCollector-May-13-2004.wsdl">WSDL</a>
	      </li>
	    </ul>
	</li>
	<li>
            Schedd:
	    <ul>
	      <li>
	      <a
	      href="linux_condor_schedd-Jun-29-2004.bz2">linux_condor_schedd-Jun-29-2004.bz2</a>
	      and associated <a
	      href="condorSchedd-Jun-29-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="linux_condor_schedd-Jun-17-2004.bz2">linux_condor_schedd-Jun-17-2004.bz2</a>
		  and associated <a
		  href="condorSchedd-Jun-17-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="linux_condor_schedd-Jun-1-2004.bz2">linux_condor_schedd-Jun-1-2004.bz2</a>
		  and associated <a
		  href="condorSchedd-Jun-1-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="linux_condor_schedd-May-21-2004.bz2">linux_condor_schedd-May-21-2004.bz2</a>
		  and associated <a
		  href="condorSchedd-May-21-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="condor_schedd-May-13-2004.bz2">condor_schedd-May-13-2004.bz2</a>
		  and associated <a
		  href="condorSchedd-May-13-2004.wsdl">WSDL</a>
	      </li>
	    </ul>
        </li>
      </ul>
  </li>
  <li>
      Windows 2000/XP compiled with Visual Studio 6.0
      <ul>
        <li>
	    Collector:
	    <ul>
	      <li>
		  <a
		  href="windows_condor_collector-Jun-1-2004.zip">windows_condor_collector-Jun-1-2004.zip</a>
		  and associated <a
		  href="condorCollector-Jun-1-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="windows_condor_collector-May-21-2004.zip">windows_condor_collector-May-21-2004.zip</a>
		  and associated <a
		  href="condorCollector-May-21-2004.wsdl">WSDL</a>
	      </li>
	    </ul>
	</li>
        <li>
	    Schedd:
	    <ul>
	      <li>
		  <a
		  href="windows_condor_schedd-Jun-1-2004.zip">windows_condor_schedd-Jun-1-2004.zip</a>
		  and associated <a
		  href="condorSchedd-Jun-1-2004.wsdl">WSDL</a>
	      </li>
	      <li>
		  <a
		  href="windows_condor_schedd-May-21-2004.zip">windows_condor_schedd-May-21-2004.zip</a>
		  and associated <a
		  href="condorSchedd-May-21-2004.wsdl">WSDL</a>
	      </li>
	    </ul>
	</li>
      </ul>
  </li>
</ul>
-->

<!-- It's in the manual...
<span name="installation">
<h3>Installation</h3>
</span>

All these instructions assume that you have a working HTCondor 6.7
installation.

<ol>
  <li>
      Read about <a href="#security_concerns">security concerns</a>
      related to these daemons.
  </li>
  <li>
      Turn off your Collector and Schedd (with 'condor_off -collector'
      and 'condor_off -schedd').
  </li>
  <li>
      Replace your condor_collector and condor_schedd (find them with
      'condor_config_val COLLECTOR/SCHEDD') with the SOAPified
      condor_collector/schedd.
  </li>
  <li>
      Create a directory called "web" in your HTCondor release directory
      (find the release directory with 'condor_config_val
      RELEASE_DIR') and place the condorCollector/Schedd.wsdl files in
      the new "web" directory.
  </li>
  <li>
      Check permissions. The daemons should have world read/execute
      permission, and the new "web" subdirectory and all files
      contained within it should also be world readable.
  </li>
  <li>
      The BirdBath daemons include a "mini web server" used to
      serve WSDL files and other static content. You have already
      created a RELEASE_DIR/web directory now in your condor_config
      add the option: <code>WEB_ROOT_DIR = $RELEASE_DIR/web</code>
  </li>
  <li>
      The SOAP interface and "mini web server" are disabled by default
      so you must enable them in your condor_config file with:
      <code>ENABLE_SOAP = TRUE</code> and <code>ENABLE_WEB_SERVER =
      TRUE</code>
  </li>
  <li>
      Now restart the Collector and Schedd (with 'condor_on
      -collector/-schedd').
  </li>
</ol>
-->

<!-- In the manual, also it's obsolete information...
<span name="security_concerns">
<h3>Security Concerns</h3>
</span>

<p>

The current release of the BirdBath daemons do not contain any
form of authentication for incoming SOAP messages. This means that
anyone will be able to query and control the daemons. This is not a
serious issue for the Collector as it can only be queried through the
SOAP interface. However, this is an issue for the Schedd, which can
accept jobs that will be run with the privileges of the user who is
running the Schedd. It is a fact that Schedds are often run with root
permissions and we recommend against this when running the SOAP
Schedd. However, there are some precautions that can be taken to
lock-down the SOAP Schedd.

</p>
-->

<!-- In the manual...
<span name="lock-down_options">
<h4>Lock-down Options:</h4>
</span>

<ul>
  <li>
      Make the BirdBath daemons only available to users logged
      into the machine where they are running. Add the following to
      your condor_config file for the machine where you are running the
      BirdBath daemons.
      <br>
      <pre>
      NETWORK_INTERFACE = 127.0.0.1
      CONDOR_HOST = $(IP_ADDRESS)
      HOSTALLOW_READ = *
      HOSTALLOW_WRITE = $(IP_ADDRESS)
      </pre>
  </li>
  <li>
      Do not run the BirdBath daemons as root. Instead, start them
      up as some unprivileged user. Be warned that if you do this with
      the Schedd then <em>all jobs</em> will be run with <em>only</em>
      the privileges of the user who is running the Schedd. This means
      you may run into permission problems on some log/output files for
      jobs.
  </li>
  <li>
      Use the <code>ALLOW_SOAP</code> and <code>DENY_SOAP</code>
      macros in the condor_config file, see <a
      href="http://www.cs.wisc.edu/condor/manual/v6.6/3_7Security_In.html#13535">3.7.5.1
      User-based Authorization</a> of the HTCondor Manual for general
      usage information. For instance, if you want only the machine
      with IP 1.2.3.4 to be able to use the SOAP interface use:
      <code>ALLOW_SOAP = */1.2.3.4</code>. Alternatively, if you want all
      machine except the machine with IP 1.2.3.4 to be able to use the
      SOAP interface use: <code>DENY_SOAP = */1.2.3.4</code>. Note,
      since there is no user authentication done for the SOAP
      interface right now all rules should use a
      "<code>username@domain</code>" of "<code>*</code>".
  </li>
  <li>
      To control access to the embedded web server use the
      <code>ALLOW_READ</code> and <code>DENY_READ</code> macros in
      your condor_config file.
  </li>
</ul>

</p>
-->

<span name="examples"></span>
<h3>Examples</h3>

<ul>
  <li>
      HTCondor Week 2006 has a <a
      href="http://www.cs.wisc.edu/condor/CondorWeek2006/presentations/farrellee_tannenba_APIs.ppt">presentation and tutorial</a> describing job submission and control.
  </li>
</ul>

<!-- Example code and helper libraries are in the release tarball...
<p>

Example code exists both Java using <a
href="http://ws.apache.org/axis">Apache Axis</a> and Python using <a
href="http://pywebsvcs.sourceforge.net">ZSI: The Zolera Soap
Infrastructure</a>. Perl's <a
href="http://www.soaplite.com">SOAP::Lite</a> library has also been
successfully used to communicate with the BirdBath daemons.

</p>

<p>

<b>Note</b>: To get the ZSI examples to work the most recent version
of ZSI from CVS is required and this <a href="zsi_patch">patch</a>
must be applied to code generated by wsdl2py. The kind folks who
created ZSI are working on some fixes to make the patch unnecessary.

</p>

<span name="collector_example">
<h4>Querying the Collector:</h4>
</span>

<p>

The following example file contains Python code using <a
href="http://pywebsvcs.sourceforge.net">ZSI</a>.

</p>

<ul>
  <li>
      <a href="zsi_collector_query_example.txt">zsi_collector_query_example.txt</a>
  </li>
</ul>

<span name="schedd_example"></span>
<h4>Interacting with the Schedd:</h4>

<p>

The following two example files contain Java code using <a
href="http://ws.apache.org/axis">Apache Axis</a>. The first contains
some small code snippets for performing different operations, and the
second is a set of the same operations except error handling is
performed. Please contact <a
href="http://www.cs.wisc.edu/~swaroop">Swaroop</a> and <a
href="http://www.cs.wisc.edu/~matt">Matt</a> if you have problems with
these examples.

</p>

<ul>
  <li>
      <a href="zsi_schedd_submit_example.txt">zsi_schedd_submit_example.txt</a>
  </li>
  <li>
      <a href="axis_schedd_short_sample_code.txt">axis_schedd_short_sample_code.txt</a>
  </li>
  <li>
      <a href="axis_schedd_long_sample_code.txt">axis_schedd_long_sample_code.txt</a>
  </li>
</ul>

<p>

To assist in submitting jobs to the Schedd, Swaroop has written a small
helper library and some examples of how to use it.

</p>

<ul>
  <li>
      <a href="SOAPScheddApiHelper.java">SOAPScheddApiHelper.java</a>
  </li>
  <li>
      <a href="SubmitJob.java">SubmitJob.java</a>
  </li>
</ul>
-->

<span name="known_bugs"></span>
<h3>Known Issues</h3>

<ul>
<!-- Not true anymore...
  <li>
      Two SOAP clients cannot talk to the schedd at the same time.
  </li>
-->
  <li>
      <b>Job Ad NTDomain Attribute</b>: When submitting jobs to a
      Windows SchedD or to be run on Windows you must add an NTDomain
      attribute to your job's ad before calling Submit(). This
      attribute is not created for you in the job ad template returned
      by CreateJobTemplate(). The value of the attribute should be a
      string and a domain where the job's Owner has an account. The
      value of the NTDomain attribute is combined with the Owner
      attribute, e.g. Owner@NTDomain, to lookup the owner's
      credentials.
  </li>
</ul>

<span name="problems"></span>
<h3>Problems?</h3>

<p>

Please contact <a href="http://www.cs.wisc.edu/~matt">Matthew
Farrellee</a> and <a href="http://www.cs.wisc.edu/~tannenba">Todd
Tannenbaum</a>.
</p>

