package org.isiser.footballresults;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import org.isiser.footballresults.fragments.PlayersFragment;

public class PlayersActivity extends AppCompatActivity {

    private static final String TAG = "PlayersActivity";

    private int selectedTeamID = 0;
    private TextView txtNameOfTeam;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        initAndGetIntent();
        initFragment();


    }

    private void initAndGetIntent(){
        txtNameOfTeam = (TextView) findViewById(R.id.nameOfTeam);
        selectedTeamID = this.getIntent().getExtras().getInt("team_id");
        txtNameOfTeam.setText(this.getIntent().getExtras().getString("team_name"));
    }

    private void initFragment(){
        if(selectedTeamID == 0){
            return;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        PlayersFragment playersFragment = new PlayersFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("selectedTeamID", selectedTeamID);
        playersFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.containerPlayers, playersFragment);
        fragmentTransaction.commit();
    }

}