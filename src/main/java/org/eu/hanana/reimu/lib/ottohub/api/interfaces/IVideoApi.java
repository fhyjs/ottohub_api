package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.common.DataWrapResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoListResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoPresignedResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoResult;

import java.util.List;

public interface IVideoApi {
    VideoListResult random_video_list(int num);
    DataWrapResult<VideoListResult> random_video_list_new(int num);
    VideoListResult new_video_list(int offset,int num);
    VideoListResult popular_video_list(int time_limit,int offset,int num);
    VideoListResult category_video_list(int category,int num);
    VideoListResult search_video_list(String search_term,int num);
    VideoListResult id_video_list(int vid);
    VideoListResult user_video_list(int uid,int offset,int num);
    VideoListResult audit_video_list(int offset,int num);
    VideoListResult related_video_list(int vid,int offset,int num);
    @RequireToken
    DataWrapResult<VideoPresignedResult> video_presigned(String extension);
    VideoResult get_video_detail(int vid);
    DataWrapResult<VideoResult> get_video_detail_new(int vid);
}
