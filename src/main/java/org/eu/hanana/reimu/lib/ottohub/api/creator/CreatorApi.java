package org.eu.hanana.reimu.lib.ottohub.api.creator;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.ICreatorApi;
import org.eu.hanana.reimu.lib.ottohub.util.InputStreamRequestBody;
import org.eu.hanana.reimu.lib.ottohub.util.ProgressedRequestBody;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
    public SubmitBlogResult submit_blog(String title, String content, ProgressedRequestBody.ProgressListener progressListener) {
        var action = "submit_blog";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(progressListener,Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "content",  RequestBody.create(content,TYPE_TEXT_PLAIN),
                "title",  RequestBody.create(title,TYPE_TEXT_PLAIN)
        ))),SubmitBlogResult.class);
    }

    @Override
    public EmptyResult submit_video(String title, String intro, int category,int type, String tag, InputStream file_mp4, InputStream file_jpg, ProgressedRequestBody.ProgressListener progressListener) {
        var action = "submit_video";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(progressListener,Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "title",  RequestBody.create(title,TYPE_TEXT_PLAIN),
                "intro",  RequestBody.create(intro,TYPE_TEXT_PLAIN),
                "category",  RequestBody.create(String.valueOf(category),TYPE_TEXT_PLAIN),
                "type",  RequestBody.create(String.valueOf(type),TYPE_TEXT_PLAIN),
                "tag",  RequestBody.create(tag,TYPE_TEXT_PLAIN),
                "file_mp4",  new InputStreamRequestBody(file_mp4,TYPE_VIDEO_MP4).setName("video.mp4"),
                "file_jpg",  new InputStreamRequestBody(file_jpg,TYPE_IMAGE_JPEG).setName("cover.jpg")
        ))),EmptyResult.class);
    }

    @Override
    public EmptyResult update_avatar(InputStream file_jpg, ProgressedRequestBody.ProgressListener progressListener) {
        var action = "update_avatar";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(progressListener,Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "file_jpg",  new InputStreamRequestBody(file_jpg,TYPE_IMAGE_JPEG).setName("file.jpg")
        ))),EmptyResult.class);
    }

    @Override
    public EmptyResult update_cover(InputStream file_jpg, ProgressedRequestBody.ProgressListener progressListener) {
        var action = "update_cover";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(progressListener,Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "file_jpg",  new InputStreamRequestBody(file_jpg,TYPE_IMAGE_JPEG).setName("file.jpg")
        ))),EmptyResult.class);
    }

    @Override
    public EmptyResult save_blog(String content, ProgressedRequestBody.ProgressListener progressListener) {
        var action = "save_blog";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(progressListener,Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "content",  RequestBody.create(content,TYPE_TEXT_PLAIN)
        ))),EmptyResult.class);
    }

    @Override
    public ImageUrlResult submit_image(InputStream file_img, ProgressedRequestBody.ProgressListener progressListener) {
        var action = "submit_image";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(progressListener,Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "file_img",  new InputStreamRequestBody(file_img,TYPE_IMAGE_JPEG).setName("file.jpg")
        ))),ImageUrlResult.class);
    }

    @Override
    public SubmitMediaResult submit_media(String title, String intro, String tag, String original_source, String media_type, String copyright_type, InputStream file_media, ProgressedRequestBody.ProgressListener progressListener) {
        var action = "submit_media";
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(progressListener,Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN),
                "title",  RequestBody.create(title,TYPE_TEXT_PLAIN),
                "intro",  RequestBody.create(intro,TYPE_TEXT_PLAIN),
                "tag",  RequestBody.create(tag,TYPE_TEXT_PLAIN),
                "original_source",  RequestBody.create(original_source,TYPE_TEXT_PLAIN),
                "media_type",  RequestBody.create(media_type,TYPE_TEXT_PLAIN),
                "copyright_type",  RequestBody.create(copyright_type,TYPE_TEXT_PLAIN),
                "file_media",  new InputStreamRequestBody(file_media,TYPE_IMAGE_JPEG).setName("file.jpg")
        ))),SubmitMediaResult.class);
    }

    @Override
    public EmptyResult update_video(int vid, String title, String intro, String tag, InputStream file_mp4, InputStream file_jpg, ProgressedRequestBody.ProgressListener progressListener) {
        var action = "update_video";
        var map = new HashMap<>(Map.of(
                ACTION, RequestBody.create(action,TYPE_TEXT_PLAIN),
                TOKEN,  RequestBody.create(getToken(),TYPE_TEXT_PLAIN)

        ));
        if (file_jpg!=null){
            map.put("file_jpg", new InputStreamRequestBody(file_jpg,TYPE_IMAGE_JPEG).setName("file.jpg"));
        }
        if (file_mp4!=null){
            map.put("file_mp4", new InputStreamRequestBody(file_jpg,TYPE_VIDEO_MP4).setName("file.mp4"));
        }
        if (tag!=null){
            map.put("tag",  RequestBody.create(tag,TYPE_TEXT_PLAIN));
        }
        if (intro!=null){
            map.put("intro",  RequestBody.create(intro,TYPE_TEXT_PLAIN));
        }
        if (title!=null){
            map.put("title",  RequestBody.create(title,TYPE_TEXT_PLAIN));
        }
        return gson.fromJson(sendPost(getApiUrl(action),newRequestBody(progressListener,map)),EmptyResult.class);
    }

    @Override
    public SubmitBlogResult submit_blog(String title, String content) {
        return this.submit_blog(title,content,null);
    }

    @Override
    public EmptyResult submit_video(String title, String intro, int category,int type, String tag, InputStream file_mp4, InputStream file_jpg) {
        return this.submit_video(title,intro,category,type,tag,file_mp4,file_jpg,null);
    }

    @Override
    public EmptyResult update_avatar(InputStream file_jpg) {
        return update_avatar(file_jpg,null);
    }

    @Override
    public EmptyResult update_cover(InputStream file_jpg) {
        return update_cover(file_jpg,null);
    }

    @Override
    public EmptyResult save_blog(String content) {
        return save_blog(content,null);
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

