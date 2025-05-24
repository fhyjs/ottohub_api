package org.eu.hanana.reimu.lib.ottohub.api.engagement;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IEngagementApi;

public class EngagementApi extends ApiBase implements IEngagementApi {
    public EngagementApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "engagement";
    }

    @Override
    public EngagementResult like_blog(int bid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"like_blog","bid",String.valueOf(bid))), EngagementResult.class);
    }

    @Override
    public EngagementResult favorite_blog(int bid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"favorite_blog","bid",String.valueOf(bid))), EngagementResult.class);
    }

    @Override
    public EngagementResult like_video(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"like_video","vid",String.valueOf(vid))), EngagementResult.class);
    }

    @Override
    public EngagementResult favorite_video(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"favorite_video","vid",String.valueOf(vid))), EngagementResult.class);
    }
}
