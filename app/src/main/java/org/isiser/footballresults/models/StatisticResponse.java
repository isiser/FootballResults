package org.isiser.footballresults.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class StatisticResponse {

    @SerializedName("statistics")
    private List<Statistic> statistics;

    public StatisticResponse(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }
}

