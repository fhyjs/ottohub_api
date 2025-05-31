package org.eu.hanana.reimu.lib.ottohub.api.profile;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoListResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoResult;

import java.util.List;

public class FavoriteVideoListResult extends VideoListResult {
    public int favorite_video_count;
}
