package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.danmaku.DanmakuListResult;

public interface IDanmakuApi {
    DanmakuListResult get_danmaku(int vid);
    @RequireToken
    EmptyResult send_danmaku(int vid,String text,double time,String mode,String color,String font_size,String render);
    @RequireToken
    EmptyResult delete_danmaku(long danmaku_id);
    @RequireToken
    EmptyResult report_danmaku(long danmaku_id);
    @RequireToken
    DanmakuListResult audit_danmaku_list(int offest,int num);
    @RequireToken
    EmptyResult approve_danmaku(long danmaku_id);
    @RequireToken
    EmptyResult reject_danmaku(long danmaku_id);
}
