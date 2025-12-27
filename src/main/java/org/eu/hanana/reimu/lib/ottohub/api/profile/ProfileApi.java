package org.eu.hanana.reimu.lib.ottohub.api.profile;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.auth.LoginResult;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IProfileApi;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserListResult;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoListResult;

public class ProfileApi extends ApiBase implements IProfileApi {
    public ProfileApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "profile";
    }

    @Override
    public FavoriteBlogListResult favorite_blog_list(int offset, int num) {
         return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"favorite_blog_list","offset", String.valueOf(offset),"num",String.valueOf(num))), FavoriteBlogListResult.class);
    }

    @Override
    public FavoriteVideoListResult favorite_video_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"favorite_video_list","offset", String.valueOf(offset),"num",String.valueOf(num))), FavoriteVideoListResult.class);
    }

    @Override
    public UserProfileResult user_profile() {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"user_profile")), UserProfileResult.class);
    }

    @Override
    public EmptyResult update_username(String username) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"update_username","username" ,username)), EmptyResult.class);
    }

    @Override
    public EmptyResult update_qq(String qq) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"update_qq","qq" ,qq)), EmptyResult.class);
    }

    @Override
    public EmptyResult update_sex(String sex) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"update_sex","sex" ,sex)), EmptyResult.class);
    }

    @Override
    public EmptyResult update_intro(String intro) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"update_intro","intro" ,intro)), EmptyResult.class);
    }

    @Override
    public LoginResult update_pw(String pw) {
        LoginResult loginResult = gson.fromJson(sendGet(getUrlWithArgs(TOKEN, getToken(), ACTION, "update_pw", "pw", pw)), LoginResult.class);
        if (loginResult.isSuccess()){
            ottohubApi.getLoginResult().token=loginResult.token;
        }
        return loginResult;
    }

    @Override
    public EmptyResult approve_avatar(int uid_of_avatar) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"approve_avatar","uid_of_avatar" , String.valueOf(uid_of_avatar))), EmptyResult.class);
    }

    @Override
    public EmptyResult reject_avatar(int uid_of_avatar) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"reject_avatar","uid_of_avatar" , String.valueOf(uid_of_avatar))), EmptyResult.class);
    }

    @Override
    public EmptyResult approve_cover(int uid_of_cover) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"approve_cover","uid_of_cover" , String.valueOf(uid_of_cover))), EmptyResult.class);
    }

    @Override
    public EmptyResult reject_cover(int uid_of_cover) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"reject_cover","uid_of_cover" , String.valueOf(uid_of_cover))), EmptyResult.class);
    }

    @Override
    public UserResult user_data() {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"user_data")), UserResult.class);
    }

    @Override
    public ManageBlogListResult manage_blog_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"manage_blog_list","offset", String.valueOf(offset),"num",String.valueOf(num))), ManageBlogListResult.class);
    }

    @Override
    public ManageVideoListResult manage_video_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"manage_video_list","offset", String.valueOf(offset),"num",String.valueOf(num))), ManageVideoListResult.class);
    }

    @Override
    public AvatarListResult audit_avatar_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"audit_avatar_list","offset", String.valueOf(offset),"num",String.valueOf(num))), AvatarListResult.class);
    }

    @Override
    public CoverListResult audit_cover_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"audit_cover_list","offset", String.valueOf(offset),"num",String.valueOf(num))), CoverListResult.class);
    }

    @Override
    public VideoListResult history_video_list() {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"history_video_list")), VideoListResult.class);
    }

    @Override
    public IsAuditResult is_audit() {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"is_audit")), IsAuditResult.class);
    }
}
