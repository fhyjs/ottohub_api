package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.im.MessageListResult;
import org.eu.hanana.reimu.lib.ottohub.api.im.MessageResult;
import org.eu.hanana.reimu.lib.ottohub.api.im.NewMessageNumResult;

public interface IMessageApi {
    @RequireToken
    NewMessageNumResult new_message_num();
    @RequireToken
    MessageListResult read_message_list(int offset,int num);
    @RequireToken
    MessageListResult unread_message_list(int offset,int num);
    @RequireToken
    MessageListResult sent_message_list(int offset,int num);
    @RequireToken
    EmptyResult send_message(int receiver,String message);
    @RequireToken
    MessageResult read_message(int msg_id);
    @RequireToken
    EmptyResult read_all_system_message();
}
