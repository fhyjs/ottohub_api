package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;

public interface IModerationApi {
    @RequireToken
    EmptyResult report_blog(int bid);
    @RequireToken
    EmptyResult approve_blog(int bid);
    @RequireToken
    EmptyResult reject_blog(int bid);
    @RequireToken
    EmptyResult report_video(int vid);
    @RequireToken
    EmptyResult approve_video(int vid);
    @RequireToken
    EmptyResult reject_video(int vid);
}
