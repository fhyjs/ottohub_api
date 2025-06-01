package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.auth.LoginResult;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.profile.*;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoListResult;

public interface IProfileApi {
    @RequireToken
    FavoriteBlogListResult favorite_blog_list(int offset,int num);
    @RequireToken
    FavoriteVideoListResult favorite_video_list(int offset, int num);
    @RequireToken
    UserProfileResult user_profile();
    @RequireToken
    EmptyResult update_username(String username);
    @RequireToken
    EmptyResult update_qq(String qq);
    @RequireToken
    EmptyResult update_sex(String sex);
    @RequireToken
    EmptyResult update_intro(String intro);
    @RequireToken
    LoginResult update_pw(String pw);
    @RequireToken
    EmptyResult approve_avatar(int uid_of_avatar);
    @RequireToken
    EmptyResult reject_avatar(int uid_of_avatar);
    @RequireToken
    EmptyResult approve_cover(int uid_of_cover);
    @RequireToken
    EmptyResult reject_cover(int uid_of_cover);
    @RequireToken
    UserResult user_data();
    @RequireToken
    ManageBlogListResult manage_blog_list(int offset,int num);
    @RequireToken
    ManageVideoListResult manage_video_list(int offset, int num);
    @RequireToken
    AvatarListResult audit_avatar_list(int offset,int num);
    @RequireToken
    CoverListResult audit_cover_list(int offset,int num);
}
