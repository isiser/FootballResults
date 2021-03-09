package org.isiser.footballresults;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;

import org.isiser.footballresults.fragments.StatisticsFragment;

public class StatisticsActivity extends AppCompatActivity {
    private int selectedMatchID = 0;

    TextView txtHomeName, txtAwayName;
    ImageView imgHomeBadge, imgAwayBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        initAndGetIntent();
        initFragment();
    }

    private void initAndGetIntent(){
        txtHomeName = (TextView) findViewById(R.id.statHomeName);
        txtAwayName = (TextView) findViewById(R.id.statAwayName);
        imgHomeBadge = (ImageView) findViewById(R.id.statHomeBadge);
        imgAwayBadge = (ImageView) findViewById(R.id.statAwayBadge);

        selectedMatchID = this.getIntent().getExtras().getInt("match_id");
        txtHomeName.setText(this.getIntent().getExtras().getString("home_name"));
        txtAwayName.setText(this.getIntent().getExtras().getString("away_name"));

        Glide.with(this).asBitmap().load(this.getIntent().getExtras().getString("home_badge")).into(imgHomeBadge);
        Glide.with(this).asBitmap().load(this.getIntent().getExtras().getString("away_badge")).into(imgAwayBadge);

    }

    private void initFragment(){
        if(selectedMatchID == 0){
            return;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        StatisticsFragment statisticsFragment = new StatisticsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("selectedMatchID", selectedMatchID);
        statisticsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.containerStatistics, statisticsFragment);
        fragmentTransaction.commit();
    }
}