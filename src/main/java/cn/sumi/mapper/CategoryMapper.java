package cn.sumi.mapper;

import cn.sumi.pojo.Category;

/**
 * 文章类别DAO
 * Created by gonghf95 on 5/27/17.
 */
public interface CategoryMapper {
    Category find(int cid);
    void add(Category category);
    void update(Category category);
    void delete(Category category);
}
