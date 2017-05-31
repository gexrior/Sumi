package cn.sumi.controller;

import cn.sumi.pojo.User;
import cn.sumi.service.UserService;
import cn.sumi.utils.JSONCapsule;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * User Controller layer
 * Created by gonghf95 on 5/24/17.
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param request HttpServletRequest
     * @param user    表单和用户实体映射
     * @author gonghf95
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    String login(HttpServletRequest request, User user) {
        logger.info(user);
        JSONCapsule jsonCapsule;
        if (userService.login(user)) {
            jsonCapsule = new JSONCapsule(user.getAccount(), JSONCapsule.SUCCESS);
            return JSON.toJSONString(jsonCapsule);
        }
        jsonCapsule = new JSONCapsule("Incorrect username or password.", JSONCapsule.FAILURE);
        return JSON.toJSONString(jsonCapsule);
    }

    /**
     * 访问主页
     *
     * @author gonghf95
     */
    @RequestMapping("/home")
    public String home(Model model) {

        return "home";
    }

    /**
     * 用户后台管理
     *
     * @param model
     * @param account 当前用户
     * @author gonghf95
     */
    @RequestMapping("/root/{account}")
    public String root(Model model, @PathVariable String account) {
        model.addAttribute("user", userService.getAccountInfo(account));
        return "root";
    }

    /**
     * 新文章
     *
     * @param model
     * @param account 当前账户
     * @author gonghf95
     */
    @RequestMapping("/root/{account}/postedit")
    public String postedit(Model model, @PathVariable String account) {
        model.addAttribute("user", userService.getAccountInfo(account));
        return "postedit";
    }


    /**
     * 文章列表
     *
     * @author gonghf95
     */
    @RequestMapping("/{account}/postlist")
    public String postlist(@PathVariable String account) {
        return null;
    }

    /**
     * 用户配置
     *
     * @author gonghf95
     */
    @RequestMapping("/{account}/configure")
    public String configure(@PathVariable String account) {
        return null;
    }

}
