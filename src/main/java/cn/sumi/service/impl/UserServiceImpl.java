package cn.sumi.service.impl;

import cn.sumi.dto.BlogInfo;
import cn.sumi.mapper.BlogConfigureMapper;
import cn.sumi.mapper.UserMapper;
import cn.sumi.po.BlogConfigure;
import cn.sumi.po.User;
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
    @Autowired
    private BlogConfigureMapper blogConfigureMapper;


    public User getAccountInfo(String account) {
        return userMapper.selectByPrimaryKey(account);
    }

    public BlogConfigure getBlogInfo() {
        return blogConfigureMapper.find();
    }

    public boolean login(User user) {
        //查找该账户，不存在该账户返回null
        User res = userMapper.selectByPrimaryKey(user.getAccount());
        if (res != null && res.getPasswd().equals(user.getPasswd())) {
            return true;
        }
        return false;
    }

    public void register(BlogInfo blogInfo) {
        User user = blogInfo.getUser();
        User res = userMapper.selectByPrimaryKey(user.getAccount());
        if (res == null) {
            BlogConfigure configure = blogInfo.getBlogConfigure();
            configure.setAccount(user.getAccount());
            configure.setTitle(configure.getTitle().equals(null)?user.getNickname():configure.getTitle());
            configure.setSignature(configure.getSignature().equals(null)?"":configure.getSignature());
            userMapper.insert(user);
            blogConfigureMapper.insert(configure);
        }
    }

}
