package cn.sumi.pojo;

import java.util.Date;

public class Post {
    private Integer pid;

    private String title;

    private String author;

    private Integer cid;

    private Date publishDate;

    private Integer comments;

    private Integer views;

    private String contents;

    public Post(Integer pid, String title, String author, Integer cid, Date publishDate, Integer comments, Integer views, String contents) {
        this.pid = pid;
        this.title = title;
        this.author = author;
        this.cid = cid;
        this.publishDate = publishDate;
        this.comments = comments;
        this.views = views;
        this.contents = contents;
    }

    public Post() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
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

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", cid=" + cid +
                ", publishDate=" + publishDate +
                ", comments=" + comments +
                ", views=" + views +
                ", contents='" + contents + '\'' +
                '}';
    }
}