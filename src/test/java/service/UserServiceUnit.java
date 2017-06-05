package service;
import base.BaseConfiguration;
import cn.sumi.dto.BlogInfo;
import cn.sumi.po.BlogConfigure;
import cn.sumi.po.User;
import cn.sumi.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User Service Test
 * Created by gonghf95 on 5/25/17.
 */
public class UserServiceUnit extends BaseConfiguration{
    @Autowired
    private UserService userService;

    @Before
    public void init(){

    }

    @Test
    public void login(){

    }

    @Test
    public void register(){
        BlogInfo blogInfo = new BlogInfo();
        User user = new User();
        user.setAccount("admin");
        user.setEmail("test@gmail.com");
        user.setNickname("admin");
        user.setPasswd("123");
        BlogConfigure blogConfigure = new BlogConfigure();
        blogConfigure.setAccount(user.getAccount());
        blogConfigure.setSignature("my simple blog");
        blogConfigure.setTitle("Admin");
        blogInfo.setUser(user);
        blogInfo.setBlogConfigure(blogConfigure);

        userService.register(blogInfo);
    }
}
