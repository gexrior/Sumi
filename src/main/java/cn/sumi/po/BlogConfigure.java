package cn.sumi.po;

public class BlogConfigure {
    private String account;

    private String title;

    private String signature;

    public BlogConfigure(String account, String title, String signature) {
        this.account = account;
        this.title = title;
        this.signature = signature;
    }

    public BlogConfigure() {
        super();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }
}