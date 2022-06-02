package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        DatabaseWorker databaseWorker = new DatabaseWorker();

        String workersLogin = this.getIntent().getExtras().getString("login");

        Worker thisWorker = databaseWorker.getWorkerByName(workersLogin);

        Button profile = findViewById(R.id.toProfileFromChat);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToProfileActivity = new Intent(getApplicationContext(), ProfileActivity.class);
                goToProfileActivity.putExtra("info", thisWorker.getInfo());
                goToProfileActivity.putExtra("login", workersLogin);
                goToProfileActivity.putExtra("isCapitalist", false);
                startActivity(goToProfileActivity);
            }
        });

        RecyclerView showForms = findViewById(R.id.listOfInterestedCapitalists);
        FormsListAdapter adapter = new FormsListAdapter(getApplicationContext(), workersLogin);
        LinearLayoutManager linearLayout
                = new LinearLayoutManager(getApplicationContext());

        showForms.setLayoutManager(linearLayout);

        ArrayList<Capitalist> list = new ArrayList<>();
        for (String s:
             thisWorker.capList) {
            list.add(databaseWorker.getCapitalistByName(s));
        }

        adapter.setPersons(list);

        showForms.setAdapter(adapter);

    }
}