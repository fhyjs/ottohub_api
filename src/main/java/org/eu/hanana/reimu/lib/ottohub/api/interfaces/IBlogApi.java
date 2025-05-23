package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import lombok.Getter;
import org.eu.hanana.reimu.lib.ottohub.annotations.RequireToken;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogListResult;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogResult;


public interface IBlogApi {
    BlogListResult random_blog_list(int num);
    BlogListResult new_blog_list(int offset,int num);
    BlogListResult popular_blog_list(int time_limit,int offset,int num);
    BlogListResult search_blog_list(String search_term,int num);
    BlogListResult id_blog_list(int bid);
    BlogListResult user_blog_list(int uid,int offset,int num);
    @RequireToken
    BlogListResult audit_blog_list(int offset,int num);
    @RequireToken
    BlogResult get_blog_detail(int bid);
}
