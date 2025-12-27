package org.eu.hanana.reimu.lib.ottohub.media;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;

public class MediaResult extends ApiResultBase {
    public int media_id,uid,if_favorite,favorite_count,copyright_type;
    public long file_size;
    public  String extension,title,tag,intro,original_source,media_type,created_at,username,avatar_url,archive_directory;
}
