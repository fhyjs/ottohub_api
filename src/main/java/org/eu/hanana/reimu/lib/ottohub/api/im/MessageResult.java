package org.eu.hanana.reimu.lib.ottohub.api.im;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;

public class MessageResult extends ApiResultBase {
    public int msg_id,sender,receiver;
    public String content,time,sender_name,receiver_name,sender_avatar_url,receiver_avatar_url;
}
