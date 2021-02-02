---
layout: default
title: HTCondor - What's new with HTCondor?
---

<h2>What's new with HTCondor?</h2>

{% for item in site.data.news %}
<!-- News item -->
<dl>
<dt>( {{ item.date }} ) <strong>{{ item.title }}</strong></dt>
<dd>{{ item.news }}</dd>
</dl>

{% endfor %}