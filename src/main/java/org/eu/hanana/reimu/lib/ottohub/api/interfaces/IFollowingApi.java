package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.following.FollowStatusResult;
import org.eu.hanana.reimu.lib.ottohub.api.following.TimelineListResult;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserListResult;

public interface IFollowingApi {
    @RequireToken
    FollowStatusResult follow(int following_uid);
    @RequireToken
    FollowStatusResult follow_status(int following_uid);
    UserListResult following_list(int uid,int offset,int num);
    UserListResult fan_list(int uid, int offset,int num);
    @RequireToken
    TimelineListResult following_all_timeline( int offset,int num);
    @RequireToken
    UserListResult following_active_list(int uid, int offset,int num);
}
