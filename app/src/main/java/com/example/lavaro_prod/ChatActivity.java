package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        SemiDatabaseWorker databaseWorker = new SemiDatabaseWorker();

        String workersLogin = this.getIntent().getExtras().getString("login");

        Worker thisWorker = databaseWorker.getWorkerByName(workersLogin);

        Button profile = findViewById(R.id.toProfileFromChat);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ChatActivity.this, "You are" + workersLogin, Toast.LENGTH_SHORT).show();
                Intent goToProfileActivity = new Intent(getApplicationContext(), ProfileActivity.class);
                goToProfileActivity.putExtra("info", thisWorker.getInfo());
                goToProfileActivity.putExtra("login", workersLogin);
                startActivity(goToProfileActivity);
            }
        });

    }
}