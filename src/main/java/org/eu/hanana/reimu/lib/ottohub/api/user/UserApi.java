package org.eu.hanana.reimu.lib.ottohub.api.user;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogListResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IUserApi;

public class UserApi extends ApiBase implements IUserApi {
    public UserApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "user";
    }

    @Override
    public UserListResult search_user_list(String search_term, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"search_user_list","num", String.valueOf(num),"search_term",search_term)), UserListResult.class);
    }

    @Override
    public UserListResult id_user_list(int uid) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"id_user_list","uid", String.valueOf(uid))), UserListResult.class);
    }

    @Override
    public UserResult get_user_detail(int uid) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"get_user_detail","uid", String.valueOf(uid))), UserResult.class);
    }
}
