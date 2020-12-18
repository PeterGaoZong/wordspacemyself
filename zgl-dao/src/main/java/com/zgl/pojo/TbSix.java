package com.zgl.pojo;

import java.io.Serializable;

public class TbSix implements Serializable {
    private Integer id;

    private String name;

    private Float num;

    private String company;

    private Integer fcrg;

    private Integer sum;

    private String sm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getNum() {
        return num;
    }

    public void setNum(Float num) {
        this.num = num;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getFcrg() {
        return fcrg;
    }

    public void setFcrg(Integer fcrg) {
        this.fcrg = fcrg;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }
}