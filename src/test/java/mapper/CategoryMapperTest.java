package mapper;

import base.BaseConfiguration;
import cn.sumi.mapper.CategoryMapper;
import cn.sumi.mapper.UserMapper;
import cn.sumi.pojo.Article;
import cn.sumi.pojo.Category;
import cn.sumi.pojo.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhangying on 2017/6/5.
 */
public class CategoryMapperTest extends BaseConfiguration{

    Logger logger = Logger.getLogger(CategoryMapperTest.class);
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void findAll() {
        List<Category> categoryList = categoryMapper.findAll();
        for (Category category : categoryList) {
            logger.info(category);
        }
    }

    @Test
    public void insert() {
        Category category = new Category();
        category.setName("abcd");
        categoryMapper.insert(category);
    }

    @Test
    public void deleteByPrimaryKey() {
        categoryMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void insertSelective() {

    }

    @Test
   public void selectByPrimaryKey(){
        Category category1 = categoryMapper.selectByPrimaryKey(2);

   }

    @Test
    public void updateByPrimaryKeySelective(){
        Category target = new Category();
        target.setName("opiu");
        categoryMapper.updateByPrimaryKeySelective(target);
    }

    @Test
    public void updateByPrimaryKey(){
        Category category= categoryMapper.selectByPrimaryKey(1);
        category.setName("hhgfhj");
     categoryMapper.updateByPrimaryKey(category);
    }
}
