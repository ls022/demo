package com.java06.pojo;

public class Goods {
    private Integer id;

    private String gname;

    private Double gprice;

    private String gpath;

    private Integer tid;

    private Integer count;

    private String updown;

    private Integer status;

    private String typename;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public String getGpath() {
        return gpath;
    }

    public void setGpath(String gpath) {
        this.gpath = gpath == null ? null : gpath.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getUpdown() {
        return updown;
    }

    public void setUpdown(String updown) {
        this.updown = updown == null ? null : updown.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}