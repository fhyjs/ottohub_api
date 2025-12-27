package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.annotations.OptionalToken;
import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.comment.CommentListResult;
import org.eu.hanana.reimu.lib.ottohub.api.comment.IfGetExpResult;
import org.eu.hanana.reimu.lib.ottohub.api.common.EmptyResult;

public interface ICommentApi {
    @OptionalToken
    CommentListResult blog_comment_list(int bid,int parent_bcid,int offset,int num);
    @OptionalToken
    CommentListResult video_comment_list(int vid,int parent_vcid,int offset,int num);
    @RequireToken
    IfGetExpResult comment_blog(int bid, int parent_bcid, String content);
    @RequireToken
    IfGetExpResult comment_video(int vid, int parent_vcid, String content);
    @RequireToken
    EmptyResult delete_blog_comment(int bcid);
    @RequireToken
    EmptyResult delete_video_comment(int vcid);
    @RequireToken
    EmptyResult report_blog_comment(int bcid);
    @RequireToken
    EmptyResult report_video_comment(int vcid);
    @RequireToken
    CommentListResult audit_blog_comment_list(int offset,int num);
    @RequireToken
    CommentListResult audit_video_comment_list(int offset,int num);
    @RequireToken
    EmptyResult approve_blog_comment(int bcid);
    @RequireToken
    EmptyResult approve_video_comment(int vcid);
    @RequireToken
    EmptyResult reject_blog_comment(int bcid);
    @RequireToken
    EmptyResult reject_video_comment(int vcid);
}
