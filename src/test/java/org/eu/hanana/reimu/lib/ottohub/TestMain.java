package org.eu.hanana.reimu.lib.ottohub;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eu.hanana.reimu.lib.ottohub.api.OttohubApi;
import org.eu.hanana.reimu.lib.ottohub.api.auth.LoginResult;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogListResult;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogResult;
import org.eu.hanana.reimu.lib.ottohub.api.im.MessageListResult;
import org.eu.hanana.reimu.lib.ottohub.api.im.MessageResult;
import org.eu.hanana.reimu.lib.ottohub.api.system.VersionResult;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserListResult;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoListResult;
import org.eu.hanana.reimu.lib.ottohub.api.video.VideoResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;

public class TestMain {
    private static final Logger log = LogManager.getLogger(TestMain.class);

    @Test
    public void main() {
        String username = System.getenv("OTTOHUB_USERNAME");
        String password = System.getenv("OTTOHUB_PASSWORD");

        if (username == null || password == null) {
            System.err.println("未设置 OTTOHUB_USERNAME 或 OTTOHUB_PASSWORD 环境变量");
            return;
        }

        System.out.println("用户名：" + username);
        System.out.println("密码长度：" + password.length()); // 不打印密码内容


        System.out.println("Hello world!");
        OttohubApi ottohubApi = new OttohubApi();
        LoginResult login = ottohubApi.getAuthApi().login(username,password);
        log.info("Login success uid:{},token:{}",login.uid,login.token);
        log.info("Testing video api...");
        VideoListResult randomVideoList = ottohubApi.getVideoApi().random_video_list(20);
        for (VideoResult videoResult : randomVideoList.video_list) {
            log.info(" -vid:{},uid:{},title:{}",videoResult.vid,videoResult.uid,videoResult.title);
        }
        log.info("First Vid info...");
        VideoResult videoDetail = ottohubApi.getVideoApi().get_video_detail(randomVideoList.video_list.get(1).vid);
        log.info(new Gson().toJson(videoDetail));

        log.info("Testing blog api...");
        BlogListResult random_blog_list = ottohubApi.getBlogApi().random_blog_list(20);
        for (BlogResult blogResult : random_blog_list.blog_list) {
            log.info(" -bid:{},uid:{},title:{}",blogResult.bid,blogResult.uid,blogResult.title);
        }
        log.info("First blog info...");
        BlogResult blogResult = ottohubApi.getBlogApi().get_blog_detail(random_blog_list.blog_list.get(1).bid);
        log.info(new Gson().toJson(blogResult));
        log.info("Testing user api...");
        UserResult userResult = ottohubApi.getUserApi().get_user_detail(4384);
        log.info(new Gson().toJson(userResult));
        log.info("Testing system api...");
        VersionResult version = ottohubApi.getSystemApi().version();
        log.info("Api Ver: {}",version.version);
        log.info("Testing following api...");
        log.info("fans of UID 4384:");
        UserListResult fans = ottohubApi.getFollowingApi().fan_list(4384,0,10);
        for (UserResult userResult1 : fans.user_list) {
            log.info(" -uid:{},name:{},intro:{}",userResult1.uid,userResult1.username,userResult1.intro);
        }
        log.info("Testing message api...");
        log.info("send... to uid 4384");
        ottohubApi.getMessageApi().send_message(4384,version.version+":Api Test.");
        MessageListResult messageListResult = ottohubApi.getMessageApi().read_message_list(0, 10);
        for (MessageResult messageResult : messageListResult.message_list) {
            log.info(" -message_ID:{},sender_name:{},content:{}",messageResult.msg_id,messageResult.sender_name,messageResult.content);
        }
        var testVid = randomVideoList.video_list.get(1);
        var testBlog = random_blog_list.blog_list.get(1);
        log.info(" -Like vid:{},count:{}",testVid.vid,ottohubApi.getEngagementApi().like_video(testVid.vid).like_count);
        log.info(" -Favorite vid:{},count:{}",testVid.vid,ottohubApi.getEngagementApi().favorite_video(testVid.vid).favorite_count);
        log.info(" -Like bid:{},count:{}",testVid.vid,ottohubApi.getEngagementApi().like_blog(testBlog.bid).like_count);
        log.info(" -Favorite bid:{},count:{}",testVid.vid,ottohubApi.getEngagementApi().favorite_blog(testBlog.bid).favorite_count);
        log.info("test report in  blog 4543");
        ottohubApi.getModerationApi().report_blog(4543);
        ottohubApi.getModerationApi().reject_blog(4543);
        ottohubApi.getManageApi().appeal_blog(4543);
        ottohubApi.getModerationApi().approve_blog(4543);

        log.info("Testing creator api...");
        ottohubApi.getCreatorApi().save_blog(new Date().toString());
        String time = ottohubApi.getCreatorApi().load_blog().content;
        log.info(" -Loaded blog : {}",time);
    }
}