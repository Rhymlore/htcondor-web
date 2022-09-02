---
layout: Markdown
title: an example job
head_extension: |
    <meta name="robots" content="noindex">
---

You can copy and paste the following submit file; name the file
`example.submit` to go along with the recipes.  It needs
the `busybox.sif` file to run; see below.

	universe                = container
	# wget https://htcondor.org/ospool/byor/busybox.sif
	container_image         = busybox.sif
	executable              = /bin/sleep
	arguments               = 1200

	should_transfer_files   = YES
	output                  = example.output
	error                   = example.err
	log                     = example.log

	queue 1

You can download `busybox.sif` using `wget`; run this command in the same
directory that you created the submit file in.

	$ wget https://htcondor.org/ospool/byor/busybox.sif
