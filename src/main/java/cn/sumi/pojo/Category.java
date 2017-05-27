package cn.sumi.pojo;

public class Category {
    private Integer cid;

    private String name;

    public Category(Integer cid, String name) {
        this.cid = cid;
        this.name = name;
    }

    public Category() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}