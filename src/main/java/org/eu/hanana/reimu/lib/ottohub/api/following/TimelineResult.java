package org.eu.hanana.reimu.lib.ottohub.api.following;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;

public class TimelineResult extends ApiResultBase {
    public String content_type,title,content,time,username,avatar_url;
    public int bid,uid,like_count,favorite_count,view_count;
}
