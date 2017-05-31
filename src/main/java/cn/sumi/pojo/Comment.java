package cn.sumi.pojo;

public class Comment {
    private Integer cid;

    private Integer pid;

    private String contents;

    private Integer replyId;

    public Comment(Integer cid, Integer pid, String contents, Integer replyId) {
        this.cid = cid;
        this.pid = pid;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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