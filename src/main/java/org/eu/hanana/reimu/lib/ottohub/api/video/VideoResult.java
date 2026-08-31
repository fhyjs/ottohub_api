package org.eu.hanana.reimu.lib.ottohub.api.video;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IStatusGetter;
import org.eu.hanana.reimu.lib.ottohub.channel.ChannelDetailResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VideoResult extends ApiResultBase {
    public int vid;
    public int uid,category,type,is_deleted,audit_status;
    public int like_count;
    public int favorite_count;
    public int view_count;
    public int comment_count;
    public int parent_comment_count;
    public int duration;
    public int channel_id;
    public String title,time,intro;
    public String cover_url,username,avatar_url,userintro,video_url,tag;
    public int if_like,if_favorite;
    public List<String> tags;
    public String video_m3u8_url;
    public ChannelDetailResult channel_detail;
}
