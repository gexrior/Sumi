package cn.sumi.pojo;

import java.util.Date;

public class Visitor {
    private Integer vid;

    private Integer aid;

    private String ipaddr;

    private Date accessTime;

    public Visitor(Integer vid, Integer aid, String ipaddr, Date accessTime) {
        this.vid = vid;
        this.aid = aid;
        this.ipaddr = ipaddr;
        this.accessTime = accessTime;
    }

    public Visitor() {
        super();
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }
}