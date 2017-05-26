package cn.sumi.service;

import cn.sumi.pojo.User;
import cn.sumi.utils.Model;

/**
 *
 * Created by gonghf95 on 5/24/17.
 */
public interface UserService {
    Model login(User user);
    Model register(User user);
}
