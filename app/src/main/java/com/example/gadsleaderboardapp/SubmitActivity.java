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

public class SubmitActivity extends AppCompatActivity {

    Dialog myDialog;

    private ImageView bckImageView , cancel;
    private EditText fNme ,sName , eMail , mLink;
    private Button submitBtn , buttonYes;

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


        bckImageView.setOnClickListener(view -> {
            Intent bckIntent = new Intent(SubmitActivity.this , HomeActivity.class);
            startActivity(bckIntent);
            finish();
        });

        submitBtn.setOnClickListener(view -> {

            myDialog.setContentView(R.layout.you_sure);
            cancel=(ImageView) myDialog.findViewById(R.id.cancel_img);
            buttonYes=(Button) myDialog.findViewById(R.id.button_yes);

            cancel.setOnClickListener(view1 -> myDialog.dismiss());

            buttonYes.setOnClickListener(view12 -> {

               startSubmission();
                myDialog.dismiss();

            });

            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();

        });
    }

    private void startSubmission() {


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
