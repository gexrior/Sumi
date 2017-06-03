package cn.sumi.service;

import cn.sumi.pojo.BlogConfigure;
import cn.sumi.pojo.User;
import cn.sumi.vo.BadgeVO;

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
