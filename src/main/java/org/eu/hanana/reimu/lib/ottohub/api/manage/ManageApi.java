package org.eu.hanana.reimu.lib.ottohub.api.manage;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IManageApi;

public class ManageApi extends ApiBase implements IManageApi {
    public ManageApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "manage";
    }

    @Override
    public EmptyResult delete_blog(int bid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"delete_blog","bid", String.valueOf(bid))), EmptyResult.class);
    }

    @Override
    public EmptyResult appeal_blog(int bid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"appeal_blog","bid", String.valueOf(bid))), EmptyResult.class);
    }

    @Override
    public EmptyResult delete_video(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"delete_video","vid", String.valueOf(vid))), EmptyResult.class);
    }

    @Override
    public EmptyResult appeal_video(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"appeal_video","vid", String.valueOf(vid))), EmptyResult.class);
    }
}
