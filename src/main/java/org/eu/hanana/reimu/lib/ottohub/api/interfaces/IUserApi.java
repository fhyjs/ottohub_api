package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.api.user.UserListResult;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserResult;

public interface IUserApi {
    UserListResult search_user_list(String search_term,int num);
    UserListResult id_user_list(int uid);
    UserResult get_user_detail(int uid);
}
