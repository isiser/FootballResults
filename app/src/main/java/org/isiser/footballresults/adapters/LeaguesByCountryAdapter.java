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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.isiser.footballresults.LeagueActivity;
import org.isiser.footballresults.R;
import org.isiser.footballresults.models.League;

import java.util.ArrayList;

public class LeaguesByCountryAdapter extends RecyclerView.Adapter<LeaguesByCountryAdapter.ViewHolder> {
    private static final String TAG = "LeaguesByCountryAdapter";

    private ArrayList<League> leagues = new ArrayList<>();
    private Context context;

    public LeaguesByCountryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_leagues_rec_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(context).asBitmap().load(leagues.get(position).getLeague_logo()).into(holder.imageLeagueLogo);
        holder.txtLeagueName.setText(leagues.get(position).getLeague_name());
        holder.txtLeagueSeason.setText(leagues.get(position).getLeague_season());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, LeagueActivity.class);
                intent.putExtra("league_id", leagues.get(position).getLeague_id());
                intent.putExtra("league_name", leagues.get(position).getLeague_name());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        System.out.println("aaaaaaaaa" + leagues.size());
        return leagues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageLeagueLogo;
        private TextView txtLeagueName, txtLeagueSeason;

        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageLeagueLogo = (ImageView) itemView.findViewById(R.id.imgLogoLeague);
            txtLeagueName = (TextView) itemView.findViewById(R.id.txtViewNameLeg);
            txtLeagueSeason = (TextView) itemView.findViewById(R.id.txtViewSeasonLeg);
            cardView = (CardView) itemView.findViewById(R.id.leagueCard);
        }
    }

    public void setLeagues(ArrayList<League> leagues) {
        this.leagues = leagues;
        notifyDataSetChanged();
    }
}
