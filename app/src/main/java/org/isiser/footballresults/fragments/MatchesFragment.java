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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.isiser.footballresults.R;
import org.isiser.footballresults.adapters.MatchesByLeagueAdapter;
import org.isiser.footballresults.models.Match;
import org.isiser.footballresults.service.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchesFragment extends Fragment {
    private static final String TAG = "MatchesFragment";
    private int selectedLeague;
    private ArrayList<Match> listOfMatches = new ArrayList<>();

    private RecyclerView recyclerViewMatches;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started");
        final View view = inflater.inflate(R.layout.fragment_matches, container, false);

        getMatchesByLeague(view);


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Bundle bundle = getArguments();
        if(null != bundle){
            Log.d(TAG, "onAttach: id_leagues" + bundle.getInt("selectedLeagueID", 0));
            selectedLeague = bundle.getInt("selectedLeagueID", 0);
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void getMatchesByLeague(final View view){
        Log.d(TAG, "getMatchesByLeague: started");
        Call<List<Match>> callMatches = RetrofitManager.getInstance().getClient().getMatchesByLeague(selectedLeague);
        callMatches.enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                Log.d(TAG, "onResponse: resoponse");
                List<Match> matchesByLeague = response.body();
                setData(matchesByLeague, view);
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void setData(List<Match> matches, View view){
        for(Match m : matches) {
            listOfMatches.add(m);
            System.out.println(m.getMatch_hometeam_name() + " bbbbbbbbbb");
        }

        recyclerViewMatches = (RecyclerView) view.findViewById(R.id.recViewMatches);
        MatchesByLeagueAdapter matchesAdapter = new MatchesByLeagueAdapter(getContext());
        recyclerViewMatches.setAdapter(matchesAdapter);
        recyclerViewMatches.setLayoutManager(new LinearLayoutManager(getContext()));
        matchesAdapter.setMatches(listOfMatches);


    }
}
