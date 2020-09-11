package com.example.gadsleaderboardapp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.gadsleaderboardapp.Api.ApiInterface;
import com.example.gadsleaderboardapp.Models.Hours;
import com.example.gadsleaderboardapp.Service.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HoursViewModel extends ViewModel {

    public MutableLiveData<List<Hours>> hoursLiveData = new MutableLiveData<>();

    public void getHours(){

        RetrofitService.getINSTANCE().getHours().enqueue(new Callback<List<Hours>>() {
            @Override
            public void onResponse(Call<List<Hours>> call, Response<List<Hours>> response) {

                hoursLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Hours>> call, Throwable t) {

                hoursLiveData.setValue(null);

            }
        });

    }

}
