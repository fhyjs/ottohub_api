package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.auth.FirstLoginResult;
import org.eu.hanana.reimu.lib.ottohub.api.auth.LoginResult;
import org.eu.hanana.reimu.lib.ottohub.api.auth.RegisterResult;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;

public interface IAuthApi {
    LoginResult login(String uid_email,String password);

    /**
     * Use <code>register_verification_code</code>
     * @param email email
     * @return empty
     */
    @Deprecated
    default EmptyResult sendRegisterVerificationCode(String email) {
        return register_verification_code(email);
    }

    RegisterResult register(String email, String password, String register_verification_code);
    EmptyResult passwordreset(String email,String passwordreset_verification_code,String pw,String confirm_pw);
    EmptyResult register_verification_code(String email);
    EmptyResult passwordreset_verification_code(String email);
    @RequireToken
    FirstLoginResult sign_in();
}
