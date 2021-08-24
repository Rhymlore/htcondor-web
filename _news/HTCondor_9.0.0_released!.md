---
title: HTCondor 9.0.0 released!
og_title: HTCondor 9.0.0 released!
link: 
date: 2021-04-14
layout: news
release_type: HTCondor
release_number: 9.0.0
---

The HTCondor team is pleased to announce the release of HTCondor 9.0.0. After two years of development, this is the first release of the new stable series. It includes all the enhancements and bug fixes in the 8.9 series. Many of these changes have focused on improving the security of HTCondor and improving the utility of the file transfer plugins.  Highlights of this release are: Absent any configuration, a new HTCondor installation denies authorization to all users; AES encryption is used for all communication and file transfers by default (Hardware accelerated when available); New IDTOKEN authentication method enables fine-grained authorization control designed to replace GSI authentication; Improved support for GPUs, including machines with multiple GPUs; New condor_watch_q tool that efficiently provides live job status updates; Many improvements to the Python bindings, including new bindings for DAGMan and chirp; Improved curl, https, box, Amazon S3, and google drive file transfer plugins supporting uploads and authentication; File transfer times are now recorded in the job log; Added support for jobs that need to acquire and use OAUTH tokens; Many memory footprint and performance improvements in DAGMan; Submitter ceilings allow administrators to set limits on the number of running jobs per user across the pool.  More details about the new features can be found in the <a href="https://htcondor.readthedocs.io/en/v9_0/version-history/upgrading-from-88-to-90-series.html">Upgrade Section</a>  For a full list of changes, please consult the <a href="https://htcondor.readthedocs.io/en/v9_0/version-history/development-release-series-89.html">8.9 version history</a>   Try out our  <a href="https://htcondor.readthedocs.io/en/latest/getting-htcondor/index.html"> new helpful installation scripts</a>.  HTCondor 9.0.0 binaries and source code are available from our <a href="http://htcondor.org/downloads/">Downloads</a> page. 
