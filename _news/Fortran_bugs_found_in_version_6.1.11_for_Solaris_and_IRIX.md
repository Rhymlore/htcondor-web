---
title: Fortran bugs found in version 6.1.11 for Solaris and IRIX
og_title: Fortran bugs found in version 6.1.11 for Solaris and IRIX
link: 
date: 2000-02-01
layout: news
---

Condor version 6.1.11 contains bugs in the way we handle certain system calls that are used by Fortran.  This is a problem particularly on Solaris and IRIX, though other platforms might have problems as well.  We will release a new version shortly that corrects these problems.  If you are only using vanilla jobs, this should not effect you.  If you do not relink your jobs with condor_compile using the 6.1.11 libraries, you will also not have this problem (though you also won't be able to use many of the new features in 6.1.11).
