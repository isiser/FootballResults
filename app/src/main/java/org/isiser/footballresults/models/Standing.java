package org.isiser.footballresults.models;

public class Standing {
    private int league_id;
    private int team_id;
    private String team_name;
    private String league_name;
    private int overall_league_position;
    private int overall_league_payed;
    private int overall_league_W;
    private int overall_league_D;
    private int overall_league_L;
    private String team_badge;

    public Standing(int league_id, int team_id, String team_name, String league_name, int overall_league_position, int overall_league_payed, int overall_league_W, int overall_league_D, int overall_league_L, String team_badge) {
        this.league_id = league_id;
        this.team_id = team_id;
        this.team_name = team_name;
        this.league_name = league_name;
        this.overall_league_position = overall_league_position;
        this.overall_league_payed = overall_league_payed;
        this.overall_league_W = overall_league_W;
        this.overall_league_D = overall_league_D;
        this.overall_league_L = overall_league_L;
        this.team_badge = team_badge;
    }

    public Standing() {
    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public int getOverall_league_position() {
        return overall_league_position;
    }

    public void setOverall_league_position(int overall_league_position) {
        this.overall_league_position = overall_league_position;
    }

    public int getOverall_league_payed() {
        return overall_league_payed;
    }

    public void setOverall_league_payed(int overall_league_payed) {
        this.overall_league_payed = overall_league_payed;
    }

    public int getOverall_league_W() {
        return overall_league_W;
    }

    public void setOverall_league_W(int overall_league_W) {
        this.overall_league_W = overall_league_W;
    }

    public int getOverall_league_D() {
        return overall_league_D;
    }

    public void setOverall_league_D(int overall_league_D) {
        this.overall_league_D = overall_league_D;
    }

    public int getOverall_league_L() {
        return overall_league_L;
    }

    public void setOverall_league_L(int overall_league_L) {
        this.overall_league_L = overall_league_L;
    }

    public String getTeam_badge() {
        return team_badge;
    }

    public void setTeam_badge(String team_badge) {
        this.team_badge = team_badge;
    }

    @Override
    public String toString() {
        return "Standing{" +
                "league_id=" + league_id +
                ", team_id=" + team_id +
                ", team_name='" + team_name + '\'' +
                ", league_name='" + league_name + '\'' +
                ", overall_league_position=" + overall_league_position +
                ", overall_league_payed=" + overall_league_payed +
                ", overall_league_W=" + overall_league_W +
                ", overall_league_D=" + overall_league_D +
                ", overall_league_L=" + overall_league_L +
                ", team_badge='" + team_badge + '\'' +
                '}';
    }
}
