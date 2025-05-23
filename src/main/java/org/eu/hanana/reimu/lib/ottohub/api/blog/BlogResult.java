package org.eu.hanana.reimu.lib.ottohub.api.blog;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;

public class BlogResult extends ApiResultBase {
    public int bid,uid,like_count,favorite_count,view_count,if_like,if_favorite;
    public String title,content,time,avatar_url,username;
}
