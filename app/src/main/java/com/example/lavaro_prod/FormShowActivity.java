package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormShowActivity extends AppCompatActivity {

    private final DatabaseWorker databaseWorker = new DatabaseWorker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_show);

        String login = getIntent().getExtras().getString("login");

        RecyclerView showForms = findViewById(R.id.listOfOthersForms);

        Button back = findViewById(R.id.backFromFormsShowingActivity);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(getApplicationContext(), FormActivity.class);
                goBack.putExtra("login", login);
                goBack.putExtra("canRedact", true);
                goBack.putExtra("isCapitalist", true);
                startActivity(goBack);
            }
        });

        FormsListAdapter adapter = new FormsListAdapter(getApplicationContext(), login);
        LinearLayoutManager linearLayout
                = new LinearLayoutManager(getApplicationContext());

        showForms.setLayoutManager(linearLayout);

        adapter.setPersons(databaseWorker.getListOfAllCapitalists());

        showForms.setAdapter(adapter);
    }
}