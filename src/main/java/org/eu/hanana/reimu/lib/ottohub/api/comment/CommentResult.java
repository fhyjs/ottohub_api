package org.eu.hanana.reimu.lib.ottohub.api.comment;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;
import org.eu.hanana.reimu.lib.ottohub.api.user.UserResult;

public class CommentResult extends UserResult {
    public int bcid=-1,parent_bcid=-1,child_comment_num,if_my_comment,vcid=-1,parent_vcid=-1;
    public String content;
    public boolean isMyComment(){
        return if_my_comment==1;
    }

    public int getCid() {
        if (bcid==-1){
            return vcid;
        }
        return bcid;
    }

    public int getParentCid() {
        if (parent_bcid==-1){
            return parent_vcid;
        }
        return parent_bcid;
    }
}
