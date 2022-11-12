package com.leon.demo.entity;

import java.io.Serializable;

public class RunExp implements Serializable {
    private String growth_rate_k;
    private String cycle_size;
    private int threads_per_configuration;
    private int threads_per_evaluation;
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

    public int getThreads_per_configuration() {
        return threads_per_configuration;
    }

    public void setThreads_per_configuration(int threads_per_configuration) {
        this.threads_per_configuration = threads_per_configuration;
    }

    public int getThreads_per_evaluation() {
        return threads_per_evaluation;
    }

    public void setThreads_per_evaluation(int threads_per_evaluation) {
        this.threads_per_evaluation = threads_per_evaluation;
    }
}
