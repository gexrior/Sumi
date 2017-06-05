package cn.sumi.service;

import cn.sumi.dto.BlogInfo;
import cn.sumi.po.BlogConfigure;
import cn.sumi.po.User;

/**
 * 用户业务层接口
 * Created by gonghf95 on 5/24/17.
 */
public interface UserService {
    User getAccountInfo(String account);

    BlogConfigure getBlogInfo();

    boolean login(User user);

    /**
     * 博客配置
     * 用户第一次进入系统会要求对博客进行基本配置，包括账户、密码、以及博客标题等内容
     */
    void register(BlogInfo blogInfo);
}
