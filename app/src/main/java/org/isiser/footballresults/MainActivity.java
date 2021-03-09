package org.isiser.footballresults;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import org.isiser.footballresults.fragments.LeaguesFragment;
import org.isiser.footballresults.models.Country;
import org.isiser.footballresults.service.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    
    private Spinner spinnerOdabirLige;

    private ArrayList<String> listCountriesView = new ArrayList();
    private ArrayList<Country> listCountriesPublic = new ArrayList<>();
    private int choosenCountry = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        initWidgets();
        getCountries();

        spinnerOdabirLige.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String countrySelected = listCountriesView.get(position);
                for(Country country : listCountriesPublic){
                    if(country.getCountry_name().equals(countrySelected))
                        choosenCountry = country.getCountry_id();
                }
                initLeaguesFragment();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        initLeaguesFragment();

    }

    private void initWidgets(){
        spinnerOdabirLige = (Spinner) findViewById(R.id.spinnerOdabirLige);
    }

    private void getCountries(){
        Log.d(TAG, "createSpinner: started");

        Call<List<Country>> callCountries= RetrofitManager.getInstance().getClient().getCountries();
        callCountries.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                Log.d(TAG, "onResponse: response" );
                List<Country> listCountries = response.body();
                setData(listCountries);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

    private void setData(List<Country> listCountries){
        for (Country a : listCountries){
            listCountriesView.add(a.getCountry_name());
            listCountriesPublic.add(a);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listCountriesView);
        spinnerOdabirLige.setAdapter(adapter);
    }

    private void initLeaguesFragment(){
        if(choosenCountry == 0){
            choosenCountry = 162;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        LeaguesFragment leaguesFragment = new LeaguesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("selectedCountry", choosenCountry);
        leaguesFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.containerLeague, leaguesFragment);
        fragmentTransaction.commit();

    }
}