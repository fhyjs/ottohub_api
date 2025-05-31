package org.eu.hanana.reimu.lib.ottohub.api.profile;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserResult;

import java.util.List;

public class AvatarListResult extends ApiResultBase {
    public List<UserResult> avatar_list;
}
