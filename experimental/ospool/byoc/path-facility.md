---
layout: Markdown
title: Run a Job on the PATh Facility Using Your Credits There
head_extension: |
  <meta name="robots" content="noindex">
---

This recipe assumes that you have decided to use your credits
for the PATh facility to run one of your HTCondor jobs.  It takes you step by
step through the process of Bringing Your Own Capacity (BYOC) in the
form of those credits to an OSG Connect access point and using that
resource to run your HTCondor job.  In what follows, we refer to the set
of resources leased from the PATh facility using those credits as an "annex."

In this recipe, we assume that the job has not yet been placed at an
OSG Connect access point when we begin.

##### Ingredients

- An OSG Connect account and password
- An HTCondor job submit file (example.submit).
- Credits for the PATh facility.
- Command-line login access to the PATH facility.  (see [the PATh facility's instructions for gaining access] (https://path-cc.io/facility/registration.html#login).
  We'll use `LOGIN_NAME` to refer to your login name on the PATh facility.
- A name for your PATh facility annex (example).  By convention,
  this is the name of the submit file you want to run, without its extension.

#### Assumptions

* You want to run the job described above on the PATh facility.
* The job described above fits within the [capabilities](https://path-cc.io/facility/#facility-description) of the PATh facility.

#### Preparation

First, you will need to know the `AccountingGroup` (FIXME) of your credits on
the PATh facility.  There's presently no tool to determine this by logging
in to the PATH facility.

#### Instructions

##### 1. Log into the OSG Connect Access Point

Log into an OSG Connect access point (e.g., `login04.osgconnect.net` or
`login05.osgconnect.net`) using your OSG Connect account and password.

##### 2. Submit the Job

Submit the job on the access point, indicating that you want it to run
on your own resource (your PATh Facility credits, in this case) with the
`--annex-name` option.  (Don't copy the `$`; in this and other examples
further down the page, the `$` just signifies something you type in,
rather than something that the computer prints out.)

    $ htcondor job submit example.submit \
      --annex-name example
    Job 123 was submitted and will run only on the annex 'example'.

Notes on the output of this command:
- 123 is the JOB_ID assigned by the access point to the placed job.
- Placing the job with the annex name specified means that the job
  won't run anywhere other than the annex.
- Note that the annex name does not say anything about the PAth facility; it is simply
  a label for the PATh facility resources we will be provisioning
  in the next step.

##### 3. Lease the Resources

To run your job on the PATh facility, you will need to create an "annex" there;
an annex is a named set of leased resources.  The following command will
submit a request to lease an annex named `example` from the PATh facility.
The accounting group `AccountingGroup` will be charged for resources used (by
default, two nodes).  The **text in bold** is emphasized to distinguish
it from the PATh facility's log-in prompt.

<pre><code>$ htcondor annex create example cpu@path-facility --project PROJECT_ID --login-name LOGIN_NAME
<b>This command will access the system named 'PATh Facility' via SSH.  To proceed, follow the
prompts from that system below; to cancel, hit CTRL-C.</b>
</code></pre>

You will need to log into the PATh facility at this prompt.

<pre><code><b>Thank you.</b>

Requesting annex named 'example' from queue 'cpu' on the system named 'PATh Facility'...
</code></pre>

The tool will display an indented log of the request progress, because
it may take a while.  Once the request is done, it will display:

	... requested.

It may take some time for the PATh facility to establish the requested annex.

##### 4. Confirm that the Resources are Available

Check on the status of the annex to make sure it has started up correctly.

	$ htcondor annex status example
	Annex 'example' is not established.
	You requested 2 nodes for this annex, of which 0 are in established
	annexes.
	There are 0 CPUs in the established nodes, of which 0 are busy.
	1 jobs must run on this annex, and 0 currently are.
	You made 1 resource request(s) for this annex, of which 1 are pending, 0
	are established, and 0 have retired.

Give the PATh facility a few more minutes to grant your request and then check again.

	$ htcondor annex status example
	Annex 'example' is established.
	Its oldest established request is about 0.29 hours old and will retire in
	0.71 hours.
	You requested 2 nodes for this annex, of which 2 are in established
	annexes.
	There are 136 CPUs in the established nodes, of which 0 are busy.
	1 jobs must run on this annex, and 0 currently are.
	You made 1 resource request(s) for this annex, of which 0 are pending, 1
	are established, and 0 have retired.

##### 5. Confirm Job is Running on the Resources

After some time has passed, check the status of the job to make sure
that it started running.

	$ htcondor job status 123
	Job will only run on your annex named 'example'.
	Job has been running for 0 hour(s), 2 minute(s), and 21 second(s).

We want to make sure the job is indeed running on the correct annex
resources.  There are two different ways we could do this.  We could ask
the annex itself:

	$ htcondor annex status example
	Annex 'example' is established.
	Its oldest established request is about 0.69 hours old and will retire in
	0.31 hours.
	You requested 2 nodes for this annex, of which 2 are in established
	annexes.
	There are 136 CPUs in the established nodes, of which 1 are busy.
	1 jobs must run on this annex, and 1 currently are.
	You made 1 resource request(s) for this annex, of which 0 are pending,
	1 are established, and 0 have retired.

This indicates that the annex is running jobs, but we don't know for
sure that it's the one we just submitted.  Instead, let's ask the job
itself what resources it is running on.

	$ htcondor job resources 123
	Job is using annex 'example', resource 449_0@osgvo-docker-pilot-facility-74db64959b-q2mqf.

##### 6. Terminate the Resource Lease

At this point we know that our job is running on the correct resources,
so we can wait for it to finish running.  After some time has passed, we
ask for its status again:

	$ htcondor job status 123
	Job is completed.

Now that the job has finished running, we want to shut down the annex.
When the annex finishes shutting down, the resource lease will be
terminated.  We could just wait for the annex time out automatically
(after 20 minutes of being idle), but we would rather shut the annex down
explicitly to avoid wasting our allocation.

	$ htcondor annex shutdown example
	Shutting down annex 'example'...
	... each resource in 'example' has been commanded to shut down.
	It may take some time for each resource to finish shutting down.
	Annex requests that are still in progress have not been affected.

At this point our workflow is completed, and our job has run
successfully on our allocation.

##### Reference

You can run either of the following commands for an up-to-date summary
of their corresponding options.

	$ htcondor job --help
	$ htcondor annex --help
