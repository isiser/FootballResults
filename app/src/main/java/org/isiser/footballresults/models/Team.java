package org.isiser.footballresults.models;

import java.util.ArrayList;

public class Team {
    private String team_key;
    private String team_name;
    private String team_badge;
    private ArrayList<Player> players;

    public Team(String team_key, String team_name, String team_badge, ArrayList<Player> players) {
        this.team_key = team_key;
        this.team_name = team_name;
        this.team_badge = team_badge;
        this.players = players;
    }

    public Team() {
    }

    public String getTeam_key() {
        return team_key;
    }

    public void setTeam_key(String team_key) {
        this.team_key = team_key;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_badge() {
        return team_badge;
    }

    public void setTeam_badge(String team_badge) {
        this.team_badge = team_badge;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "team_key='" + team_key + '\'' +
                ", team_name='" + team_name + '\'' +
                ", team_badge='" + team_badge + '\'' +
                ", players=" + players +
                '}';
    }
}
