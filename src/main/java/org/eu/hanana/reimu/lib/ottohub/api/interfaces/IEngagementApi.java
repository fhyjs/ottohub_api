package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.engagement.EngagementResult;

public interface IEngagementApi {
    @RequireToken
    EngagementResult like_blog(int bid);
    @RequireToken
    EngagementResult favorite_blog(int bid);
    @RequireToken
    EngagementResult like_video(int vid);
    @RequireToken
    EngagementResult favorite_video(int vid);
}
