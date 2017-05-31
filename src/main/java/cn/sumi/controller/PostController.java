package cn.sumi.controller;

import cn.sumi.pojo.Post;
import cn.sumi.service.PostService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
     *
     * */
    @RequestMapping("/add")
    public @ResponseBody
    String add(@PathVariable String account, Post post) {
        logger.info("title: " + post);
        postService.newPost(null);
        return null;
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
     * @param aid 文章id
     * @author gonghf95
     */
    @RequestMapping("/details/{aid}")
    public ModelAndView details(@PathVariable int aid) {

        return null;
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
