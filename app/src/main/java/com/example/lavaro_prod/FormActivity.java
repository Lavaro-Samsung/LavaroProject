package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {
    SemiDatabaseWorker databaseWorker = new SemiDatabaseWorker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        String login = getIntent().getExtras().getString("login");

        Capitalist me = databaseWorker.getCapitalistByName(login);

        String wage = me.getWage();

        String info = me.getInfo();

        TextView wageView = findViewById(R.id.wageInForm);
        TextView infoView = findViewById(R.id.infoInForm);

        wageView.setText(wage);
        infoView.setText(info);



    }
}