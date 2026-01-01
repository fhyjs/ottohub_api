package org.eu.hanana.reimu.lib.ottohub.api.danmaku;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IDanmakuApi;

public class DanmakuApi extends ApiBase implements IDanmakuApi {
    public DanmakuApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "danmaku";
    }

    @Override
    public DanmakuListResult get_danmaku(int vid) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"get_danmaku","vid", String.valueOf(vid))), DanmakuListResult.class);
    }

    @Override
    public EmptyResult send_danmaku(int vid, String text, double time, String mode, String color, String font_size, String render) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"send_danmaku","vid", String.valueOf(vid),"text",text,"time",String.valueOf(time),"mode",mode,"color",color,"font_size",font_size,"render",render)), EmptyResult.class);
    }

    @Override
    public EmptyResult delete_danmaku(long danmaku_id) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"delete_danmaku","danmaku_id",danmaku_id)), EmptyResult.class);
    }

    @Override
    public EmptyResult report_danmaku(long danmaku_id) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"report_danmaku","danmaku_id",danmaku_id)), EmptyResult.class);
    }

    @Override
    public DanmakuListResult audit_danmaku_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"audit_danmaku_list","offset",offset,"num",num)), DanmakuListResult.class);
    }

    @Override
    public EmptyResult approve_danmaku(long danmaku_id) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"approve_danmaku","danmaku_id",danmaku_id)), EmptyResult.class);
    }

    @Override
    public EmptyResult reject_danmaku(long danmaku_id) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,getToken(),ACTION,"reject_danmaku","danmaku_id",danmaku_id)), EmptyResult.class);
    }
}
