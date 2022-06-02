package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PersonShowActivity extends AppCompatActivity {

    private WorkersListAdapter adapter;
    DatabaseWorker databaseWorker = new DatabaseWorker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_show);

        String login = getIntent().getExtras().getString("login");
        Boolean isFiltered = getIntent().getExtras().getBoolean("isFiltered");
        Boolean none = null;
        Boolean endedMid = null;
        Boolean midSpec = null;
        Boolean hiBack = null;
        Boolean hiMag = null;
        Boolean notEndedMid = null;
        String city = null;

        if(isFiltered){
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            none = extras.getBoolean("none");
            endedMid = extras.getBoolean("endedMid");
            notEndedMid = extras.getBoolean("notEndedMid");
            midSpec = extras.getBoolean("midSpec");
            hiBack = extras.getBoolean("hiBack");
            hiMag = extras.getBoolean("hiMag");
            city = extras.getString("city");
        }

        RecyclerView showOfWorkers = findViewById(R.id.listOfWorkers);

        adapter = new WorkersListAdapter(this, login);

        Button toForm = findViewById(R.id.formButton);
        Button toFilters = findViewById(R.id.searchButton);

        toForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToForm = new Intent(getApplicationContext(), FormActivity.class);
                goToForm.putExtra("login", login);
                goToForm.putExtra("isCapitalist", true);
                goToForm.putExtra("canRedact", true);
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

        ArrayList<Worker> list = new ArrayList<>();
        if(!isFiltered){
            list = databaseWorker.getListOfAllWorkers();
        }else{
            for (Worker w:
                 databaseWorker.getListOfAllWorkers()) {
                if(w.city.equals(city) || "".equals(city) || city == null){
                    if(none){
                        list.add(w);
                    }
                    if(endedMid && w.education.equals("Среднее полное")){
                        list.add(w);
                    }
                    if(notEndedMid && w.education.equals("Среднее неполное")){
                        list.add(w);
                    }
                    if(midSpec && w.education.equals("Среднее специальное")){
                        list.add(w);
                    }
                    if(hiBack && w.education.equals("Высшее бакалавриат")){
                        list.add(w);
                    }
                    if(hiMag && w.education.equals("Высшее магистратура")){
                        list.add(w);
                    }

                }
            }
        }

        //THIS PART WILL BE CHANGED AFTER I IMPLEMENT FILTERS!!!
        adapter.setPersons(list);
        //THIS PART WILL BE CHANGED AFTER I IMPLEMENT FILTERS!!!

        showOfWorkers.setAdapter(adapter);

    }
}