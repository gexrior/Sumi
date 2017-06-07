package cn.sumi.controller;

import cn.sumi.dto.JsonResult;
import cn.sumi.po.Article;
import cn.sumi.service.PostService;
import cn.sumi.utils.Constants;
import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
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
            return "root/postlist";
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
     * 前端页面存在三个查询筛选条件，category显示要显示的类别id;第二个参数是文章类型，是回收站的，还是草稿箱的;第三个参数是返回的页面
     *
     * @param category 类别id
     * @param type     类型
     */
    @RequestMapping("/{category}/{type}")
    public String query(@PathVariable Integer category, @PathVariable String type, @PathVariable String account, Model model, @RequestParam(required = false) String t, @RequestParam(required = false) Integer id) {
        model.addAttribute("account", account);
        if (type.equals(Constants.REQUEST_TYPE_DRAFT)) {
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


    /**
     * 文章添加
     *
     * @param account 当前用户
     * @param article 添加帖子
     * @author gonghf95
     */
    @RequestMapping("/add")
    public @ResponseBody
    String add(@PathVariable String account, Article article) {
        logger.info("article: " + article);
        JsonResult JsonResult = new JsonResult();
        try {
            int postId = postService.newArticle(article, account);
            JsonResult.setState(JsonResult.SUCCESS);
            JsonResult.setMessage(account);
            JsonResult.setData(postId);
            return JSON.toJSONString(JsonResult);
        } catch (DataAccessException e) {
            logger.error(e.toString());
        }
        JsonResult.setState(JsonResult.FAILURE);
        JsonResult.setMessage("账户不存在,发表文章失败");
        return JSON.toJSONString(JsonResult);
    }

}
