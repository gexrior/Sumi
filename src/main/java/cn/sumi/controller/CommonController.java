package cn.sumi.controller;

import cn.sumi.pojo.Article;
import cn.sumi.pojo.User;
import cn.sumi.service.ArticleService;
import cn.sumi.service.UserService;
import cn.sumi.utils.JSONCapsule;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公共杂七杂八的东西
 * 其它的控制层都root操作
 * Created by gonghf95 on 6/1/17.
 */
@Controller
public class CommonController {

    Logger logger = Logger.getLogger(CommonController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    /**
     * 主页访问
     *
     * @author gonghf95
     */
    @RequestMapping("/home")
    public String home(Model model) {

        return "home";
    }

    /**
     * 用户登录
     *
     * @param user    表单和用户实体映射
     * @author gonghf95
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    String login(User user) {
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
     * 查看文章详情
     *
     * @param articleId 文章id
     * @author gonghf95
     */
    @RequestMapping("/article/details/{articleId}")
    public String articleDetails(@PathVariable int articleId, Model model) {
        Article article = articleService.find(articleId);
        if (article != null) {//文章没找到
            model.addAttribute("article", article);
            return "details";
        }
        JSONCapsule capsule = new JSONCapsule();
        capsule.setState(JSONCapsule.FAILURE);
        capsule.setMessage("查看文章详情失败。出错原因可能是该文章id不存在。");
        model.addAttribute("result", capsule);
        return "error";
    }
}
