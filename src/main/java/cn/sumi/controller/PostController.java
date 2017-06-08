package cn.sumi.controller;

import cn.sumi.po.Article;
import cn.sumi.service.PostService;
import cn.sumi.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

/**
 * 文章控制层
 * Created by gonghf95 on 6/7/17.
 */
@Controller
@RequestMapping("/root/{account}/postlist")
public class PostController {

    Logger logger = Logger.getLogger(PostController.class);
    @Autowired
    private PostService postService;

    /**
     * @param t  执行动作,比如,del,edit
     * @param id 动作对象
     * @author gonghf95
     */
    @RequestMapping(value = "")
    public String postlist(@PathVariable String account, @RequestParam(required = false) String t, @RequestParam(required = false) Integer id, Model model) {
        model.addAttribute("account", account);
        if (t != null && t.equals(Constants.ACTION_DEL)) {//将文章移入到回收站
            postService.delete(id);
        } else if (t != null && t.equals(Constants.ACTION_DEEP_DELETE)) {//从回收站删除文章
            postService.remove(id);
            return "root/deleted";
        }
        List<Article> articleList = postService.getArticleListByType(Constants.ARTICLE_TYPE_NORMAL);
        Collections.reverse(articleList);
        model.addAttribute("articleList", articleList);
        return "root/postlist";
    }

    /**
     * 用戶条件查询
     * 前端页面存在三个查询筛选条件，category显示要显示的类别id;第二个参数是文章类型，是回收站的，还是草稿箱的
     *
     * @param category 类别id
     * @param type     类型
     */
    @RequestMapping("/{category}/{type}")
    public String query(@PathVariable Integer category, @PathVariable String type, @PathVariable String account, Model model, @RequestParam(required = false) String t, @RequestParam(required = false) Integer id) {
        model.addAttribute("account", account);
        if (type.equals(Constants.REQUEST_TYPE_DRAFT)) {
            //删除草稿箱的文章
            if (t != null && t.equals(Constants.ACTION_DEL)) {
                postService.delete(id);
            }
            List<Article> articleList = postService.getArticleListByType(Constants.ARTICLE_TYPE_DRAFT);
            Collections.reverse(articleList);
            model.addAttribute("articleList", articleList);
            return "root/draft";
        } else if (type.equals(Constants.REQUEST_TYPE_DELETED)) {
            //执行删除操作
            if (t != null && t.equals(Constants.ACTION_DEEP_DELETE)) {
                postService.remove(id);
            }
            List<Article> articleList = postService.getArticleListByType(Constants.ARTICLE_TYPE_DELETED);
            Collections.reverse(articleList);
            model.addAttribute("articleList", articleList);
            return "root/deleted";
        }
        return "root/postlist";
    }

}
