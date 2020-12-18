package com.zgl.pojo;

import java.io.Serializable;

public class TbEleven implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private String num;

    private String company;

    private String fcrg;

    private String sum;

    private String sm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFcrg() {
        return fcrg;
    }

    public void setFcrg(String fcrg) {
        this.fcrg = fcrg;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }
}