package cn.sumi.vo;

/**
 * 用户管理标题栏徽章的值对象
 * Created by gonghf95 on 6/3/17.
 */
public class BadgeVO {
    int manage;
    int category;
    int comment;
    int draft;
    int recycleBin;

    public int getManage() {
        return manage;
    }

    public void setManage(int manage) {
        this.manage = manage;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getDraft() {
        return draft;
    }

    public void setDraft(int draft) {
        this.draft = draft;
    }

    public int getRecycleBin() {
        return recycleBin;
    }

    public void setRecycleBin(int recycleBin) {
        this.recycleBin = recycleBin;
    }
}
