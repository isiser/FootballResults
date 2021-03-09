package org.isiser.footballresults.adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.isiser.footballresults.R;
import org.isiser.footballresults.fragments.PlayerInfoDialogFragment;
import org.isiser.footballresults.models.Player;

import java.util.ArrayList;

public class PlayersByTeamAdapter extends RecyclerView.Adapter<PlayersByTeamAdapter.ViewHolder>{
    private static final String TAG = "PlayersByTeamAdapter";

    private ArrayList<Player> players = new ArrayList<>();
    private Context context;

    public PlayersByTeamAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_players_rec_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: started");

        // Objekt player za prikaz informacija
        String playerKey = players.get(position).getPlayer_key();
        Player playerInfoPomocni = new Player();
        for (Player p : players){
            if(p.getPlayer_key().equals(playerKey))
                playerInfoPomocni = p;
        }
        final Player playerInfo = playerInfoPomocni;

        holder.txtNameOfPlayer.setText(players.get(position).getPlayer_name());
        holder.txtNumberOfPlayer.setText("#" + Integer.toString(players.get(position).getPlayer_number()));
        holder.cardViewPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PlayerInfoDialogFragment dialogFragment = new PlayerInfoDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("playerInfo", playerInfo);
                dialogFragment.setArguments(bundle);
                dialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "Player info");

            }
        });
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtNameOfPlayer, txtNumberOfPlayer;

        private CardView cardViewPlayer;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNameOfPlayer = (TextView) itemView.findViewById(R.id.txtPlayersName);
            txtNumberOfPlayer = (TextView) itemView.findViewById(R.id.txtPlayersNumber);

            cardViewPlayer = (CardView) itemView.findViewById(R.id.playersCard);
        }
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
