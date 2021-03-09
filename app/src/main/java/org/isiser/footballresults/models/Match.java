package org.isiser.footballresults.models;

public class Match {
    private int match_id;
    private int league_id;
    private String match_date;
    private String match_time;

    private int match_hometeam_id;
    private String match_hometeam_name;
    private int match_hometeam_score;
    private int match_hometeam_halftime_score;
    private String team_home_badge;

    private int match_awayteam_id;
    private String match_awayteam_name;
    private int match_awayteam_score;
    private int match_awayteam_halftime_score;
    private String team_away_badge;

    public Match(int match_id, int league_id, String match_date, String match_time, int match_hometeam_id, String match_hometeam_name, int match_hometeam_score, int match_hometeam_halftime_score, String team_home_badge, int match_awayteam_id, String match_awayteam_name, int match_awayteam_score, int match_awayteam_halftime_score, String team_away_badge) {
        this.match_id = match_id;
        this.league_id = league_id;
        this.match_date = match_date;
        this.match_time = match_time;
        this.match_hometeam_id = match_hometeam_id;
        this.match_hometeam_name = match_hometeam_name;
        this.match_hometeam_score = match_hometeam_score;
        this.match_hometeam_halftime_score = match_hometeam_halftime_score;
        this.team_home_badge = team_home_badge;
        this.match_awayteam_id = match_awayteam_id;
        this.match_awayteam_name = match_awayteam_name;
        this.match_awayteam_score = match_awayteam_score;
        this.match_awayteam_halftime_score = match_awayteam_halftime_score;
        this.team_away_badge = team_away_badge;
    }

    public Match() {
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public String getMatch_date() {
        return match_date;
    }

    public void setMatch_date(String match_date) {
        this.match_date = match_date;
    }

    public String getMatch_time() {
        return match_time;
    }

    public void setMatch_time(String match_time) {
        this.match_time = match_time;
    }

    public int getMatch_hometeam_id() {
        return match_hometeam_id;
    }

    public void setMatch_hometeam_id(int match_hometeam_id) {
        this.match_hometeam_id = match_hometeam_id;
    }

    public String getMatch_hometeam_name() {
        return match_hometeam_name;
    }

    public void setMatch_hometeam_name(String match_hometeam_name) {
        this.match_hometeam_name = match_hometeam_name;
    }

    public int getMatch_hometeam_score() {
        return match_hometeam_score;
    }

    public void setMatch_hometeam_score(int match_hometeam_score) {
        this.match_hometeam_score = match_hometeam_score;
    }

    public int getMatch_hometeam_halftime_score() {
        return match_hometeam_halftime_score;
    }

    public void setMatch_hometeam_halftime_score(int match_hometeam_halftime_score) {
        this.match_hometeam_halftime_score = match_hometeam_halftime_score;
    }

    public String getTeam_home_badge() {
        return team_home_badge;
    }

    public void setTeam_home_badge(String team_home_badge) {
        this.team_home_badge = team_home_badge;
    }

    public int getMatch_awayteam_id() {
        return match_awayteam_id;
    }

    public void setMatch_awayteam_id(int match_awayteam_id) {
        this.match_awayteam_id = match_awayteam_id;
    }

    public String getMatch_awayteam_name() {
        return match_awayteam_name;
    }

    public void setMatch_awayteam_name(String match_awayteam_name) {
        this.match_awayteam_name = match_awayteam_name;
    }

    public int getMatch_awayteam_score() {
        return match_awayteam_score;
    }

    public void setMatch_awayteam_score(int match_awayteam_score) {
        this.match_awayteam_score = match_awayteam_score;
    }

    public int getMatch_awayteam_halftime_score() {
        return match_awayteam_halftime_score;
    }

    public void setMatch_awayteam_halftime_score(int match_awayteam_halftime_score) {
        this.match_awayteam_halftime_score = match_awayteam_halftime_score;
    }

    public String getTeam_away_badge() {
        return team_away_badge;
    }

    public void setTeam_away_badge(String team_away_badge) {
        this.team_away_badge = team_away_badge;
    }

    @Override
    public String toString() {
        return "Match{" +
                "match_id=" + match_id +
                ", league_id=" + league_id +
                ", match_date='" + match_date + '\'' +
                ", match_time='" + match_time + '\'' +
                ", match_hometeam_id=" + match_hometeam_id +
                ", match_hometeam_name='" + match_hometeam_name + '\'' +
                ", match_hometeam_score=" + match_hometeam_score +
                ", match_hometeam_halftime_score=" + match_hometeam_halftime_score +
                ", team_home_badge='" + team_home_badge + '\'' +
                ", match_awayteam_id=" + match_awayteam_id +
                ", match_awayteam_name='" + match_awayteam_name + '\'' +
                ", match_awayteam_score=" + match_awayteam_score +
                ", match_awayteam_halftime_score=" + match_awayteam_halftime_score +
                ", team_away_badge='" + team_away_badge + '\'' +
                '}';
    }
}
