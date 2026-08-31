package org.eu.hanana.reimu.lib.ottohub.api.video;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;

public class VideoPresignedResult extends ApiResultBase {
    public String url;
    public String file_name;
    public String path;
    public int video_index;
    public int max_file_size;
}
