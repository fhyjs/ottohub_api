package org.eu.hanana.reimu.lib.ottohub.api.video;

import com.google.gson.reflect.TypeToken;
import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.DataWrapResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IVideoApi;

@SuppressWarnings("unchecked")
public class VideoApi extends ApiBase implements IVideoApi {
    public VideoApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public VideoListResult random_video_list(int num) {
        return random_video_list_new(num).getData();
    }
    @Override
    public DataWrapResult<VideoListResult> random_video_list_new(int num) {
        return (DataWrapResult<VideoListResult>)(gson.fromJson(sendGet(getUrlWithArgs("random","num", String.valueOf(num))), TypeToken.getParameterized(DataWrapResult.class,VideoListResult.class)));
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
    public VideoListResult related_video_list(int vid, int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"related_video_list","offset",String.valueOf(offset),"vid",String.valueOf(vid),"num", String.valueOf(num))), VideoListResult.class);
    }

    @Override
    public DataWrapResult<VideoPresignedResult> video_presigned(String extension) {
        return (DataWrapResult<VideoPresignedResult>) gson.fromJson(sendGet(getUrlWithArgs("video-presigned",TOKEN,ottohubApi.getLoginToken())), TypeToken.getParameterized(DataWrapResult.class,VideoPresignedResult.class));
    }

    @Override
    public VideoResult get_video_detail(int vid) {
        return get_video_detail_new(vid).getData();
    }
    @Override
    public DataWrapResult<VideoResult> get_video_detail_new(int vid) {
        return (DataWrapResult<VideoResult>) gson.fromJson(sendGet(getUrlWithArgs(vid,TOKEN,ottohubApi.getLoginToken(),"vid", String.valueOf(vid))), TypeToken.getParameterized(DataWrapResult.class,VideoResult.class));
    }

    @Override
    public String getModule() {
        return "video";
    }
}
