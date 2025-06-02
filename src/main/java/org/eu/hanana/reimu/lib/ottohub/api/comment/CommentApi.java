package org.eu.hanana.reimu.lib.ottohub.api.comment;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.ICommentApi;

public class CommentApi extends ApiBase implements ICommentApi {
    public CommentApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "comment";
    }

    @Override
    public CommentListResult blog_comment_list(int bid, int parent_bcid, int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"blog_comment_list","bid", bid,"parent_bcid",parent_bcid,"offset",offset,"num",num)), CommentListResult.class);
    }

    @Override
    public CommentListResult video_comment_list(int vid, int parent_vcid, int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"video_comment_list","vid", vid,"parent_vcid",parent_vcid,"offset",offset,"num",num)), CommentListResult.class);
    }

    @Override
    public IfGetExpResult comment_blog(int bid, int parent_bcid, String content) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"comment_blog","bid", bid,"parent_bcid",parent_bcid,"content",content)), IfGetExpResult.class);
    }

    @Override
    public IfGetExpResult comment_video(int vid, int parent_vcid, String content) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"comment_video","vid", vid,"parent_vcid",parent_vcid,"content",content)), IfGetExpResult.class);
    }

    @Override
    public EmptyResult delete_blog_comment(int bcid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"delete_blog_comment","bcid", bcid)), EmptyResult.class);
    }

    @Override
    public EmptyResult delete_video_comment(int vcid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"delete_video_comment","vcid", vcid)), EmptyResult.class);
    }

    @Override
    public EmptyResult report_blog_comment(int bcid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"report_blog_comment","bcid", bcid)), EmptyResult.class);
    }

    @Override
    public EmptyResult report_video_comment(int vcid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"report_video_comment","vcid", vcid)), EmptyResult.class);
    }
}
