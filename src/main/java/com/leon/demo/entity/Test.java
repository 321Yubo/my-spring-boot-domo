package com.leon.demo.entity;

import java.io.Serializable;

public class Test implements Serializable {

    private String fp;
    private String sq;

    public String getFp() {
        return fp;
    }

    public void setFp(String fp) {
        this.fp = fp;
    }

    public String getSq() {
        return sq;
    }

    public void setSq(String sq) {
        this.sq = sq;
    }
}
