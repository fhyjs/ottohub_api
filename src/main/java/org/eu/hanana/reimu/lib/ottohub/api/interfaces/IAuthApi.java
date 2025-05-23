package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.api.auth.LoginResult;
import org.eu.hanana.reimu.lib.ottohub.api.auth.RegisterResult;
import org.eu.hanana.reimu.lib.ottohub.api.auth.SendRegisterVerificationCodeResult;

public interface IAuthApi {
    LoginResult login(String uid_email,String password);
    SendRegisterVerificationCodeResult sendRegisterVerificationCode(String email);
    RegisterResult register(String email, String password, String register_verification_code);
}
