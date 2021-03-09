package org.isiser.footballresults;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.isiser.footballresults.adapters.ViewPagerAdapter;
import org.isiser.footballresults.fragments.MatchesFragment;
import org.isiser.footballresults.fragments.StandingsFragment;

import java.util.ArrayList;

public class LeagueActivity extends AppCompatActivity {
    private static final String TAG = "LeagueActivity";

    private int selectedLeagueID = 0;

    private TextView txtNameOfLeague;
    private TabLayout tableLayout;
    private ViewPager fragmentViewPager;

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

        initViews();

        selectedLeagueID = this.getIntent().getExtras().getInt("league_id");
        txtNameOfLeague.setText(this.getIntent().getExtras().getString("league_name"));

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        fragmentViewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(fragmentViewPager);

        ArrayList<Fragment> fragments = new ArrayList<>();


        //prvi fragment
        MatchesFragment matchesFragment = new MatchesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("selectedLeagueID", selectedLeagueID);
        matchesFragment.setArguments(bundle);
        fragments.add(matchesFragment);

        //drugi fragment
        StandingsFragment standingsFragment = new StandingsFragment();
        Bundle bundleTwo = new Bundle();
        bundleTwo.putInt("selectedLeagueID", selectedLeagueID);
        standingsFragment.setArguments(bundleTwo);
        fragments.add(standingsFragment);

        adapter.setFragments(fragments);

    }

    private void initViews(){
        Log.d(TAG, "initViews: created");
        txtNameOfLeague = (TextView) findViewById(R.id.nameOfLeague);
        tableLayout = (TabLayout) findViewById(R.id.tabLayoutFragments);
        fragmentViewPager = (ViewPager) findViewById(R.id.fragmentsViewpager);
    }
}