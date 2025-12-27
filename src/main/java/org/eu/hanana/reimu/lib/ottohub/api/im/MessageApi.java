package org.eu.hanana.reimu.lib.ottohub.api.im;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogListResult;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IMessageApi;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserListResult;

public class MessageApi extends ApiBase implements IMessageApi {
    public MessageApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public String getModule() {
        return "im";
    }

    @Override
    public NewMessageNumResult new_message_num() {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"new_message_num")), NewMessageNumResult.class);
    }

    @Override
    public MessageListResult read_message_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"read_message_list","offset",String.valueOf(offset),"num", String.valueOf(num))).replace("read_message_list","message_list"), MessageListResult.class);
    }

    @Override
    public MessageListResult unread_message_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"unread_message_list","offset",String.valueOf(offset),"num", String.valueOf(num))).replace("unread_message_list","message_list"), MessageListResult.class);
    }

    @Override
    public MessageListResult sent_message_list(int offset, int num) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"sent_message_list","offset",String.valueOf(offset),"num", String.valueOf(num))).replace("sent_message_list","message_list"), MessageListResult.class);
    }

    @Override
    public EmptyResult send_message(int receiver, String message) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"send_message","receiver",String.valueOf(receiver),"message", message)), EmptyResult.class);
    }

    @Override
    public MessageResult read_message(int msg_id) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"read_message","msg_id",String.valueOf(msg_id))), MessageResult.class);
    }

    @Override
    public EmptyResult read_all_system_message() {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"read_all_system_message")), EmptyResult.class);
    }

    @Override
    public EmptyResult delete_message(int msg_id) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"delete_message","msg_id",String.valueOf(msg_id))), EmptyResult.class);
    }

    @Override
    public UserListResult friend_list(int offset, int num, boolean if_time_desc) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"friend_list","offset",String.valueOf(offset),"num",String.valueOf(num),"if_time_desc",String.valueOf(if_time_desc?1:0))), UserListResult.class);
    }

    @Override
    public MessageListResult friend_message(int friend_uid, int offset, int num, boolean if_time_desc) {
        return gson.fromJson(sendGet(getUrlWithArgs(TOKEN,ottohubApi.getLoginToken(),ACTION,"friend_message","friend_uid",String.valueOf(friend_uid),"offset",String.valueOf(offset),"num",String.valueOf(num),"if_time_desc",String.valueOf(if_time_desc?1:0))), MessageListResult.class);

    }
}
