package org.isiser.footballresults.service;

import org.isiser.footballresults.models.Country;
import org.isiser.footballresults.models.League;
import org.isiser.footballresults.models.Match;
import org.isiser.footballresults.models.Standing;
import org.isiser.footballresults.models.StatisticResponse;
import org.isiser.footballresults.models.Team;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClient{

    @GET("?action=get_countries&APIkey=6903a1ca2929a46ec427ee9f95b96211c84f687186f416eab38e0e5a3a2a000f")
    Call<List<Country>> getCountries();

    @GET("?action=get_leagues&APIkey=6903a1ca2929a46ec427ee9f95b96211c84f687186f416eab38e0e5a3a2a000f")
    Call<List<League>> getLeaguesByCountry(@Query("country_id") int id);

    @GET("?action=get_events&from=2019-04-01&to=2019-04-10&APIkey=6903a1ca2929a46ec427ee9f95b96211c84f687186f416eab38e0e5a3a2a000f")
    Call<List<Match>> getMatchesByLeague(@Query("league_id") int league_id);

    @GET("?action=get_standings&APIkey=6903a1ca2929a46ec427ee9f95b96211c84f687186f416eab38e0e5a3a2a000f")
    Call<List<Standing>> getStandingByLeague(@Query("league_id") int league_idS);

    @GET("?action=get_teams&APIkey=6903a1ca2929a46ec427ee9f95b96211c84f687186f416eab38e0e5a3a2a000f")
    Call<List<Team>> getTeamByTeamID(@Query("team_id") int team_id);

    @GET("?action=get_statistics&APIkey=6903a1ca2929a46ec427ee9f95b96211c84f687186f416eab38e0e5a3a2a000f")
    Call<Map<String, StatisticResponse>> getStatisticByMatchID(@Query("match_id") int match_id);
}
