package org.eu.hanana.reimu.lib.ottohub.api.following;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IFollowingApi;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserListResult;

public class FollowingApi extends ApiBase implements IFollowingApi {
    public FollowingApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "following";
    }

    @Override
    public FollowStatusResult follow(int following_uid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"follow","following_uid", String.valueOf(following_uid))), FollowStatusResult.class);
    }

    @Override
    public FollowStatusResult follow_status(int following_uid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"follow_status","following_uid", String.valueOf(following_uid))), FollowStatusResult.class);
    }

    @Override
    public UserListResult following_list(int uid,int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs("uid", String.valueOf(uid),ACTION,"following_list","offset", String.valueOf(offset),"num", String.valueOf(num))), UserListResult.class);
    }

    @Override
    public UserListResult fan_list(int uid,int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs("uid", String.valueOf(uid),ACTION,"fan_list","offset", String.valueOf(offset),"num", String.valueOf(num))), UserListResult.class);
    }
}
