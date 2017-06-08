package controller;

import base.BaseConfiguration;
import cn.sumi.controller.CategoryController;
import cn.sumi.dto.CategoryInfo;
import cn.sumi.mapper.CategoryMapper;
import cn.sumi.pojo.Category;
import cn.sumi.service.CategoryService;
import cn.sumi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zhangying on 2017/6/5.
 */
public class CategoryControllertest extends BaseConfiguration{
    @Autowired
    private CategoryController categoryController;
    @Autowired
    private CategoryService categoryService;

    @Test
    public void newCategry(){
        Category category=new Category();
        category.setName("jhgwhjag");
        categoryService.newCategory(category);
    }

    @Test
    public void add(){
        Category category=new Category();
        category.setName("jhgwhjag");
        categoryService.newCategory(category);
    }

    @Test
    public void delete(){
      categoryService.deleteCategory(3);
    }
}
