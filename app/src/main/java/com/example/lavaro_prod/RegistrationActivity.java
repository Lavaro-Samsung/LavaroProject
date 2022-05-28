package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registering);

        CheckBox isCapitalist = findViewById(R.id.capitalistCheckBox);
        CheckBox isWorker = findViewById(R.id.workerCheckBox);

        isCapitalist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isWorker.setChecked(!isWorker.isChecked());
            }
        });

        isWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCapitalist.setChecked(!isCapitalist.isChecked());
            }
        });

    }
}