package org.isiser.footballresults.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.isiser.footballresults.R;
import org.isiser.footballresults.StatisticsActivity;
import org.isiser.footballresults.models.Match;

import java.util.ArrayList;

public class MatchesByLeagueAdapter extends RecyclerView.Adapter<MatchesByLeagueAdapter.ViewHolder>{
    private static final String TAG = "MatchesByLeagueAdapter";

    private ArrayList<Match> matches = new ArrayList<>();
    private Context context;

    public MatchesByLeagueAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_matches_rec_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: started");
        if(matches.get(position).getMatch_hometeam_score() > matches.get(position).getMatch_awayteam_score()){
            holder.txtNameHomeTeam.setTextColor(ContextCompat.getColor(context, R.color.winningTeam));
            holder.txtNameAwayTeam.setTextColor(ContextCompat.getColor(context, R.color.losingTeam));
        } else if (matches.get(position).getMatch_hometeam_score() < matches.get(position).getMatch_awayteam_score()){
            holder.txtNameHomeTeam.setTextColor(ContextCompat.getColor(context, R.color.losingTeam));
            holder.txtNameAwayTeam.setTextColor(ContextCompat.getColor(context, R.color.winningTeam));
        }
        Glide.with(context).asBitmap().load(matches.get(position).getTeam_home_badge()).into(holder.imgHomeTeam);
        Glide.with(context).asBitmap().load(matches.get(position).getTeam_away_badge()).into(holder.imgAwayTeam);

        holder.txtNameHomeTeam.setText(matches.get(position).getMatch_hometeam_name());
        holder.txtNameAwayTeam.setText(matches.get(position).getMatch_awayteam_name());

        holder.txtResHalfHome.setText(Integer.toString(matches.get(position).getMatch_hometeam_halftime_score()));
        holder.txtResHalfAway.setText(Integer.toString(matches.get(position).getMatch_awayteam_halftime_score()));

        holder.txtResEndHome.setText(Integer.toString(matches.get(position).getMatch_hometeam_score()));
        holder.txtResEndAway.setText(Integer.toString(matches.get(position).getMatch_awayteam_score()));

        holder.cardMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StatisticsActivity.class);
                intent.putExtra("match_id", matches.get(position).getMatch_id());
                intent.putExtra("home_name", matches.get(position).getMatch_hometeam_name());
                intent.putExtra("home_badge", matches.get(position).getTeam_home_badge());
                intent.putExtra("away_name", matches.get(position).getMatch_awayteam_name());
                intent.putExtra("away_badge", matches.get(position).getTeam_away_badge());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgHomeTeam, imgAwayTeam;
        private TextView txtNameHomeTeam, txtNameAwayTeam, txtResHalfHome, txtResHalfAway, txtResEndHome, txtResEndAway;

        private CardView cardMatch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHomeTeam = (ImageView) itemView.findViewById(R.id.imgBadgeHome);
            imgAwayTeam = (ImageView) itemView.findViewById(R.id.imgBadgeAway);

            txtNameHomeTeam = (TextView) itemView.findViewById(R.id.txtTeamNameHome);
            txtNameAwayTeam = (TextView) itemView.findViewById(R.id.txtTeamNameAway);

            txtResHalfHome = (TextView) itemView.findViewById(R.id.txtTeamHalfResHome);
            txtResHalfAway = (TextView) itemView.findViewById(R.id.txtTeamHalfResAway);

            txtResEndHome = (TextView) itemView.findViewById(R.id.txtTeamEndResHome);
            txtResEndAway = (TextView) itemView.findViewById(R.id.txtTeamEndResAway);

            cardMatch = (CardView) itemView.findViewById(R.id.matchCard);

        }

    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }
}
