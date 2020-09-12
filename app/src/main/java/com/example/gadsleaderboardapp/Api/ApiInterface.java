package com.example.gadsleaderboardapp.Api;

import com.example.gadsleaderboardapp.Models.Hours;
import com.example.gadsleaderboardapp.Models.Skill;
import com.example.gadsleaderboardapp.Models.Submit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("api/hours")
    public Call<List<Hours>> getHours();

    @GET("api/skilliq")
    public Call<List<Skill>> getSkillIq();

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<Submit> createSubmit(
            @Field("entry.1824927963")String emailAddress,
            @Field("entry.1877115667")String firstname,
            @Field("entry.2006916086") String lastName,
            @Field("entry.284483984") String linkToProject
    );
}
