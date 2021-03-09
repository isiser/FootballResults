package org.isiser.footballresults.models;

public class Statistic {
    private String type;
    private String home;
    private String away;

    public Statistic(String type, String home, String away) {
        this.type = type;
        this.home = home;
        this.away = away;
    }

    public Statistic() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "type='" + type + '\'' +
                ", home='" + home + '\'' +
                ", away='" + away + '\'' +
                '}';
    }
}
