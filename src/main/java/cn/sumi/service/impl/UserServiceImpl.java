package cn.sumi.service.impl;

import cn.sumi.mapper.UserMapper;
import cn.sumi.pojo.User;
import cn.sumi.service.UserService;
import cn.sumi.utils.Constants;
import cn.sumi.utils.MD5Util;
import cn.sumi.utils.Model;
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

    public Model login(User user) {
        Model model = new Model();
        User res = userMapper.find(user.getAccount());
        if (res == null) {
            model.setState(Constants.ACCOUNT_NOT_EXIST);
            model.setMessage("Account does not exist or password error, please reenter");
        } else if (MD5Util.toMD5(user.getPassword()).equals(res.getPassword())) {
            model.setState(Constants.SUCCESS);
        } else {
            model.setState(Constants.FAILURE);
            model.setMessage("Incorrect username or password");
        }
        return model;
    }

    public Model register(User user) {
        Model model = new Model();
        User res = userMapper.find(user.getAccount());
        if (res == null) {
            userMapper.save(user);
        }else {
            model.setState(Constants.FAILURE);
            model.setMessage("This account already exist");
        }
        return model;
    }
}
