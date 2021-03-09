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

import org.isiser.footballresults.PlayersActivity;
import org.isiser.footballresults.R;
import org.isiser.footballresults.models.Standing;

import java.util.ArrayList;

public class StandingsByLeagueAdapter extends RecyclerView.Adapter<StandingsByLeagueAdapter.ViewHolder>{
    private static final String TAG = "StandingsByLeagueAdapte";

    private ArrayList<Standing> standings = new ArrayList<>();
    private Context context;

    public StandingsByLeagueAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_standings_rec_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: started");

        Glide.with(context).asBitmap().load(standings.get(position).getTeam_badge()).into(holder.imgStandTeamBadge);

        holder.txtStandPosition.setText(Integer.toString(standings.get(position).getOverall_league_position()) + ".");
        holder.txtStandTeamName.setText(standings.get(position).getTeam_name());
        holder.txtStandW.setText(Integer.toString(standings.get(position).getOverall_league_W()));
        holder.txtStandD.setText(Integer.toString(standings.get(position).getOverall_league_D()));
        holder.txtStandL.setText(Integer.toString(standings.get(position).getOverall_league_L()));
        holder.txtStandTotal.setText(Integer.toString(standings.get(position).getOverall_league_payed()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayersActivity.class);
                intent.putExtra("team_id", standings.get(position).getTeam_id());
                intent.putExtra("team_name", standings.get(position).getTeam_name());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return standings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgStandTeamBadge;
        private TextView txtStandPosition, txtStandTeamName, txtStandW, txtStandD, txtStandL, txtStandTotal;
        private CardView cardView;

        private CardView cardStanding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgStandTeamBadge = (ImageView) itemView.findViewById(R.id.imgStandTeamBadge);
            txtStandPosition = (TextView) itemView.findViewById(R.id.txtStandPosition);
            txtStandTeamName = (TextView) itemView.findViewById(R.id.txtStandTeamName);
            txtStandW = (TextView) itemView.findViewById(R.id.txtStandW);
            txtStandD = (TextView) itemView.findViewById(R.id.txtStandD);
            txtStandL = (TextView) itemView.findViewById(R.id.txtStandL);
            txtStandTotal = (TextView) itemView.findViewById(R.id.txtStandTotal);
            cardView = (CardView) itemView.findViewById(R.id.standingCard);
        }
    }

    public void setStandings(ArrayList<Standing> standings) {
        this.standings = standings;
    }
}
