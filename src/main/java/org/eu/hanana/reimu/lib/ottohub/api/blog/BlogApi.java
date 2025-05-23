package org.eu.hanana.reimu.lib.ottohub.api.blog;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IBlogApi;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoListResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoResult;

public class BlogApi extends ApiBase implements IBlogApi {
    public BlogApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "blog";
    }

    @Override
    public BlogListResult random_blog_list(int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"random_blog_list","num", String.valueOf(num))), BlogListResult.class);
    }

    @Override
    public BlogListResult new_blog_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"new_blog_list","offset",String.valueOf(offset),"num", String.valueOf(num))), BlogListResult.class);
    }

    @Override
    public BlogListResult popular_blog_list(int time_limit, int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"popular_blog_list","time_limit",String.valueOf(time_limit),"offset",String.valueOf(offset),"num", String.valueOf(num))), BlogListResult.class);
    }

    @Override
    public BlogListResult search_blog_list(String search_term, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"search_blog_list","search_term",search_term,"num", String.valueOf(num))), BlogListResult.class);
    }

    @Override
    public BlogListResult id_blog_list(int bid) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"id_blog_list","bid", String.valueOf(bid))), BlogListResult.class);
    }

    @Override
    public BlogListResult user_blog_list(int uid, int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"user_blog_list","uid",String.valueOf(uid),"offset",String.valueOf(offset),"num", String.valueOf(num))), BlogListResult.class);
    }

    @Override
    public BlogListResult audit_blog_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"audit_blog_list","offset",String.valueOf(offset),"num", String.valueOf(num))), BlogListResult.class);
    }

    @Override
    public BlogResult get_blog_detail(int bid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"get_blog_detail","bid", String.valueOf(bid))), BlogResult.class);
    }
}
