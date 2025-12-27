package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.OptionalToken;
import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.media.FavoriteMediaListResult;
import org.eu.hanana.reimu.lib.ottohub.media.MediaListResult;
import org.eu.hanana.reimu.lib.ottohub.media.SearchMediaResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface IMediaApi {
    MediaListResult random_media_list(int num);
    MediaListResult new_media_list(int offset,int num);
    MediaListResult audit_media_list(int offset,int num);
    @RequireToken
    SearchMediaResult search_media_list(String search_term, int offset, int num, boolean media_id_desc, boolean media_id_asc, boolean file_size_desc, boolean file_size_asc, @Nullable Integer uid, @Nullable List<String> extension, @Nullable String tag , @Nullable String media_type, @Nullable Integer copyright_type, @Nullable Long min_file_size, @Nullable Long max_file_size);
    @OptionalToken
    MediaListResult get_media_detail(int media_id);
    @RequireToken
    EmptyResult delete_media(int media_id);
    @RequireToken
    EmptyResult appeal_media(int media_id);
    @RequireToken
    EmptyResult report_media(int media_id);
    @RequireToken
    EmptyResult approve_media(int media_id);
    @RequireToken
    EmptyResult reject_media(int media_id);
    FavoriteMediaListResult favorite_media(int uid, int offset, int num);
}
