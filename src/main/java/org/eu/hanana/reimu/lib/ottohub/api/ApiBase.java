package org.eu.hanana.reimu.lib.ottohub.api;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public abstract class ApiBase {
    public static final String ACTION = "action";
    public static final String TOKEN = "token";
    private static final Logger log = LogManager.getLogger(ApiBase.class);
    protected final OttohubApi ottohubApi;
    protected String apiUrl;
    protected Gson gson= new Gson();
    public ApiBase(OttohubApi ottohubApi) {
        this.ottohubApi=ottohubApi;
        this.apiUrl = ottohubApi.apiHost+"?module="+getModule();
    }
    @Nullable
    public String getToken(){
        return ottohubApi.getLoginToken();
    }
    public OkHttpClient getHttpClient() {
        return ottohubApi.getHttpClient();
    }
    @SneakyThrows
    public String sendGet(String url){
        var request = new Request.Builder()
                .url(url) // 目标 URL
                .get() // GET 请求
                .build();
        Response execute = null;
        try {
            execute = getHttpClient().newCall(request).execute();
            return execute.body().string();
        } catch (IOException e) {
            log.error(e);
            throw e;
        }
    }
    /**
     * @param kv k1,v1,k2,v2,k3,v3,...
     * @return full api url
     */
    public String getUrlWithArgs(String... kv){
        var sb = new StringBuilder(apiUrl);
        for (int i = 0; i < kv.length; i+=2) {
            if (kv[i]==null||kv[i+1]==null) continue;
            sb.append('&').append(kv[i]).append('=').append(kv[i+1]);
        }
        return sb.toString();
    }
    public abstract String getModule();
}
