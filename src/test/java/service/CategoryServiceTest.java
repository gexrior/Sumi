package service;

import base.BaseConfiguration;
import cn.sumi.mapper.CategoryMapper;
import cn.sumi.pojo.Category;
import cn.sumi.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhangying on 2017/6/8.
 */
public class CategoryServiceTest extends BaseConfiguration {
    @Autowired
    CategoryService categoryService;
        public List<Category> findAll() {
            return null;
        }
@Test
        public void newCategory() {
        Category category=new Category();
        category.setName("jhsfjw,qg");
        categoryService.newCategory(category);
        }
    @Test
        public void editCategory() {
            Category category=new Category();
           category= categoryService.find(4);
           category.setName("mo mo slkdjk");
            categoryService.editCategory(category);

        }
    @Test
        public void deleteCategory() {
        categoryService.deleteCategory(4);
        }
    @Test
        public void find() {
        categoryService.find(5);
        }
}
