package cn.sumi.controller;

import cn.sumi.pojo.User;
import cn.sumi.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制层
 * 基本路径格式:/root/{account}/操作
 * Created by gonghf95 on 5/24/17.
 */
@Controller
@RequestMapping("/root/{account}")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 用户后台管理
     *
     * @param model
     * @param account 当前用户
     * @author gonghf95
     */
    @RequestMapping("/main")
    public String main(Model model, @PathVariable String account) {
        User user = userService.getAccountInfo(account);
        model.addAttribute("user", user);
        return "main";
    }

    /**
     * 新文章
     *
     * @param model
     * @param account 当前账户
     * @author gonghf95
     */
    @RequestMapping("/postedit")
    public String postedit(Model model, @PathVariable String account) {
        model.addAttribute("user", userService.getAccountInfo(account));
        return "postedit";
    }


    /**
     * 文章列表
     *
     * @author gonghf95
     */
    @RequestMapping("/postlist")
    public String postlist(@PathVariable String account) {
        return null;
    }

    /**
     * 用户配置
     *
     * @author gonghf95
     */
    @RequestMapping("/configure")
    public String configure(@PathVariable String account) {
        return null;
    }

}
