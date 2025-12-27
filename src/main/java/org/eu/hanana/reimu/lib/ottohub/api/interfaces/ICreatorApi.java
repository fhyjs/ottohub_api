package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.creator.ImageUrlResult;
import org.eu.hanana.reimu.lib.ottohub.api.creator.LoadBlogResult;
import org.eu.hanana.reimu.lib.ottohub.api.creator.SubmitBlogResult;
import org.eu.hanana.reimu.lib.ottohub.api.creator.SubmitMediaResult;
import org.eu.hanana.reimu.lib.ottohub.util.ProgressedRequestBody;

import java.io.InputStream;

public interface ICreatorApi {
    @RequireToken
    SubmitBlogResult submit_blog(String title,String content);
    @RequireToken
    EmptyResult submit_video(String title, String intro, int category,int type, String tag, InputStream file_mp4, InputStream file_jpg);
    @RequireToken
    EmptyResult update_avatar(InputStream file_jpg);
    @RequireToken
    EmptyResult update_cover(InputStream file_jpg);
    @RequireToken
    EmptyResult save_blog(String content);
    @RequireToken
    LoadBlogResult load_blog();
    //has listener
    @RequireToken
    SubmitBlogResult submit_blog(String title, String content, ProgressedRequestBody.ProgressListener progressListener);
    @RequireToken
    EmptyResult submit_video(String title, String intro, int category,int type, String tag, InputStream file_mp4, InputStream file_jpg, ProgressedRequestBody.ProgressListener progressListener);
    @RequireToken
    EmptyResult update_avatar(InputStream file_jpg, ProgressedRequestBody.ProgressListener progressListener);
    @RequireToken
    EmptyResult update_cover(InputStream file_jpg, ProgressedRequestBody.ProgressListener progressListener);
    @RequireToken
    EmptyResult save_blog(String content, ProgressedRequestBody.ProgressListener progressListener);
    //Maybe media module?
    @RequireToken
    ImageUrlResult submit_image(InputStream file_img, ProgressedRequestBody.ProgressListener progressListener);
    @RequireToken
    SubmitMediaResult submit_media(String title, String intro, String tag, String original_source, String media_type, String copyright_type, InputStream file_media, ProgressedRequestBody.ProgressListener progressListener);
    @RequireToken
    EmptyResult update_video(int vid,String title,String intro,String tag,InputStream file_mp4, InputStream file_jpg, ProgressedRequestBody.ProgressListener progressListener);
}
