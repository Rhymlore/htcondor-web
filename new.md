---
layout: subpage
title: What's new with HTCondor?
---

{% assign news = site.news | sort | reverse %}
{% for item in news %}
<!-- News item -->
<dl class="p-3 bg-light">
<dt><a href="{{ item.url | relative_url }}">({{ item.date | date: "%B %e, %Y"}}) <strong>{{ item.title }}</strong></a></dt>
<dd>{{ item.content }}</dd>
</dl>

{% endfor %}