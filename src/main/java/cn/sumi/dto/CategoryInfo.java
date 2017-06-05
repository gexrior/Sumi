package cn.sumi.dto;

import cn.sumi.pojo.Category;

/**
 * Created by zhangying on 2017/6/5.
 */
public class CategoryInfo {
    private Category category;
    private int count;

    public CategoryInfo() {
    }

    public CategoryInfo(Category category, int count) {
        this.category = category;
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
