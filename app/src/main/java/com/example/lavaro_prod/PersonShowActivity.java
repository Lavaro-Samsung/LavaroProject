package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PersonShowActivity extends AppCompatActivity {

    private MyAdapter adapter = new MyAdapter(this);
    SemiDatabaseWorker databaseWorker = new SemiDatabaseWorker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_show);

        RecyclerView showOfWorkers = findViewById(R.id.listOfWorkers);

        LinearLayoutManager linearLayout
                = new LinearLayoutManager(getApplicationContext());

        showOfWorkers.setLayoutManager(linearLayout);

        //THIS PART WILL BE CHANGED AFTER I IMPLEMENT FILTERS!!!
        adapter.setPersons(databaseWorker.getListOfAllWorkers());
        //THIS PART WILL BE CHANGED AFTER I IMPLEMENT FILTERS!!!

        showOfWorkers.setAdapter(adapter);

    }
}