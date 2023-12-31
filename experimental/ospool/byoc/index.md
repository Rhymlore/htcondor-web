---
layout: Markdown
title: Bringing Your Own Capacity
head_extension: |
    <meta name="robots" content="noindex">
---

You can bring your own resources to an OS Pool access point.  This can be more
convenient than taking your jobs to those resources.

#### Bringing an HPC Allocation to the OS Pool

If you have an allocation for time on the Anvil, Stampede2,
Bridges-2, or Expanse systems, you can use the `htcondor` command line
tool on `login04.osgconnect.net` or `login05.osgconnect.net` to run
jobs there.  In order to get started, you'll need an account on the HPC system,
with the ability to log in to the system via the command line.
You will also need a job that will run on one of the listed systems.
(You can download an [example job](example_job) for testing.)

Follow the recipe to run a job on:
- [Stampede2](stampede2)
- [Bridges-2](bridges2)
- [Expanse](expanse)
- [Anvil](anvil)

#### Bringing PATh Facility Credits to the OS Pool

If you have credits for the PATh facility,
you can use the `htcondor` command line
tool on `login04.osgconnect.net` or `login05.osgconnect.net` to run
jobs there.  In order to get started, you'll need an account on the
PATh facility, with the ability to log in there via the
command line.  You will also need a job that will run at the PATh facility.
(You can download an [example job](example_job) for testing.)

Follow the recipe to run a job on:
- the [PATh facility](path-facility)
