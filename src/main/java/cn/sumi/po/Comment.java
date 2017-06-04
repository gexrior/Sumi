package cn.sumi.po;

public class Comment {
    private Integer cid;

    private Integer aid;

    private String contents;

    private Integer replyId;

    public Comment(Integer cid, Integer aid, String contents, Integer replyId) {
        this.cid = cid;
        this.aid = aid;
        this.contents = contents;
        this.replyId = replyId;
    }

    public Comment() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }
}