package cn.sumi.controller;

import cn.sumi.pojo.User;
import cn.sumi.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User Controller layer
 * Created by 龚洪富 on 5/24/17.
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param user 表单和用户实体映射
     * @author 龚洪富
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model) {
        logger.info(user.toString());
        return "main";
    }

    /**
     * 文章管理
     *
     * @param category 类别
     * @author 龚洪富
     */
    @RequestMapping("/postlist/{category}")
    public String postlist(@RequestParam String category) {
        return null;
    }

    /**
     * 用户配置
     *
     * @author 龚洪富
     */
    @RequestMapping("configure")
    public String configure() {
        return null;
    }
}
