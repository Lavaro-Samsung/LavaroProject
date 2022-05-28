package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FiltersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        String login = getIntent().getExtras().getString("login");

        Button back = findViewById(R.id.backToListOfWorkersFromFilters);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToShowingActivity = new Intent(getApplicationContext(), PersonShowActivity.class);
                goToShowingActivity.putExtra("login" , login);
                startActivity(goToShowingActivity);
            }
        });

    }
}