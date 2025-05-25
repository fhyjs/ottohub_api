package org.eu.hanana.reimu.lib.ottohub.api.creator;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.ICreatorApi;

public class CreatorApi extends ApiBase implements ICreatorApi {
        public CreatorApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return  "creator";
    }

    @Override
    public SubmitBlogResult submit_blog(String title, String content) {
        return null;
    }

    @Override
    public EmptyResult submit_video(String title, String intro, int category, String tag, byte[] file_mp4, byte[] file_jpg) {
        return null;
    }
}

