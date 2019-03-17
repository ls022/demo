package com.java06.pojo;

public class Orders {
    private Integer id;

    private String tableno;

    private String time;

    private Double price;

    private String remake;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableno() {
        return tableno;
    }

    public void setTableno(String tableno) {
        this.tableno = tableno == null ? null : tableno.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
    }
}