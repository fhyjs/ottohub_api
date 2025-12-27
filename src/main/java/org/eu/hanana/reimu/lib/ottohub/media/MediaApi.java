package org.eu.hanana.reimu.lib.ottohub.media;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IMediaApi;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MediaApi extends ApiBase implements IMediaApi {

    public MediaApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "media";
    }

    @Override
    public MediaListResult random_media_list(int num) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        ACTION, "random_media_list",
                        "num", String.valueOf(num)
                )),
                MediaListResult.class
        );
    }

    @Override
    public MediaListResult new_media_list(int offset, int num) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        ACTION, "new_media_list",
                        "offset", String.valueOf(offset),
                        "num", String.valueOf(num)
                )),
                MediaListResult.class
        );
    }

    @Override
    public MediaListResult audit_media_list(int offset, int num) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        TOKEN, getToken(),
                        ACTION, "audit_media_list",
                        "offset", String.valueOf(offset),
                        "num", String.valueOf(num)
                )),
                MediaListResult.class
        );
    }

    @Override
    public SearchMediaResult search_media_list(
            String search_term,
            int offset,
            int num,
            boolean media_id_desc,
            boolean media_id_asc,
            boolean file_size_desc,
            boolean file_size_asc,
            @Nullable Integer uid,
            @Nullable List<String> extension,
            @Nullable String tag,
            @Nullable String media_type,
            @Nullable Integer copyright_type,
            @Nullable Long min_file_size,
            @Nullable Long max_file_size
    ) {
        List<Object> args = new ArrayList<>();

        args.add(TOKEN);
        args.add(getToken());

        args.add(ACTION);
        args.add("search_media_list");

        args.add("search_term");
        args.add(search_term);

        args.add("offset");
        args.add(String.valueOf(offset));

        args.add("num");
        args.add(String.valueOf(num));

        args.add("media_id_desc");
        args.add(String.valueOf(media_id_desc?1:0));

        args.add("media_id_asc");
        args.add(String.valueOf(media_id_asc?1:0));

        args.add("file_size_desc");
        args.add(String.valueOf(file_size_desc?1:0));

        args.add("file_size_asc");
        args.add(String.valueOf(file_size_asc?1:0));

        if (uid != null) {
            args.add("uid");
            args.add(String.valueOf(uid));
        }

        if (extension != null && !extension.isEmpty()) {
            args.add("extension");
            args.add(String.join(",", extension));
        }

        if (tag != null) {
            args.add("tag");
            args.add(tag);
        }

        if (media_type != null) {
            args.add("media_type");
            args.add(media_type);
        }

        if (copyright_type != null) {
            args.add("copyright_type");
            args.add(String.valueOf(copyright_type));
        }

        if (min_file_size != null) {
            args.add("min_file_size");
            args.add(String.valueOf(min_file_size));
        }

        if (max_file_size != null) {
            args.add("max_file_size");
            args.add(String.valueOf(max_file_size));
        }

        return gson.fromJson(
                sendGet(getUrlWithArgs(args.toArray())),
                SearchMediaResult.class
        );
    }

    @Override
    public MediaListResult get_media_detail(int media_id) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        ACTION, "get_media_detail",
                        "media_id", String.valueOf(media_id)
                )),
                MediaListResult.class
        );
    }

    @Override
    public EmptyResult delete_media(int media_id) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        TOKEN, getToken(),
                        ACTION, "delete_media",
                        "media_id", String.valueOf(media_id)
                )),
                EmptyResult.class
        );
    }

    @Override
    public EmptyResult appeal_media(int media_id) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        TOKEN, getToken(),
                        ACTION, "appeal_media",
                        "media_id", String.valueOf(media_id)
                )),
                EmptyResult.class
        );
    }

    @Override
    public EmptyResult report_media(int media_id) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        TOKEN, getToken(),
                        ACTION, "report_media",
                        "media_id", String.valueOf(media_id)
                )),
                EmptyResult.class
        );
    }

    @Override
    public EmptyResult approve_media(int media_id) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        TOKEN, getToken(),
                        ACTION, "approve_media",
                        "media_id", String.valueOf(media_id)
                )),
                EmptyResult.class
        );
    }

    @Override
    public EmptyResult reject_media(int media_id) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        TOKEN, getToken(),
                        ACTION, "reject_media",
                        "media_id", String.valueOf(media_id)
                )),
                EmptyResult.class
        );
    }

    @Override
    public FavoriteMediaListResult favorite_media(int uid, int offset, int num) {
        return gson.fromJson(
                sendGet(getUrlWithArgs(
                        "uid", String.valueOf(uid),
                        ACTION, "favorite_media",
                        "offset", String.valueOf(offset),
                        "num", String.valueOf(num)
                )),
                FavoriteMediaListResult.class
        );
    }
}
