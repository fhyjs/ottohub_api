package org.eu.hanana.reimu.lib.ottohub.api.system;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogListResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.ISystemApi;

public class SystemApi extends ApiBase implements ISystemApi {
    public SystemApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "system";
    }

    @Override
    public VersionResult version() {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"version")), VersionResult.class);
    }

    @Override
    public SlideshowResult slideshow() {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"slideshow")), SlideshowResult.class);
    }

    @Override
    public LaunchScreenUrlResult launch_screen() {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"launch_screen")), LaunchScreenUrlResult.class);
    }
}
