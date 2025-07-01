package org.eu.hanana.reimu.lib.ottohub.api.creator;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.ICreatorApi;
import org.eu.hanana.reimu.lib.ottohub.util.InputStreamRequestBody;

import java.io.InputStream;
import java.util.Locale;
import java.util.Map;

public class CreatorApi extends ApiBase implements ICreatorApi {
    public CreatorApi(OttohubApi ottohubApi) {
        super(ottohubApi);
        this.apiUrl=String.format(Locale.getDefault(),"%smodule/%s/",ottohubApi.apiHost,getModule());
    }

    @Override
    public String getModule() {
        return  "creator";
    }

    @Override
    public SubmitBlogResult submit_blog(String title, String content) {
        var action = "submit_blog";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "content",  RequestBody.create(content,TYPE_TEXT_PLAIN)
        ))),SubmitBlogResult.class);
    }

    @Override
    public EmptyResult submit_video(String title, String intro, int category, String tag, InputStream file_mp4, InputStream file_jpg) {
        var action = "submit_video";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "title",  RequestBody.create(title,TYPE_TEXT_PLAIN),
                "intro",  RequestBody.create(intro,TYPE_TEXT_PLAIN),
                "category",  RequestBody.create(String.valueOf(category),TYPE_TEXT_PLAIN),
                "tag",  RequestBody.create(tag,TYPE_TEXT_PLAIN),
                "file_mp4",  new InputStreamRequestBody(file_mp4,TYPE_VIDEO_MP4),
                "file_jpg",  new InputStreamRequestBody(file_jpg,TYPE_IMAGE_JPEG)
        ))),EmptyResult.class);
    }

    @Override
    public EmptyResult update_avatar(InputStream file_jpg) {
        var action = "update_avatar";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "file_jpg",  new InputStreamRequestBody(file_jpg,TYPE_IMAGE_JPEG)
        ))),EmptyResult.class);
    }

    @Override
    public EmptyResult update_cover(InputStream file_jpg) {
        var action = "update_cover";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "file_jpg",  new InputStreamRequestBody(file_jpg,TYPE_IMAGE_JPEG)
        ))),EmptyResult.class);
    }

    @Override
    public EmptyResult save_blog(String content) {
        var action = "save_blog";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "content",  RequestBody.create(content,TYPE_TEXT_PLAIN)
        ))),EmptyResult.class);
    }

    @Override
    public LoadBlogResult load_blog() {
        var action = "load_blog";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN)
        ))),LoadBlogResult.class);
    }

    public String getApiUrl(String action){
        return this.apiUrl+action+".php";
    }
}

