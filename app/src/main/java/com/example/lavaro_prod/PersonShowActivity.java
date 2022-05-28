package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonShowActivity extends AppCompatActivity {

    private MyAdapter adapter = new MyAdapter(this);
    SemiDatabaseWorker databaseWorker = new SemiDatabaseWorker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_show);

        String login = getIntent().getExtras().getString("login");

        RecyclerView showOfWorkers = findViewById(R.id.listOfWorkers);

        Button toForm = findViewById(R.id.formButton);
        Button toFilters = findViewById(R.id.searchButton);

        toForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToForm = new Intent(getApplicationContext(), FormActivity.class);
                goToForm.putExtra("login", login);
                goToForm.putExtra("isCapitalist", true);
                startActivity(goToForm);
            }
        });

        toFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToFilters = new Intent(getApplicationContext(), FiltersActivity.class);
                goToFilters.putExtra("login", login);
                startActivity(goToFilters);

            }
        });

        LinearLayoutManager linearLayout
                = new LinearLayoutManager(getApplicationContext());

        showOfWorkers.setLayoutManager(linearLayout);

        //THIS PART WILL BE CHANGED AFTER I IMPLEMENT FILTERS!!!
        adapter.setPersons(databaseWorker.getListOfAllWorkers());
        //THIS PART WILL BE CHANGED AFTER I IMPLEMENT FILTERS!!!

        showOfWorkers.setAdapter(adapter);

    }
}