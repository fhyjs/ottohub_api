package org.eu.hanana.reimu.lib.ottohub.api.moderation;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IManageApi;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IModerationApi;

public class ModerationApi extends ApiBase implements IModerationApi {
    public ModerationApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "moderation";
    }

    @Override
    public EmptyResult report_blog(int bid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"report_blog","bid", String.valueOf(bid))), EmptyResult.class);
    }

    @Override
    public EmptyResult approve_blog(int bid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"approve_blog","bid", String.valueOf(bid))), EmptyResult.class);
    }

    @Override
    public EmptyResult reject_blog(int bid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"reject_blog","bid", String.valueOf(bid))), EmptyResult.class);
    }

    @Override
    public EmptyResult report_video(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"report_video","vid", String.valueOf(vid))), EmptyResult.class);
    }

    @Override
    public EmptyResult approve_video(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"approve_video","vid", String.valueOf(vid))), EmptyResult.class);
    }

    @Override
    public EmptyResult reject_video(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"reject_video","vid", String.valueOf(vid))), EmptyResult.class);
    }
}
