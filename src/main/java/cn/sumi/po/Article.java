package cn.sumi.po;

public class Article {

    private Integer aid;

    private String title;

    private String author;

    private String digest;

    private Integer categoryId;

    private Integer articleType;

    private String publishDate;

    private Integer comments;

    private Integer views;

    private String contents;

    public Article(Integer aid, String title, String author, String digest, Integer categoryId, Integer articleType, String publishDate, Integer comments, Integer views, String contents) {
        this.aid = aid;
        this.title = title;
        this.author = author;
        this.digest = digest;
        this.categoryId = categoryId;
        this.articleType = articleType;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
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
                ", categoryId=" + categoryId +
                ", articleType=" + articleType +
                ", publishDate='" + publishDate + '\'' +
                ", comments=" + comments +
                ", views=" + views +
                ", contents='" + contents + '\'' +
                '}';
    }
}