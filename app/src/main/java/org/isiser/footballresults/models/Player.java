package org.isiser.footballresults.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {
    private String player_key;
    private String player_name;
    private int player_number;
    private String player_country;
    private String player_type;
    private int player_age;
    private int player_match_played;
    private int player_goals;
    private int player_yellow_cards;
    private int player_red_cards;
    private String team_name;
    private String team_key;

    public Player(String player_key, String player_name, int player_number, String player_country, String player_type, int player_age, int player_match_played, int player_goals, int player_yellow_cards, int player_red_cards, String team_name, String team_key) {
        this.player_key = player_key;
        this.player_name = player_name;
        this.player_number = player_number;
        this.player_country = player_country;
        this.player_type = player_type;
        this.player_age = player_age;
        this.player_match_played = player_match_played;
        this.player_goals = player_goals;
        this.player_yellow_cards = player_yellow_cards;
        this.player_red_cards = player_red_cards;
        this.team_name = team_name;
        this.team_key = team_key;
    }

    public Player() {
    }

    protected Player(Parcel in) {
        player_key = in.readString();
        player_name = in.readString();
        player_number = in.readInt();
        player_country = in.readString();
        player_type = in.readString();
        player_age = in.readInt();
        player_match_played = in.readInt();
        player_goals = in.readInt();
        player_yellow_cards = in.readInt();
        player_red_cards = in.readInt();
        team_name = in.readString();
        team_key = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getPlayer_key() {
        return player_key;
    }

    public void setPlayer_key(String player_key) {
        this.player_key = player_key;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getPlayer_number() {
        return player_number;
    }

    public void setPlayer_number(int player_number) {
        this.player_number = player_number;
    }

    public String getPlayer_country() {
        return player_country;
    }

    public void setPlayer_country(String player_country) {
        this.player_country = player_country;
    }

    public String getPlayer_type() {
        return player_type;
    }

    public void setPlayer_type(String player_type) {
        this.player_type = player_type;
    }

    public int getPlayer_age() {
        return player_age;
    }

    public void setPlayer_age(int player_age) {
        this.player_age = player_age;
    }

    public int getPlayer_match_played() {
        return player_match_played;
    }

    public void setPlayer_match_played(int player_match_played) {
        this.player_match_played = player_match_played;
    }

    public int getPlayer_goals() {
        return player_goals;
    }

    public void setPlayer_goals(int player_goals) {
        this.player_goals = player_goals;
    }

    public int getPlayer_yellow_cards() {
        return player_yellow_cards;
    }

    public void setPlayer_yellow_cards(int player_yellow_cards) {
        this.player_yellow_cards = player_yellow_cards;
    }

    public int getPlayer_red_cards() {
        return player_red_cards;
    }

    public void setPlayer_red_cards(int player_red_cards) {
        this.player_red_cards = player_red_cards;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_key() {
        return team_key;
    }

    public void setTeam_key(String team_key) {
        this.team_key = team_key;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_key='" + player_key + '\'' +
                ", player_name='" + player_name + '\'' +
                ", player_number=" + player_number +
                ", player_country='" + player_country + '\'' +
                ", player_type='" + player_type + '\'' +
                ", player_age=" + player_age +
                ", player_match_played=" + player_match_played +
                ", player_goals=" + player_goals +
                ", player_yellow_cards=" + player_yellow_cards +
                ", player_red_cards=" + player_red_cards +
                ", team_name='" + team_name + '\'' +
                ", team_key='" + team_key + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(player_key);
        dest.writeString(player_name);
        dest.writeInt(player_number);
        dest.writeString(player_country);
        dest.writeString(player_type);
        dest.writeInt(player_age);
        dest.writeInt(player_match_played);
        dest.writeInt(player_goals);
        dest.writeInt(player_yellow_cards);
        dest.writeInt(player_red_cards);

    }
}
