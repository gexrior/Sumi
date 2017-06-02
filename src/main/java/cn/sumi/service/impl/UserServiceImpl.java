package cn.sumi.service.impl;

import cn.sumi.mapper.BlogConfigureMapper;
import cn.sumi.mapper.UserMapper;
import cn.sumi.pojo.BlogConfigure;
import cn.sumi.pojo.User;
import cn.sumi.service.UserService;
import javafx.scene.effect.Blend;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * User Business
 * Created by gonghf95 on 5/24/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BlogConfigureMapper blogConfigure;


    public User getAccountInfo(String account) {
        return userMapper.selectByPrimaryKey(account);
    }

    public BlogConfigure getAccountConfigure(String account) {
        return blogConfigure.selectByPrimaryKey(account);
    }

    public boolean login(User user) {
        //查找该账户，不存在该账户返回空
        User res = userMapper.selectByPrimaryKey(user.getAccount());
        if (res != null && res.getPasswd().equals(user.getPasswd())) {
            return true;
        }
        return false;
    }

    public boolean register(User user) {
        return false;
    }

}
