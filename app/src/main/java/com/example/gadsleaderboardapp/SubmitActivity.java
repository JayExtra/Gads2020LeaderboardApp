package com.example.gadsleaderboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gadsleaderboardapp.Api.ApiInterface;
import com.example.gadsleaderboardapp.Models.Submit;
import com.example.gadsleaderboardapp.Service.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity {

    Dialog myDialog;

    private ImageView bckImageView , cancel;
    private EditText fNme ,sName , eMail , mLink;
    private Button submitBtn , buttonYes;

    private ApiInterface mApiInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);




        myDialog=new Dialog(this);

        //map widgets
        bckImageView = findViewById(R.id.sbmt_img);
        fNme = findViewById(R.id.first_name_text);
        sName = findViewById(R.id.second_name);
        eMail = findViewById(R.id.email_text);
        mLink = findViewById(R.id.git_link);
        submitBtn = findViewById(R.id.submit_proj_btn);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://gadsapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiInterface = retrofit.create(ApiInterface.class);


        bckImageView.setOnClickListener(view -> {
            Intent bckIntent = new Intent(SubmitActivity.this , HomeActivity.class);
            startActivity(bckIntent);
            finish();
        });

        submitBtn.setOnClickListener(view -> {

            Toast.makeText(SubmitActivity.this , "Sending..." , Toast.LENGTH_LONG).show();

            startSubmission();

          /*  myDialog.setContentView(R.layout.you_sure);
            cancel=(ImageView) myDialog.findViewById(R.id.cancel_img);
            buttonYes=(Button) myDialog.findViewById(R.id.button_yes);

            cancel.setOnClickListener(view1 -> myDialog.dismiss());

            buttonYes.setOnClickListener(view12 -> {


                myDialog.dismiss();

            });

            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();*/

        });
    }

    private void startSubmission() {

      String firstame =   fNme.getText().toString();
        String secondname =sName.getText().toString();
       String email =  eMail.getText().toString();
       String gitlink =  mLink.getText().toString();


        //Submit submission = new Submit(email,firstame,secondname ,gitlink);

        Call<Submit> call = mApiInterface.createSubmit(email ,firstame , secondname ,gitlink);
        call.enqueue(new Callback<Submit>() {
            @Override
            public void onResponse(Call<Submit> call, Response<Submit> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(SubmitActivity.this, "Submission successfull" ,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Submit> call, Throwable t) {

                Toast.makeText(SubmitActivity.this, "Submission failed"+t.getMessage() ,Toast.LENGTH_SHORT).show();


            }
        });







    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
