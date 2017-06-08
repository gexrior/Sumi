package cn.sumi.dto;

import cn.sumi.pojo.Category;

import java.util.List;

/**
 * Created by zhangying on 2017/6/5.
 */
public class CategoryInfo {
    private List<Category> category;
    private int count;

    public CategoryInfo() {
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
