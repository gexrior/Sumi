package cn.sumi.service;

import cn.sumi.pojo.User;

/**
 *
 * Created by gonghf95 on 5/24/17.
 */
public interface UserService {
    User getAccountInfo(String account);
    boolean login(User user);
    boolean register(User user);
}
