package controller;

import base.BaseConfiguration;
import cn.sumi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserControllerUnit extends BaseConfiguration{
    @Autowired
    private UserService userService;

    @Test
    public void login(){

    }
}
