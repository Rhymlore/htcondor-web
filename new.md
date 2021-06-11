---
layout: default
title: HTCondor - What's new with HTCondor?
---

<h2>What's new with HTCondor?</h2>

{% assign news = site.news | sort | reverse %}
{% for item in news %}
<!-- News item -->
<dl>
<dt><a href="{{ item.url | relative_url }}">({{ item.date | date: "%B %e, %Y"}}) <strong>{{ item.title }}</strong></a></dt>
<dd>{{ item.content }}</dd>
</dl>

{% endfor %}