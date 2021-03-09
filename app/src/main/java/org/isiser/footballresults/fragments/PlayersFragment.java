package org.isiser.footballresults.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.isiser.footballresults.R;
import org.isiser.footballresults.adapters.PlayersByTeamAdapter;
import org.isiser.footballresults.models.Player;
import org.isiser.footballresults.models.Team;
import org.isiser.footballresults.service.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersFragment extends Fragment {
    private static final String TAG = "PlayersFragment";
    private int selectedTeam;
    private ArrayList<Player> listOfPlayers = new ArrayList<>();

    private RecyclerView recyclerViewPlayers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started");
        final View view = inflater.inflate(R.layout.fragment_players, container, false);

        getPlayersByLeague(view);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Bundle bundle = getArguments();
        if(null != bundle){
            Log.d(TAG, "onAttach: selectedTeamID" + bundle.getInt("selectedTeamID", 0));
            selectedTeam = bundle.getInt("selectedTeamID", 0);
        }
        super.onAttach(context);
    }

    private void getPlayersByLeague(final View view){
        Log.d(TAG, "getPlayersByLeague: started");
        Call<List<Team>> callTeam = RetrofitManager.getInstance().getClient().getTeamByTeamID(selectedTeam);
        callTeam.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                Log.d(TAG, "onResponse: response");
                List<Team> teams = response.body();
                List<Player> playersByTeam = teams.get(0).getPlayers();
                setData(playersByTeam, view);
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void setData(List<Player> players, View view){
        System.out.println("usoooooooooooooooo");
        if (players.isEmpty())
            System.out.println("nema igraca");
        for(Player p : players){
            listOfPlayers.add(p);
            System.out.println(p.getPlayer_name() + " gggg");
        }

        recyclerViewPlayers = (RecyclerView) view.findViewById(R.id.recViewPlayers);
        PlayersByTeamAdapter playersAdapter = new PlayersByTeamAdapter(getContext());
        recyclerViewPlayers.setAdapter(playersAdapter);
        recyclerViewPlayers.setLayoutManager(new GridLayoutManager(getContext(), 2));
        playersAdapter.setPlayers(listOfPlayers);
    }
}
