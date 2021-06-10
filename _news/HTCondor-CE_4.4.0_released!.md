---
title: HTCondor-CE 4.4.0 released!
og_title: HTCondor-CE 4.4.0 released!
link: 
date: 2020-06-16
layout: news
---

The HTCondor team is pleased to announce the release of HTCondor-CE 4.4.0.  Highlights of this release are: Add plug-in interface to HTCondor-CE View and separate out OSG-specific code and configuration; Add configuration option (COMPLETED_JOB_EXPIRATION) for how many days completed jobs may stay in the queue; Replace APEL uploader SchedD cron with init and systemd services; Fix HTCondor-CE View SchedD query that caused "Info" tables to be blank; Add the CE registry web application to the Central Collector; Identify broken job routes upon startup; Add benchmarking parameters to the BDII provider via `HTCONDORCE_SPEC` in the configuration; Fix handling of unmapped GSI users in the Central Collector; Fix reference to old BDII configuration values; Drop vestigial Central Collector configuration generator script and service; Fix unmapped GSI/SSL regular expressions and allow unmapped entities to advertise to the Central Collector; Add SSL support for reporting to Central Collectors; GLUE2 validation improvements for the BDII provider.  A complete list of new features and fixed bugs can be found in the <a href="https://htcondor-ce.readthedocs.io/en/latest/releases/#htcondor-ce-4-version-history"> version history</a>. HTCondor-CE 4.4.0 binaries are available from our <a href="http://htcondor.org/yum/">YUM Repository</a>. 
