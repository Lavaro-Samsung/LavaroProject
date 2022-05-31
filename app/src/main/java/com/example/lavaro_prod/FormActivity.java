package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {
    SemiDatabaseWorker databaseWorker = new SemiDatabaseWorker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Bundle extras = getIntent().getExtras();

        String login = extras.getString("login");
        Boolean isCapitalist = extras.getBoolean("isCapitalist");
        Boolean canRedact = extras.getBoolean("canRedact");
        String userName;
        if(!canRedact){
            userName = extras.getString("userName");
        }else{
            userName = login;
        }

        Capitalist me = databaseWorker.getCapitalistByName(login);

        String wage = me.getWage();
        String info = me.getInfo();

        TextView loginView = findViewById(R.id.loginOfCapitalist);
        TextView wageView = findViewById(R.id.wageInForm);
        TextView infoView = findViewById(R.id.infoInForm);

        loginView.setText(login);
        wageView.setText(wage);
        infoView.setText(info);

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



    }
}