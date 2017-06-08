package cn.sumi.controller;

import cn.sumi.dto.JSONInfo;
import cn.sumi.po.Article;
import cn.sumi.service.PostService;
import cn.sumi.utils.Constants;
import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
    private PostService postService;

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
        return "root/category";
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
        return "root/feedback";
    }

    /**
     * 回收站
     *
     * @param account 当前账户
     * @author gonghf95
     */
    @RequestMapping("/deleted")
    public String deleted(Model model, @PathVariable String account) {
        model.addAttribute("account", account);
        List<Article> articleList = postService.getArticleListByType(Constants.ARTICLE_TYPE_DELETED);
        Collections.reverse(articleList);
        model.addAttribute("articleList", articleList);
        return "root/deleted";
    }

    /**
     * 新文章
     *
     * @param account 当前用户
     */
    @RequestMapping("/postedit")
    public String newArticle(@PathVariable String account, Model model) {
        model.addAttribute("account", account);
        return "root/postedit";
    }

    /**
     * 文章添加
     *
     * @param account 当前用户
     * @param article 添加帖子
     * @author gonghf95
     */
    @RequestMapping("/postedit/add")
    public @ResponseBody
    String add(@PathVariable String account, Article article) {
        logger.info("article: " + article);
        postService.newPost(article, account);
        JSONInfo jsonInfo = new JSONInfo(account,Constants.STATUS_SUCCESS);
        return JSON.toJSONString(jsonInfo);
    }

    @RequestMapping("/postedit/{aid}")
    public String editArticle(@PathVariable int aid, @PathVariable String account, Model model) {
        model.addAttribute("account",account);
        Article article = postService.find(aid);
        model.addAttribute("post",article);
        return "/root/postedit";
    }

    @RequestMapping("/postedit/update/{aid}")
    public  @ResponseBody
    String updatePost(@PathVariable String account,@PathVariable int aid, Article article){
        logger.info("更新文章内容: ---------------->" + article);
        article.setAid(aid);
        postService.updateFromOldPost(article);
        JSONInfo jsonInfo = new JSONInfo(account,Constants.STATUS_SUCCESS);
        return JSON.toJSONString(jsonInfo);
    }

    /**
     * 用户上传图片
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @author gonghf95
     */
    @RequestMapping("/article/uploadimg")
    public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            String path = request.getSession().getServletContext().getRealPath(File.separator) + "upload";
            File repo = new File(path);
            if (!repo.exists()) {
                repo.mkdirs();
            }
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024 * 1024 * 10);
            factory.setRepository(repo);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(3 * 1024 * 1024);
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {
                    processFormField(item);
                } else {
                    processUploadedFile(item, path, request, response);
                }

            }
        }

    }

    private void processFormField(FileItem item) {
        logger.info("processFormField: " + item);
    }

    private void processUploadedFile(FileItem item, String savePath, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fieldName = item.getFieldName();
        String fileName = item.getName();
        item.write(new File(savePath + File.separator + fileName));

        String imgPath = request.getContextPath() + File.separator + fieldName + File.separator + fileName;
        response.setContentType("text/html;charset=UTF-8");
        String callback = request.getParameter("CKEditorFuncNum");
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imgPath + "',''" + ")");
        out.println("</script>");
        out.flush();
        out.close();
    }

}
