package cn.sumi.pojo;

public class Feedback {
    private Integer fid;

    private Integer aid;

    private String contents;

    private Integer replyId;

    public Feedback(Integer fid, Integer aid, String contents, Integer replyId) {
        this.fid = fid;
        this.aid = aid;
        this.contents = contents;
        this.replyId = replyId;
    }

    public Feedback() {
        super();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
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