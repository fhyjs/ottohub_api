package org.eu.hanana.reimu.lib.ottohub.api.danmaku;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;

public class DanmakuResult extends ApiResultBase {
    public long danmaku_id;
    public String text,mode,color,font_size,render;
    public double time;
}
