package cn.sumi.service;

import cn.sumi.po.BlogConfigure;
import cn.sumi.po.User;

/**
 *
 * Created by gonghf95 on 5/24/17.
 */
public interface UserService {
    User getAccountInfo(String account);
    BlogConfigure getAccountConfigure(String account);
    boolean login(User user);
    boolean register(User user);
}
