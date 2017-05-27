package service;
import base.BaseConfiguration;
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
}
