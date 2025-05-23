package org.eu.hanana.reimu.lib.ottohub.api.auth;

import lombok.AllArgsConstructor;
import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IStatusGetter;

@AllArgsConstructor
public class LoginResult extends ApiResultBase {
    public String uid;
    public String token;
    public String avatar_url;
    public String cover_url;
    public String if_today_first_login;


    public boolean is_today_first_login() {
        return !"no".equals(if_today_first_login);
    }
}
