package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {
    SemiDatabaseWorker databaseWorker = new SemiDatabaseWorker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Bundle extras = getIntent().getExtras();

        String login = extras.getString("login");
        Boolean isCapitalist = extras.getBoolean("isCapitalist");
        Capitalist me = databaseWorker.getCapitalistByName(login);

        String wage = me.getWage();

        String info = me.getInfo();

        TextView wageView = findViewById(R.id.wageInForm);
        TextView infoView = findViewById(R.id.infoInForm);

        wageView.setText(wage);
        infoView.setText(info);

        Button back = findViewById(R.id.backToListOfWorkersFromForm);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack;
                if(isCapitalist){goBack = new Intent(getApplicationContext(), PersonShowActivity.class);}
                else{goBack = new Intent(getApplicationContext(), ChatActivity.class);}
                goBack.putExtra("login", login);
                startActivity(goBack);
            }
        });



    }
}