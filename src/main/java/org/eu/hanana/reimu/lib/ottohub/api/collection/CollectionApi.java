package org.eu.hanana.reimu.lib.ottohub.api.collection;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.ICollectionApi;

public class CollectionApi extends ApiBase implements ICollectionApi {
    public CollectionApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "collection";
    }

    @Override
    public EmptyResult set_video_collection(int vid, String collection) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"set_video_collection","vid",vid,"collection",collection)), EmptyResult.class);
    }

    @Override
    public CollectionResult get_video_collection(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"get_video_collection","vid",vid)), CollectionResult.class);
    }

    @Override
    public CollectionListResult get_user_video_collection(int uid) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"get_user_video_collection","uid",uid)), CollectionListResult.class);
    }

    @Override
    public CollectionResult video_collection_list(int uid, String collection) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"video_collection_list","uid",uid,"collection",collection)), CollectionResult.class);
    }
}
