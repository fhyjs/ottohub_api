package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.creator.SubmitBlogResult;

public interface ICreatorApi {
    SubmitBlogResult submit_blog(String title,String content);
    EmptyResult submit_video(String title,String intro,int category,String tag,byte[] file_mp4,byte[] file_jpg);
}
