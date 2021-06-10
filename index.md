---
layout: default
title: Home
---
<!--
<script src="switchcontent.js" type="text/javascript"></script>
<style type="text/css">
div.hotnews {
    margin: 1em 2em;
    padding: 0.5em 1em;
    font-size: 120%;
    border: 1px solid rgb(204,204,204);
    text-align: left;
}
</style>
-->

<div class="rowOfBoxes">
    <div class="half noBorderOnLeft">
        <h1>Computing with HTCondor&trade;</h1>
        <!-- <img src="images/HTCondor-head.gif" alt="[HTCondor-head]" border="0" align="left"> -->
        <p>
            Our goal is to develop, implement, deploy, and evaluate mechanisms and policies that support <a href="htc.html">High Throughput Computing (HTC)</a> on large collections of distributively owned computing resources. Guided by both the technological and sociological challenges of such a computing environment, the <a href="http://chtc.cs.wisc.edu/">Center for High Throughput Computing</a> at UW-Madison has been building the open source <a href="description.html">HTCondor distributed computing software</a> (pronounced "aitch-tee-condor") and related technologies to enable scientists and engineers to increase their computing throughput.

            <br><br><span id="name-note">
            Note: The HTCondor Software Suite (HTCSS) was known as 'Condor' from 1988 <a href="https://lists.cs.wisc.edu/archive/condor-users/2012-October/msg00110.shtml">until its name changed</a> in 2012.
            </span>
            If you are looking for Phoenix Software International's software development and library management system for z/VSE or z/OS, click <a href="http://www.phoenixsoftware.com">here</a>.

        </p>

    </div>

    <div class="half">
        <h2>Latest News <a href="index.rss"><img src="/assets/images/rssicon.gif" alt="[RSS]"></a></h2>

        {% assign news = site.news | sort | reverse %}
        {% for item in news limit:6 %}
            <a class="newsHeading" href="{{ item.url | relative_url }}">{{ item.title }}</a>
            <p class="newsDate">{{ item.date | date: "%B %e, %Y" }}</p>
        {% endfor %}

        <div class="more"><a href="new.html">More News &raquo;</a></div>

            <p class="filler"><!-- Filler para to extend left vertical line --></p>
    </div>
</div>

<div class="rowOfBoxes">
<!-- This is "hotnews" template, used for relatively short lived news we
     want to emphasize, like Condor Week.  Keep it brief and use with care. -->

</div>

<div class="rowOfBoxes dividingBorderAbove">

    <div class="oneThird noBorderOnLeft">
        <h1>Software</h1>
        <ul>
            <li><a href="description.html">What is the HTCondor Software Suite (HTCSS)?</a></li>
            <li><a href="downloads.html"><strong>Downloads</strong></a> including HTCondor source and binaries for Linux, Windows, and Mac.</li>
            <li><a href="https://htcondor.readthedocs.io/en/latest/"><strong>Documentation</strong></a> includes <strong><a
            href="manual/quickstart.html">the Quick Start Guide</a></strong> and the <a href="https://htcondor.readthedocs.io/en/latest/">HTCondor Manual</a>. Also see <a href="https://htcondor-wiki.cs.wisc.edu/index.cgi/wiki?p=HowToAdminRecipes"><strong>HOWTO recipes</strong></a> and <a href="http://vivaldi.ll.iac.es/sieinvens/siepedia/pmwiki.php?n=HOWTOs.CondorSubmitFile">job submission examples</a>.</li>
            <li><a href="htcondor-support/">Support Options</a> include community and professional solutions.</li>
            <li><a href="https://htcondor-wiki.cs.wisc.edu/index.cgi/wiki?p=DeveloperReleasePlan">Forthcoming release plans</a></li>
            <li><a href="license.html">License Information</a></li>
            <li><a href="security/">Security Information</a></li>
        </ul>
    </div>

    <div class="oneThird column-border">
        <h1>Community</h1>
        <ul>
            <li><a href="mail-lists/"><strong>Email Lists</strong></a> - ask questions and share experiences with users worldwide.</li>
            <li><a href="http://htcondor.org/HTCondorWeek2020">HTCondor Week</a> is our annual community meeting in Madison, and we often have an annual meeting in Europe as well. <a href="past_condor_weeks.html">Materials from past meetings</a> include talks from science and industry, plus <strong>useful tutorials</strong>.</li>
            <li><a href="http://condor-wiki.cs.wisc.edu/index.cgi/wiki">HTCondor Wiki</a> contains <a href="https://condor-wiki.cs.wisc.edu/index.cgi/wiki?p=HowToAdminRecipes">FAQs</a>, bug tickets, and more. </li>
            <!-- <li><a href="http://htcondor.github.com/planet/">Blog Posts</a> aggregated at GitHub from multiple sites.</li> -->
            <li><a href="logos/">Official Logos</a></li>
            <!-- <li><a href="talks.html">Slide Presentations</a></li> -->
        </ul>
        <p class="filler"><!-- Filler para to extend left vertical line --></p>
        <p class="filler"><!-- Filler para to extend left vertical line --></p>
        <p class="filler"><!-- Filler para to extend left vertical line --></p>
        <p class="filler"><!-- Filler para to extend left vertical line --></p>
    </div>

    <div class="oneThird">
        <h1>Research and Development</h1>
        <ul>
            <li><a href="publications.html"><strong>Research Publications</strong></a></li>
            <li><a href="research.html">HTCondor Technologies</a> including the widely used <a href="classad/classad.html">ClassAd Library</a></li>
            <li><a href="https://condor-wiki.cs.wisc.edu/index.cgi/wiki?p=MakingContributions">Information for Developers</a></li>
            <li><a href="http://chtc.cs.wisc.edu/jobs.shtml">Jobs</a> available in support of distributed computing at UW-Madison</li>
            <li><a href="people.html">The CHTC Team</a> at the UW-Madison, and <a href="https://condor-wiki.cs.wisc.edu/index.cgi/wiki?p=DeveloperHomePages">a list of code contributors and maintainers.</a></li>
        </ul>
        <p class="filler"><!-- Filler para to extend left vertical line --></p>
        <p class="filler"><!-- Filler para to extend left vertical line --></p>
        <p class="filler"><!-- Filler para to extend left vertical line --></p>
        <p class="filler"><!-- Filler para to extend left vertical line --></p>
    </div>

</div>
