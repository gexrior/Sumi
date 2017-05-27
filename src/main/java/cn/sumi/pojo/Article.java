package cn.sumi.pojo;

import java.util.Date;

public class Article {
    private Integer aid;

    private String title;

    private Integer uid;

    private Integer cid;

    private Date publishDate;

    private Integer comments;

    private Integer views;

    private String contents;

    public Article(Integer aid, String title, Integer uid, Integer cid, Date publishDate, Integer comments, Integer views, String contents) {
        this.aid = aid;
        this.title = title;
        this.uid = uid;
        this.cid = cid;
        this.publishDate = publishDate;
        this.comments = comments;
        this.views = views;
        this.contents = contents;
    }

    public Article() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }
}