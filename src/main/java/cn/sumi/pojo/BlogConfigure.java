package cn.sumi.pojo;

public class BlogConfigure {
    private int userId;
    private String title;
    private String signature;

    public BlogConfigure(int userId, String title, String signature) {
        this.userId = userId;
        this.title = title;
        this.signature = signature;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
