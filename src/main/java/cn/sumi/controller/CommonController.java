package cn.sumi.controller;

import cn.sumi.po.Article;
import cn.sumi.po.BlogConfigure;
import cn.sumi.po.User;
import cn.sumi.service.ArticleService;
import cn.sumi.service.UserService;
import cn.sumi.dto.JsonResult;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

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
        List<Article> articleList = articleService.findAll();
        BlogConfigure blogConfigure = userService.getBlogInfo();
        Collections.reverse(articleList);
        model.addAttribute("articleList", articleList);
        model.addAttribute("blogconfigure", blogConfigure);
        return "home";
    }

    /**
     * 用户登录
     *
     * @param httpServletRequest request
     * @param user               表单和用户实体映射
     * @author gonghf95
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    String login(HttpServletRequest httpServletRequest, User user) {
        logger.info(user);
        JsonResult JsonResult = null;
        if (userService.login(user)) {
            JsonResult = new JsonResult(user.getAccount(), JsonResult.SUCCESS);
            //如果登录成功的话，可以再查该用户了
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("usr", user);
            session.setMaxInactiveInterval(1800);
            return JSON.toJSONString(JsonResult);
        }
        JsonResult = new JsonResult("Incorrect username or password.", JsonResult.FAILURE);
        return JSON.toJSONString(JsonResult);
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
        if (article != null) {//文章找到
            model.addAttribute("article", article);
            return "details";
        }
        JsonResult capsule = new JsonResult();
        capsule.setState(JsonResult.FAILURE);
        capsule.setMessage("查看文章详情失败。出错原因可能是该文章id不存在。");
        model.addAttribute("result", capsule);
        return "error";
    }
}
