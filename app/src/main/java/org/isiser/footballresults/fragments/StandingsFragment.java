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
import org.isiser.footballresults.adapters.StandingsByLeagueAdapter;
import org.isiser.footballresults.models.Standing;
import org.isiser.footballresults.service.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StandingsFragment extends Fragment {
    private static final String TAG = "StandingsFragment";
    private int selectedLeague;
    private ArrayList<Standing> listOfStandings = new ArrayList<>();

    private RecyclerView recyclerViewStandings;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started");
        final View view = inflater.inflate(R.layout.fragment_standings, container, false);

        getStandingsByLeague(view);

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

    private void getStandingsByLeague(final View view){
        Log.d(TAG, "getMatchesByLeague: started");
        Call<List<Standing>> callStandings = RetrofitManager.getInstance().getClient().getStandingByLeague(selectedLeague);
        callStandings.enqueue(new Callback<List<Standing>>() {
            @Override
            public void onResponse(Call<List<Standing>> call, Response<List<Standing>> response) {
                Log.d(TAG, "onResponse: response");
                List<Standing> standingsByLeague = response.body();
                setData(standingsByLeague, view);
            }

            @Override
            public void onFailure(Call<List<Standing>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void setData(List<Standing> standings, View view){
        for(Standing s : standings){
            listOfStandings.add(s);
            System.out.println(s.getTeam_name() + " aaaa");
        }

        recyclerViewStandings = (RecyclerView) view.findViewById(R.id.recViewStandings);
        StandingsByLeagueAdapter standingsAdapter = new StandingsByLeagueAdapter(getContext());
        recyclerViewStandings.setAdapter(standingsAdapter);
        recyclerViewStandings.setLayoutManager(new LinearLayoutManager(getContext()));
        standingsAdapter.setStandings(listOfStandings);

    }

}
