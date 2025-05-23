package org.eu.hanana.reimu.lib.ottohub;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.auth.LoginResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoListResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoResult;

public class TestMain {
    private static final Logger log = LogManager.getLogger(TestMain.class);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        OttohubApi ottohubApi = new OttohubApi();
        LoginResult login = ottohubApi.getAuthApi().login(args[0], args[1]);
        log.info("Login success uid:{},token:{}",login.uid,login.token);
        log.info("Testing video api...");
        VideoListResult randomVideoList = ottohubApi.getVideoApi().random_video_list(20);
        for (VideoResult videoResult : randomVideoList.video_list) {
            log.info(" -vid:{},uid:{},title:{}",videoResult.vid,videoResult.uid,videoResult.title);
        }
    }
}