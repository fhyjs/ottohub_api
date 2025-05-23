package org.eu.hanana.reimu.lib.ottohub.api;

import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;
import org.eu.hanana.reimu.lib.ottohub.api.auth.AuthApi;
import org.eu.hanana.reimu.lib.ottohub.api.auth.LoginResult;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogApi;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IAuthApi;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IBlogApi;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IUserApi;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IVideoApi;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserApi;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoApi;

public class OttohubApi {
    @Setter
    @Getter
    protected LoginResult loginResult;
    public String apiHost="https://api.ottohub.cn/";
    @Setter
    @Getter
    protected OkHttpClient httpClient;
    @Getter
    protected IAuthApi authApi = new AuthApi(this);
    @Getter
    protected IVideoApi videoApi = new VideoApi(this);
    @Getter
    protected IBlogApi blogApi = new BlogApi(this);
    @Getter
    protected IUserApi userApi = new UserApi(this);
    public OttohubApi(){
        httpClient = new OkHttpClient.Builder().build();
    }
    public String getLoginToken(){
        if (loginResult==null) return null;
        return loginResult.token;
    }
}
