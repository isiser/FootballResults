package org.isiser.footballresults.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    static private RetrofitManager instance;
    private RetrofitClient client;

    private RetrofitManager()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apiv2.apifootball.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        client=retrofit.create(RetrofitClient.class);
    }

    public static RetrofitManager getInstance()
    {
        if(instance == null)
        {
            instance = new RetrofitManager();
        }
        return instance;
    }

    public RetrofitClient getClient()
    {
        return client;
    }
}
