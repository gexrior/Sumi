package cn.sumi.service.impl;

import cn.sumi.mapper.UserMapper;
import cn.sumi.pojo.User;
import cn.sumi.service.UserService;
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


    public boolean login(User user) {
        return false;
    }

    public boolean register(User user) {
        return false;
    }
}
