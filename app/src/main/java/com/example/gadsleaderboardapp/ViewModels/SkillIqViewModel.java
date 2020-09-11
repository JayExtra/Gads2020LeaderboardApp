package com.example.gadsleaderboardapp.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadsleaderboardapp.Models.Hours;
import com.example.gadsleaderboardapp.Models.Skill;
import com.example.gadsleaderboardapp.Service.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIqViewModel extends ViewModel {

    public MutableLiveData<List<Skill>> skillLiveData = new MutableLiveData<>();

    public void getSkillIq(){

        RetrofitService.getINSTANCE().getSkillIq().enqueue(new Callback<List<Skill>>() {
            @Override
            public void onResponse(Call<List<Skill>> call, Response<List<Skill>> response) {

                skillLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Skill>> call, Throwable t) {

                skillLiveData.setValue(null);

            }
        });




    }
}
