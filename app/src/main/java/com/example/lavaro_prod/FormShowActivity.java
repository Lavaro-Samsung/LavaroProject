package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class FormShowActivity extends AppCompatActivity {

    private FormsListAdapter adapter;
    private final SemiDatabaseWorker databaseWorker = new SemiDatabaseWorker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_show);

        String login = getIntent().getExtras().getString("login");

        RecyclerView showForms = findViewById(R.id.listOfOthersForms);

        adapter = new FormsListAdapter(getApplicationContext(), login);
        LinearLayoutManager linearLayout
                = new LinearLayoutManager(getApplicationContext());

        showForms.setLayoutManager(linearLayout);

        //I WILL CHANGE THIS TOO
        adapter.setPersons(databaseWorker.getListOfAllCapitalists());
        //I WILL CHANGE THIS TOO

        showForms.setAdapter(adapter);
    }
}