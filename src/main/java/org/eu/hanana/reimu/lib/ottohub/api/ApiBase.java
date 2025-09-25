package org.eu.hanana.reimu.lib.ottohub.api;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import okhttp3.*;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IHasName;
import org.eu.hanana.reimu.lib.ottohub.util.ProgressedRequestBody;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Map;

public abstract class ApiBase {
    public static final MediaType TYPE_TEXT_PLAIN = MediaType.get("text/plain");
    public static final MediaType TYPE_VIDEO_MP4 = MediaType.get("video/mp4");
    public static final MediaType TYPE_IMAGE_JPEG = MediaType.get("image/jpeg");
    public static final String ACTION = "action";
    public static final String TOKEN = "token";
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
            e.printStackTrace();
            throw e;
        }
    }
    @SneakyThrows
    public String sendPost(String url, RequestBody requestBody){
        var request = new Request.Builder()
                .url(url) // 目标 URL
                .post(requestBody) // GET 请求
                .build();
        Response execute = null;
        try {
            execute = getHttpClient().newCall(request).execute();
            return execute.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    public ProgressedRequestBody newRequestBody(Map<String,RequestBody> data){
        return this.newRequestBody(null,data);
    }
    public ProgressedRequestBody newRequestBody(@Nullable ProgressedRequestBody.ProgressListener listener,Map<String,RequestBody> data){
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        data.forEach((s, requestBody) -> {
            String fn = null;
            if (requestBody instanceof IHasName){
                fn=((IHasName) requestBody).getName();
            }
            multipartBuilder.addFormDataPart(s,fn,requestBody);
        });
        if (listener==null){
            listener= (written, length, progress) -> {};
        }
        return new ProgressedRequestBody(multipartBuilder.build(),listener);
    }
    /**
     * @param kv k1,v1,k2,v2,k3,v3,...
     * @return full api url
     */
    public String getUrlWithArgs(Object... kv){
        var sb = new StringBuilder(apiUrl);
        for (int i = 0; i < kv.length; i+=2) {
            if (kv[i]==null||kv[i+1]==null) continue;
            sb.append('&').append(kv[i].toString()).append('=').append(kv[i+1].toString());
        }
        return sb.toString();
    }
    public abstract String getModule();
}
