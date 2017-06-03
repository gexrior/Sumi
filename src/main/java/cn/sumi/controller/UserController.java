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
     * 文章管理
     *
     * @param model
     * @param account 当前用户
     * @author gonghf95
     */
    @RequestMapping("/postlist")
    public String manage(Model model, @PathVariable String account) {
        model.addAttribute("account", account);
        return "postlist";
    }

    /**
     * 类别管理
     *
     * @param model
     * @param account 当前用户
     * @author gonghf95
     */
    @RequestMapping("/category")
    public String category(Model model, @PathVariable String account) {
        model.addAttribute("account", account);
        return "category";
    }

    /**
     * 评论管理
     *
     * @param model
     * @param account 当前用户
     * @author gonghf95
     */
    @RequestMapping("/comment")
    public String comment(Model model, @PathVariable String account) {
        model.addAttribute("account", account);
        return "comment";
    }

    /**
     * 草稿箱管理
     *
     * @param model
     * @param account 当前用户
     * @author gonghf95
     */
    @RequestMapping("/draft")
    public String draft(Model model, @PathVariable String account) {
        model.addAttribute("account", account);
        return "draft";
    }

    /**
     * 编辑文章
     *
     * @param model
     * @param account 当前账户
     * @author gonghf95
     */
    @RequestMapping("/postedit")
    public String postedit(Model model, @PathVariable String account) {
        model.addAttribute("account",account);
        return "postedit";
    }

    /**
     * 回收站
     *
     * @param model
     * @param account 当前账户
     * @author gonghf95
     */
    @RequestMapping("/deleted")
    public String deleted(Model model, @PathVariable String account) {
        model.addAttribute("account",account);
        return "deleted";
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
