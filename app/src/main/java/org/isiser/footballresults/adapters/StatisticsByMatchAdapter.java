package org.isiser.footballresults.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.isiser.footballresults.R;
import org.isiser.footballresults.models.Statistic;

import java.util.ArrayList;

public class StatisticsByMatchAdapter extends RecyclerView.Adapter<StatisticsByMatchAdapter.ViewHolder>{
    private static final String TAG = "StatisticsByMatchAdp";

    private ArrayList<Statistic> statistics = new ArrayList<>();
    private Context context;

    public StatisticsByMatchAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem__statistics_rec_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: started");

        Log.d(TAG, "onBindViewHolder: started");
        int homeBroj = Integer.parseInt(statistics.get(position).getHome().replace("%",""));
        int awayBroj = Integer.parseInt(statistics.get(position).getAway().replace("%", ""));

        if(homeBroj > awayBroj){
            holder.txtHomeStat.setTextColor(ContextCompat.getColor(context, R.color.winningTeam));
            holder.txtAwayStat.setTextColor(ContextCompat.getColor(context, R.color.losingTeam));
        } else if (homeBroj < awayBroj){
            holder.txtHomeStat.setTextColor(ContextCompat.getColor(context, R.color.losingTeam));
            holder.txtAwayStat.setTextColor(ContextCompat.getColor(context, R.color.winningTeam));
        }


        holder.txtTypeStat.setText(statistics.get(position).getType());
        holder.txtHomeStat.setText(statistics.get(position).getHome());
        holder.txtAwayStat.setText(statistics.get(position).getAway());


    }

    @Override
    public int getItemCount() {
        return statistics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTypeStat, txtHomeStat, txtAwayStat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTypeStat = (TextView) itemView.findViewById(R.id.middleStatistics);
            txtHomeStat = (TextView) itemView.findViewById(R.id.homeStatistics);
            txtAwayStat = (TextView) itemView.findViewById(R.id.awayStatistics);

        }
    }

    public void setStatistics(ArrayList<Statistic> statistics) {
        this.statistics = statistics;
    }
}
