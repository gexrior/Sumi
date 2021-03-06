package cn.sumi.pojo;

public class Article {
    private Integer aid;

    private String title;

    private String author;

    private String digest;

    private Integer cid;

    private String publishDate;

    private Integer comments;

    private Integer views;

    private String contents;

    public Article(Integer aid, String title, String author, String digest, Integer cid, String publishDate, Integer comments, Integer views, String contents) {
        this.aid = aid;
        this.title = title;
        this.author = author;
        this.digest = digest;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate == null ? null : publishDate.trim();
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
        return "Article{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", digest='" + digest + '\'' +
                ", cid=" + cid +
                ", publishDate='" + publishDate + '\'' +
                ", comments=" + comments +
                ", views=" + views +
                ", contents='" + contents + '\'' +
                '}';
    }
}