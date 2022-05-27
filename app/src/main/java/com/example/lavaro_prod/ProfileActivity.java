package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent =this.getIntent();
        Bundle extras = intent.getExtras();

        String login = extras.getString("login");
        String info = extras.getString("info");

        TextView loginView = findViewById(R.id.loginTextOnProfile);

        TextView infoView = findViewById(R.id.informationTextOnProfile);

        loginView.setText(login);
        infoView.setText(info);


    }
}