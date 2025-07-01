package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.creator.LoadBlogResult;
import org.eu.hanana.reimu.lib.ottohub.api.creator.SubmitBlogResult;

import java.io.InputStream;

public interface ICreatorApi {
    @RequireToken
    SubmitBlogResult submit_blog(String title,String content);
    @RequireToken
    EmptyResult submit_video(String title, String intro, int category, String tag, InputStream file_mp4, InputStream file_jpg);
    @RequireToken
    EmptyResult update_avatar(InputStream file_jpg);
    @RequireToken
    EmptyResult update_cover(InputStream file_jpg);
    @RequireToken
    EmptyResult save_blog(String content);
    @RequireToken
    LoadBlogResult load_blog();
}
