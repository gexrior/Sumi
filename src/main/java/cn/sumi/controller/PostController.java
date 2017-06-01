package cn.sumi.controller;

import cn.sumi.pojo.Post;
import cn.sumi.service.PostService;
import cn.sumi.utils.JSONCapsule;
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
 * 文章控制层
 * Created by gonghf95 on 5/24/17.
 */
@Controller
@RequestMapping("/root/{account}/post")
public class PostController {

    Logger logger = Logger.getLogger(PostController.class);
    @Autowired
    private PostService postService;

    /**
     * 文章添加
     *
     * @param account 当前用户
     * @param post    添加帖子
     * @author gonghf95
     */
    @RequestMapping("/add")
    public @ResponseBody
    String add(@PathVariable String account, Post post) {
        logger.info("post: " + post);
        JSONCapsule jsonCapsule = new JSONCapsule();
        try {
            int postId = postService.newPost(post, account);
            jsonCapsule.setState(JSONCapsule.SUCCESS);
            jsonCapsule.setMessage(account);
            jsonCapsule.setData(postId);
            return JSON.toJSONString(jsonCapsule);
        } catch (DataAccessException e) {
            logger.error(e.toString());
        }
        jsonCapsule.setState(JSONCapsule.FAILURE);
        jsonCapsule.setMessage("账户不存在,发表文章失败");
        return JSON.toJSONString(jsonCapsule);
    }

    /**
     * 删除文章
     *
     * @param aid 文章id
     * @author gonghf95
     */
    @RequestMapping("/delete/{aid}")
    public String delete(@PathVariable int aid) {
        return null;
    }

    /**
     * 文章详情
     *
     * @param postId 文章id
     * @author gonghf95
     */
    @RequestMapping("/details/{postId}")
    public String details(@PathVariable int postId, Model model) {
        Post post = postService.find(postId);
        if (post != null){//文章没找到
            model.addAttribute("post",post);
            return "details";
        }
        JSONCapsule capsule = new JSONCapsule();
        capsule.setState(JSONCapsule.FAILURE);
        capsule.setMessage("查看文章详情失败。出错原因可能是该文章id不存在。");
        model.addAttribute("capsule",capsule);
        return "error";
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
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // Set factory constraints
            factory.setSizeThreshold(1024 * 1024 * 10);
            factory.setRepository(repo);
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(3 * 1024 * 1024);
            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            // Process the uploaded items
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
        String name = item.getFieldName();
        String value = item.getString();
        logger.info("Upload form field: name: " + name + " value: " + value);
    }

    private void processUploadedFile(FileItem item, String savePath, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fieldName = item.getFieldName();
        String fileName = item.getName();
        String contentType = item.getContentType();
        boolean isInMemory = item.isInMemory();
        long sizeInBytes = item.getSize();
        logger.info("fieldName : " + fieldName + " fileName: " + fileName + " contentType: " + contentType + " isInMemory: " + isInMemory + " sizeInBytes: " + sizeInBytes);
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
