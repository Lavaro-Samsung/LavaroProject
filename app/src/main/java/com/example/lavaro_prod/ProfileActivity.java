package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String login = extras.getString("login");
        String info = extras.getString("info");
        boolean isCapitalist = extras.getBoolean("isCapitalist");
        String capLogin = "";
        if(isCapitalist){
            capLogin = extras.getString("capName");
        }

        TextView loginView = findViewById(R.id.loginTextOnProfile);

        TextView infoView = findViewById(R.id.informationTextOnProfile);

        loginView.setText(login);
        infoView.setText(info);

        ImageButton back = findViewById(R.id.backFromProfile);

        String finalCapLogin = capLogin;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCapitalist){
                    Intent goToList = new Intent(getApplicationContext(), PersonShowActivity.class);
                    goToList.putExtra("login", finalCapLogin);
                    startActivity(goToList);
                }else{
                    Intent goToChat = new Intent(getApplicationContext(), ChatActivity.class);
                    goToChat.putExtra("login", login);
                    startActivity(goToChat);
                }
            }
        });
    }
}