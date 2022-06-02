package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registering);

        DatabaseWorker databaseWorker = new DatabaseWorker();

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

        EditText loginView = findViewById(R.id.newLogin);
        EditText passwordView = findViewById(R.id.newPassword);

        Button continueReg = findViewById(R.id.continueRegistrationButton);

        Button backButton = findViewById(R.id.backFromRegistration);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });

        continueReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String insertedLogin = loginView.getText().toString();
                String insertedPassword = passwordView.getText().toString();
                if(insertedLogin.equals("")){
                    Toast.makeText(RegistrationActivity.this, "Insert Login", Toast.LENGTH_SHORT).show();
                }else if(insertedPassword.equals("")){
                    Toast.makeText(RegistrationActivity.this, "Insert password", Toast.LENGTH_SHORT).show();
                }else if(databaseWorker.isLoginPresentedInAnyDatabase(insertedLogin)){
                    Toast.makeText(RegistrationActivity.this, "This Login Already Exists", Toast.LENGTH_SHORT).show();
                }else if (isWorker.isChecked()){
                    databaseWorker.addWorkerToADatabase(new Worker(insertedLogin, insertedPassword, ""));
                    Intent back = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(back);
                }else if(isCapitalist.isChecked()){
                    databaseWorker.addCapitalistToADatabase(new Capitalist(insertedLogin, insertedPassword, ""));
                    Intent back = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(back);
                }
            }
        });

    }
}