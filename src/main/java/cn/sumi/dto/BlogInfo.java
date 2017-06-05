package cn.sumi.dto;

import cn.sumi.po.BlogConfigure;
import cn.sumi.po.User;

/**
 * 博客配置
 * 包括用户基本资料、博客的信息
 * Created by gonghf95 on 6/5/17.
 */
public class BlogInfo {
    private User user;
    private BlogConfigure blogConfigure;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BlogConfigure getBlogConfigure() {
        return blogConfigure;
    }

    public void setBlogConfigure(BlogConfigure blogConfigure) {
        this.blogConfigure = blogConfigure;
    }
}
