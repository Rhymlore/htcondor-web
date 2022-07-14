---
title: Plan to replace Grid Community Toolkit functionality in the HTCondor Software Suite
layout: news
---

Plan to replace Grid Community Toolkit functionality in the HTCondor Software Suite
The HTCondor Software Suite (HTCSS) is working to retire the use of the Grid Community Toolkit libraries (or GCT, which is a fork of the former Globus Toolkit). The functionality provided by the GCT is rapidly being replaced by the use of IDTOKENS, SciTokens, and plain SSL within the ecosystem. Currently, HTCSS uses these libraries for:

- Grid jobs submitted to GRAM endpoints
- Grid jobs submitted to CREAM endpoints
- Grid jobs submitted to the ARC CE
- GSI authentication
- Proxy delegation

- The Center for High Throughput Computing plans to gradually reduce use of GCT with support fully ending by March 2023 (6 months after the release of HTCondor 10.0.0); at that point, only proxy delegation and ARC CE submission (through the REST API) will be supported.

__NOTE__: This primarily impacts the submission of "pilot jobs" in grid computing setups; payload jobs that include an X509 credential that needs to be delegated (for access to data sources, for instance) is still supported as HTCondor now implements proxy delegation independently of the GCT.

### Major planned milestones in this timeline include:

- April 2021: HTCondor 9.0.0 is released marking the start of the a new release series, which will continue with full GCT support except that CREAM and GRAM support will be dropped.
- May 2021: HTCondor 9.1.x is released with the following changes:
  - Enables the use of the new ARC CE REST interface without GCT.
- July 2021: HTCondor 9.1.x will include the following changes:
  - Performs proxy delegation without GCT.
  - Removes GSI from default list of authentication methods in both HTCondor and HTCondor-CE (note: GSI will still be available via explicitly configuring AUTHENTICATION_METHODS)
  - Warnings printed to stderr if GSI used by tools.
  - Warnings printed in logs if GSI used by daemons.
- November 2021: HTCondor 9.3.0 default build has GCT removed (i.e. binaries distributed will not include GCT).
  - GSI authentication between HTCondor daemons and tools will no longer work.
  - Submission to the ARC CE gridftp interface will no longer work (grid universe type 'nordugrid').
- September 2022: HTCondor 10.0.0 is released with GCT removed.
- March 2023: Support for HTCondor 9.0.x release series ends. No supported HTCondor code relies on GCT.

CHTC is interested in feedback on the above timeline and in working with HTCSS stakeholders to build a transition plan.

As a critical security library, we depend on external support for the GCT. If the external maintenance for GCT security patches ends earlier than the HTCondor support, the above timeline may need to shorten or the support policy adjusted.