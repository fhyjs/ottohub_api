package org.eu.hanana.reimu.lib.ottohub.api.profile;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogListResult;
import org.eu.hanana.reimu.lib.ottohub.api.blog.BlogResult;

import java.util.List;

public class FavoriteBlogListResult extends BlogListResult {
    public int favorite_blog_count;
}
