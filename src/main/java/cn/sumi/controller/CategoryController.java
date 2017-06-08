package cn.sumi.controller;

import cn.sumi.pojo.Article;
import cn.sumi.pojo.Category;
import cn.sumi.service.ArticleService;
import cn.sumi.service.CategoryService;
import cn.sumi.service.UserService;
import cn.sumi.vo.JSONResultVO;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理类别控制层
 * Created by zhangying on 2017/6/5.
 */
@Controller
@RequestMapping("/root/{account}/catergory")
public class CategoryController {
    Logger logger = Logger.getLogger(CategoryController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService ;

    /**
     * 新类别
     * */
    @RequestMapping("/catergoryedit")
    public String newCategory(@PathVariable Category category){
        JSONResultVO JSONResultVO = new JSONResultVO();
        try{
            int cid=categoryService.newCategory(category);
            JSONResultVO.setState(JSONResultVO.SUCCESS);
            JSONResultVO.setData(cid);
            return JSON.toJSONString(JSONResultVO);
        }catch(DataAccessException e){
            logger.error(e.toString());
        }
        JSONResultVO.setState(JSONResultVO.FAILURE);
        JSONResultVO.setMessage("类别已存在");
        return JSON.toJSONString(JSONResultVO);


    }
    /**
     * 类别添加
     *
     * @param category 添加类别
     */
    @RequestMapping("/addcategory")
    public @ResponseBody
    String add(@PathVariable Category category) {
        logger.info("category: " + category);  //日志，打印输出Category
        //ajax添加新类别（ajax获得用户输入http携带前端请求的数据向后台发出请求，由json携带Java验证后的数据结果（是否操作成功 state用于判断（1为TRUE，0为FALSE））返回前端）
        JSONResultVO JSONResultVO = new JSONResultVO();
        try {
            int cId = categoryService.newCategory(category);
            JSONResultVO.setState(JSONResultVO.SUCCESS);
            JSONResultVO.setData(cId);
            return JSON.toJSONString(JSONResultVO);
        } catch (DataAccessException e) {
            logger.error(e.toString());
        }
        JSONResultVO.setState(JSONResultVO.FAILURE);
        JSONResultVO.setMessage("类别添加失败");
        return JSON.toJSONString(JSONResultVO);
    }

    /**
     * 删除类别
     *
     * @param cid 类别id
     */
    @RequestMapping("/deletecategory/{cid}")
    //jsp删除类别，用jsp中的<a>或<submit>标签向后台发送请求（不携带数据），后台经过验证判断返回model（数据）+view（界面，要从model中读取数据）给前台）
    public String delete(@PathVariable int cid) {
        categoryService.deleteCategory(cid);
        return "category";
    }

}
