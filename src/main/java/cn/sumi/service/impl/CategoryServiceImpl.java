package cn.sumi.service.impl;

import cn.sumi.mapper.ArticleMapper;
import cn.sumi.mapper.CategoryMapper;
import cn.sumi.pojo.Article;
import cn.sumi.pojo.Category;
import cn.sumi.pojo.Comment;
import cn.sumi.service.CategoryService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangying on 2017/6/4.
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryMapper categoryMapper;

    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    public int newCategory(Category category) throws DataAccessException {
        categoryMapper.insert(category);
        return category.getCid();
    }

    public  void editCategory(Category categoryId){

    }

    public void deleteCategory(int categoryId) {
        categoryMapper.deleteByPrimaryKey(categoryId);
    }

    public Category find(int categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

}

