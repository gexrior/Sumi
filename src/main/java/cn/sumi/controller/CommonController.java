package cn.sumi.controller;

import cn.sumi.po.Article;
import cn.sumi.po.BlogConfigure;
import cn.sumi.po.User;
import cn.sumi.service.PostService;
import cn.sumi.service.UserService;
import cn.sumi.dto.JSONInfo;
import cn.sumi.utils.Constants;
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

    private Logger logger = Logger.getLogger(CommonController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    /**
     * 主页访问
     *
     * @author gonghf95
     */
    @RequestMapping("/home")
    public String home(Model model) {
        List<Article> articleList = postService.getArticleListByType(Constants.ARTICLE_TYPE_NORMAL);
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
        JSONInfo JSONInfo;
        if (userService.login(user)) {
            JSONInfo = new JSONInfo(user.getAccount(), Constants.STATUS_SUCCESS);
            //如果登录成功的话
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("usr", user);
            session.setMaxInactiveInterval(1800);
            return JSON.toJSONString(JSONInfo);
        }
        JSONInfo = new JSONInfo("Incorrect username or password.",Constants.STATUS_FAILURE);
        return JSON.toJSONString(JSONInfo);
    }

    /**
     * 查看文章详情
     *
     * @param articleId 文章id
     * @author gonghf95
     */
    @RequestMapping("/article/details/{articleId}")
    public String articleDetails(@PathVariable int articleId, Model model, HttpServletRequest request) {
        Article article = postService.find(articleId);
        if (article != null) {//文章找到
            model.addAttribute("article", article);
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("usr");
            if (user == null) {//登录后查看文章不计为浏览
                article.setViews(article.getViews() + 1);
            }
            postService.updatePost(article);
            return "details";
        }
        JSONInfo capsule = new JSONInfo();
        capsule.setState(Constants.STATUS_FAILURE);
        capsule.setMessage("查看文章详情失败。出错原因可能是该文章id不存在。");
        model.addAttribute("result", capsule);
        return "error";
    }
}
