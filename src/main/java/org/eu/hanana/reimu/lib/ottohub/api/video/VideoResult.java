package org.eu.hanana.reimu.lib.ottohub.api.video;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IStatusGetter;
import org.jetbrains.annotations.Nullable;

public class VideoResult extends ApiResultBase {
    public int vid;
    public int uid,category,type,is_deleted,audit_status;
    public int like_count;
    public int favorite_count;
    public int view_count;
    public String title,time,intro;
    public String cover_url,username,avatar_url,userintro,video_url,tag;
    public int if_like,if_favorite;

}
