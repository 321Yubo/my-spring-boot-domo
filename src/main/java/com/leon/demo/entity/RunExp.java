package com.leon.demo.entity;

import java.io.Serializable;

public class RunExp implements Serializable {
    private String growth_rate_k;
    private String cycle_size;

    public String getGrowth_rate_k() {
        return growth_rate_k;
    }

    public void setGrowth_rate_k(String growth_rate_k) {
        this.growth_rate_k = growth_rate_k;
    }

    public String getCycle_size() {
        return cycle_size;
    }

    public void setCycle_size(String cycle_size) {
        this.cycle_size = cycle_size;
    }
}
