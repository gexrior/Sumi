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
     * @author gonghf95
     * */
    @RequestMapping("/administrator/{account}")
    public String root(Model model,@PathVariable String account) {
        model.addAttribute("user",userService.getAccountInfo(account));
        return "administrator";
    }

    /**
     * 文章编辑
     * @author gonghf95
     * */
    @RequestMapping("/postedit")
    public String postedit(Model model){
        model.addAttribute("post",1);
        return "postedit";
    }


    /**
     * 文章列表
     * @author gonghf95
     * */
    @RequestMapping("/postlist")
    public String postlist() {
        return null;
    }

    /**
     * 文章管理
     *
     * @param category 类别
     * @author gonghf95
     */
    @RequestMapping("/postlist/{category}")
    public String postlist(@RequestParam String category) {
        return null;
    }

    /**
     * 用户配置
     *
     * @author gonghf95
     */
    @RequestMapping("/configure")
    public String configure() {
        return null;
    }

}
