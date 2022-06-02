package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {
    DatabaseWorker databaseWorker = new DatabaseWorker();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Bundle extras = getIntent().getExtras();

        String login = extras.getString("login");
        Boolean isCapitalist = extras.getBoolean("isCapitalist");
        boolean canRedact = extras.getBoolean("canRedact");
        String userName;
        if(!canRedact){
            userName = extras.getString("userName");
        }else{
            userName = login;
        }

        Capitalist me = databaseWorker.getCapitalistByName(login);

        String wage = me.wage;
        String info = me.getInfo();

        TextView loginView = findViewById(R.id.loginOfCapitalist);
        TextView wageView = findViewById(R.id.wageInForm);
        TextView infoView = findViewById(R.id.infoInForm);
        TextView jobView = findViewById(R.id.jobInForm);
        TextView phoneView = findViewById(R.id.phone_num);
        TextView mailView = findViewById(R.id.mailInForm);

        loginView.setText(login + "("+ me.organisation+ ")");
        wageView.setText(wage);
        infoView.setText(info);
        jobView.setText(me.job);
        phoneView.setText(me.phone);
        mailView.setText(me.mail);

        Button back = findViewById(R.id.backFromForm);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack;
                if(isCapitalist){
                    if(canRedact){
                        goBack = new Intent(getApplicationContext(), PersonShowActivity.class);}
                    else{goBack = new Intent(getApplicationContext(), FormShowActivity.class);}}
                else{goBack = new Intent(getApplicationContext(), ChatActivity.class);}
                goBack.putExtra("login", userName);
                startActivity(goBack);
            }
        });

        Button toOthersForms = findViewById(R.id.toFormsList);

        toOthersForms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToOtherForms = new Intent(getApplicationContext(), FormShowActivity.class);
                goToOtherForms.putExtra("login", login);
                startActivity(goToOtherForms);
            }
        });
        Button edit = findViewById(R.id.editBtnInForm);

        if(!canRedact){
            edit.setVisibility(View.INVISIBLE);
            toOthersForms.setVisibility(View.INVISIBLE);
        }else{
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToLessScaryThing = new Intent(getApplicationContext(), ChangeFormActivity.class);
                    goToLessScaryThing.putExtra("login", login);
                    startActivity(goToLessScaryThing);
                }
            });
        }

    }
}