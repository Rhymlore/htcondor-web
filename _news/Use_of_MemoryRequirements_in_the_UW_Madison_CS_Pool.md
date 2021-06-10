---
title: Use of MemoryRequirements in the UW Madison CS Pool
og_title: Use of MemoryRequirements in the UW Madison CS Pool
link: 
date: 1999-03-01
layout: news
---

The UW Madison CS Condor pool has been configured to check for a MemoryRequirements parameter in all Condor jobs.  This     parameter specifies, in megabytes, how much physical memory your job   needs to run efficiently.  If this parameter is not specified, Condor  will assume a default value of 128 MB.  Condor will only run jobs on   machines with enough available physical memory to satisfy the jobs'   memory requirements.  To specify this parameter, please add the following to your job description file(s):  <pre>   +MemoryRequirements = 90 </pre>  replacing 90 with the actual memory requirements of your job in megabytes. 			   We encourage you to continue to specify your job's virtual memory requirements with the image_size command in your job description  file.
