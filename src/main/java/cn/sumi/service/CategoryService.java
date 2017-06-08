package cn.sumi.service;

import cn.sumi.pojo.Article;
import cn.sumi.pojo.Category;
import cn.sumi.service.impl.CategoryServiceImpl;

import java.util.List;

/**
 * 类别业务
 * Created by zhangying on 2017/6/4.
 */
public interface CategoryService{

    /**
     * 获取用户的类别列表
     *
     */
    List<Category> findAll();

    /**
     * 添加新类别
     *
     * @param category 待添加类别
     * @return 插入后的id
     */
    int newCategory(Category category);

    /**
     * 编辑类别
     *
     * @param category 待编辑的类别
     */
    void editCategory(Category category);

    /**
     * 删除类别
     *
     * @param categoryId 待删除类别Id
     */
    void deleteCategory(int categoryId);


    /**
     * 类别详情
     *
     * @param categoryId 类别id
     * @author zhangying
     */
    Category find(int categoryId);

}
