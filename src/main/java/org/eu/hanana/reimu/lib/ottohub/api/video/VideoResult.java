package org.eu.hanana.reimu.lib.ottohub.api.video;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IStatusGetter;
import org.jetbrains.annotations.Nullable;

public class VideoResult extends ApiResultBase {
    public int vid;
    public int uid;
    public int like_count;
    public int favorite_count;
    public int view_count;
    public String title,time;
    public String cover_url,username,avatar_url;

}
