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
import org.isiser.footballresults.adapters.StatisticsByMatchAdapter;
import org.isiser.footballresults.models.Statistic;
import org.isiser.footballresults.models.StatisticResponse;
import org.isiser.footballresults.service.RetrofitManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatisticsFragment extends Fragment {
    private static final String TAG = "StatisticsFragment";
    private int selectedMatch;
    private ArrayList<Statistic> listOfStatistics = new ArrayList<>();

    private RecyclerView recyclerViewStatistics;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started");
        final View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        getStatisticsByMatch(view);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Bundle bundle = getArguments();
        if(null != bundle){
            Log.d(TAG, "onAttach: " + bundle.getInt("selectedMatchID", 0));
            selectedMatch = bundle.getInt("selectedMatchID", 0);

        }
        super.onAttach(context);
    }

    private void getStatisticsByMatch(final View view){
        Log.d(TAG, "getStatisticsByMatch: started");
        Call<Map<String, StatisticResponse>> callStatistic = RetrofitManager.getInstance().getClient().getStatisticByMatchID(selectedMatch);
        callStatistic.enqueue(new Callback<Map<String, StatisticResponse>>() {
            @Override
            public void onResponse(Call<Map<String, StatisticResponse>> call, Response<Map<String, StatisticResponse>> response) {
                String selected = Integer.toString(selectedMatch);
                Log.d(TAG, "onResponse: response");
                List<Statistic> lista = response.body().get(selected).getStatistics();
                for (Statistic s : lista){
                    System.out.println(s.toString());
                }
                setData(lista, view);
            }

            @Override
            public void onFailure(Call<Map<String, StatisticResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void setData(List<Statistic> statistics, View view){
        for(Statistic s : statistics){
            listOfStatistics.add(s);
            System.out.println(s.toString());
        }

        recyclerViewStatistics = (RecyclerView) view.findViewById(R.id.recViewStatistics);
        StatisticsByMatchAdapter statisticsAdapter = new StatisticsByMatchAdapter(getContext());
        recyclerViewStatistics.setAdapter(statisticsAdapter);
        recyclerViewStatistics.setLayoutManager(new LinearLayoutManager(getContext()));
        statisticsAdapter.setStatistics(listOfStatistics);

    }
}
