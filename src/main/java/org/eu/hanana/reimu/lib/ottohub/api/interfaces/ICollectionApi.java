package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.collection.CollectionListResult;
import org.eu.hanana.reimu.lib.ottohub.api.collection.CollectionResult;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;

public interface ICollectionApi {
    @RequireToken
    EmptyResult set_video_collection(int vid, String collection);
    CollectionResult get_video_collection(int vid);
    CollectionListResult get_user_video_collection(int uid);
    CollectionResult video_collection_list(int uid,String collection);
}
