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
import org.isiser.footballresults.adapters.LeaguesByCountryAdapter;
import org.isiser.footballresults.models.League;
import org.isiser.footballresults.service.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaguesFragment extends Fragment {
    private static final String TAG = "LeaguesFragment";
    private int selectedCountry = 0;
    private ArrayList<League> listOfLeagues = new ArrayList<League>();

    private RecyclerView recyclerViewLeagues;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started");
        final View view = inflater.inflate(R.layout.fragment_leagues, container, false);

        getLeaguesByCountry(view);



        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Bundle bundle = getArguments();
        if(null != bundle){
            Log.d(TAG, "onAttach: id_country:" + bundle.getInt("selectedCountry", 0));
            selectedCountry = bundle.getInt("selectedCountry", 0);
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void getLeaguesByCountry(final View view) {
        Log.d(TAG, "getLeaguesByCountry: started");

        Call<List<League>> callCountries= RetrofitManager.getInstance().getClient().getLeaguesByCountry(selectedCountry);
        callCountries.enqueue(new Callback<List<League>>() {
                @Override
                public void onResponse(Call<List<League>> call, Response<List<League>> response) {
                    Log.d(TAG, "onResponse: response" );
                    List<League> leaguesByCountry = response.body();
                    setData(leaguesByCountry, view);
                }

            @Override
            public void onFailure(Call<List<League>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

    private void setData(List<League> leagues, View view){
        for (League l : leagues) {
            listOfLeagues.add(l);
            System.out.println(l.getLeague_name() + " aaaaaaaaaaa");
        }

        recyclerViewLeagues = (RecyclerView) view.findViewById(R.id.recViewLeagues);

        LeaguesByCountryAdapter leaguesAdapter = new LeaguesByCountryAdapter(getContext());
        recyclerViewLeagues.setAdapter(leaguesAdapter);
        recyclerViewLeagues.setLayoutManager(new LinearLayoutManager(getContext()));
        leaguesAdapter.setLeagues(listOfLeagues);



    }

}
