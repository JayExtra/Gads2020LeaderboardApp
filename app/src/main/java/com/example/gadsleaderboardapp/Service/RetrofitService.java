package com.example.gadsleaderboardapp.Service;

import com.example.gadsleaderboardapp.Api.ApiInterface;
import com.example.gadsleaderboardapp.Models.Hours;
import com.example.gadsleaderboardapp.Models.Skill;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    private ApiInterface mApiInterface;
    private static RetrofitService INSTANCE;

    public  RetrofitService(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiInterface = retrofit.create(ApiInterface.class);


    }

    public static RetrofitService getINSTANCE() {

        if(null == INSTANCE){
            INSTANCE = new RetrofitService();
        }
        return INSTANCE;
    }


    public Call<List<Hours>> getHours(){

        return mApiInterface.getHours();
    }

    public Call<List<Skill>> getSkillIq(){
        return  mApiInterface.getSkillIq();
    }
}
