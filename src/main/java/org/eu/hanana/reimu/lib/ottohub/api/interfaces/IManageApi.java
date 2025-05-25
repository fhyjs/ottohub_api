package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;

public interface IManageApi {
    @RequireToken
    EmptyResult delete_blog(int bid);
    @RequireToken
    EmptyResult appeal_blog(int bid);
    @RequireToken
    EmptyResult delete_video(int vid);
    @RequireToken
    EmptyResult appeal_video(int vid);
}
