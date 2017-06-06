package cn.sumi.controller;

import cn.sumi.po.Article;
import cn.sumi.service.ArticleService;
import cn.sumi.service.UserService;
import cn.sumi.dto.JsonResult;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * 用户管理文章控制层
 * 请求路径形式:/root/{account}/article/操作
 * Created by gonghf95 on 5/24/17.
 */
@Controller
@RequestMapping("/root/{account}/article")
public class ArticleController {

    Logger logger = Logger.getLogger(ArticleController.class);
    @Autowired
    private ArticleService articleService;

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
    @RequestMapping("/add")
    public @ResponseBody
    String add(@PathVariable String account, Article article) {
        logger.info("article: " + article);
        JsonResult JsonResult = new JsonResult();
        try {
            int postId = articleService.newArticle(article, account);
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

    /**
     * 删除文章
     *
     * @param aid 文章id
     * @author gonghf95
     */
    @RequestMapping("/delete/{aid}")
    public String delete(@PathVariable int aid, @PathVariable String account, Model model) {
        model.addAttribute("account", account);
        articleService.deleteArticle(aid);
        return "redirect:/root/"+account+"/postlist";
    }

    /**
     * 用户上传图片
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @author gonghf95
     */
    @RequestMapping("/upload")
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
