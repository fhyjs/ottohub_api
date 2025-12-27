package org.eu.hanana.reimu.lib.ottohub.api.auth;

import org.eu.hanana.reimu.lib.ottohub.api.ApiBase;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;
import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IAuthApi;

public class AuthApi extends ApiBase implements IAuthApi {
    public AuthApi(OttohubApi ottohubApi) {
        super(ottohubApi);
    }

    @Override
    public LoginResult login(String uid_email, String password) {
        LoginResult loginResult = gson.fromJson(sendGet(getUrlWithArgs(ACTION, "login", "uid_email", uid_email, "pw", password)), LoginResult.class);
        if (loginResult.isSuccess())
            ottohubApi.setLoginResult(loginResult);
        return loginResult;
    }



    @Override
    public RegisterResult register(String email, String password, String register_verification_code) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"register","email",email,"pw",password,"confirm_pw",password,"register_verification_code",register_verification_code)), RegisterResult.class);

    }

    @Override
    public EmptyResult passwordreset(String email, String passwordreset_verification_code, String pw, String confirm_pw) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"passwordreset","email",email,"passwordreset_verification_code",passwordreset_verification_code,"pw",pw,"confirm_pw",confirm_pw)), EmptyResult.class);
    }

    @Override
    public EmptyResult register_verification_code(String email) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"register_verification_code","email",email)), EmptyResult.class);
    }

    @Override
    public EmptyResult passwordreset_verification_code(String email) {
        return gson.fromJson(sendGet(getUrlWithArgs(ACTION,"passwordreset_verification_code","email",email)), EmptyResult.class);
    }

    @Override
    public FirstLoginResult sign_in() {
        return null;
    }

    @Override
    public String getModule() {
        return "auth";
    }
}
