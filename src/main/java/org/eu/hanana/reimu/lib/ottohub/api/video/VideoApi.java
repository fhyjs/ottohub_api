package org.eu.hanana.reimu.lib.ottohub.api.video;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.auth.SendRegisterVerificationCodeResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IVideoApi;

public class VideoApi extends ApiBase implements IVideoApi {
    public VideoApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public VideoListResult random_video_list(int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"random_video_list","num", String.valueOf(num))), VideoListResult.class);
    }

    @Override
    public VideoListResult new_video_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"new_video_list","offset",String.valueOf(offset),"num", String.valueOf(num))), VideoListResult.class);
    }

    @Override
    public VideoListResult popular_video_list(int time_limit, int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"popular_video_list","time_limit",String.valueOf(time_limit),"offset",String.valueOf(offset),"num", String.valueOf(num))), VideoListResult.class);
    }

    @Override
    public VideoListResult category_video_list(int category, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"category_video_list","category",String.valueOf(category),"num", String.valueOf(num))), VideoListResult.class);
    }

    @Override
    public VideoListResult search_video_list(String search_term, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"search_video_list","search_term",search_term,"num", String.valueOf(num))), VideoListResult.class);
    }

    @Override
    public VideoListResult id_video_list(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"id_video_list","vid", String.valueOf(vid))), VideoListResult.class);
    }

    @Override
    public VideoListResult user_video_list(int uid, int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"user_video_list","offset",String.valueOf(offset),"num", String.valueOf(num),"uid", String.valueOf(uid))), VideoListResult.class);
    }

    @Override
    public VideoListResult audit_video_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"audit_video_list","offset",String.valueOf(offset),"num", String.valueOf(num))), VideoListResult.class);
    }

    @Override
    public VideoResult get_video_detail(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"get_video_detail","vid", String.valueOf(vid))), VideoResult.class);
    }

    @Override
    public String getModule() {
        return "video";
    }
}
