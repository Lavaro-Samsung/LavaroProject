package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private EditText loginText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        loginButton = findViewById(R.id.logInButton);
        registerButton = findViewById(R.id.registerButton);
        loginText = findViewById(R.id.loginEdit);
        passwordText = findViewById(R.id.passwordEdit);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String insertedLogin = loginText.getText().toString().toLowerCase(Locale.ROOT);
                String insertedPassword = passwordText.getText().toString();
                SemiDatabaseWorker databaseWorker= new SemiDatabaseWorker();

                if(insertedLogin.equals("")){
                    Toast.makeText(getApplicationContext(), "Insert Login", Toast.LENGTH_LONG).show();
                    Log.i("PASS", "Login is not inserted");
                    return;
                }
                if(insertedPassword.equals("")){
                    Toast.makeText(getApplicationContext(), "Insert Password", Toast.LENGTH_LONG).show();
                    Log.i("PASS", "Password is not inserted");
                    return;
                }

                String realPassword = databaseWorker.getPasswordByLogin(insertedLogin);

                if (realPassword == null) {
                    Toast.makeText(getApplicationContext(), "Wrong Login", Toast.LENGTH_LONG).show();
                    Log.i("PASS", "Login is wrong");
                    return;
                }

                if(insertedPassword.equals(realPassword)){
                    Toast.makeText(getApplicationContext(), "Right Password", Toast.LENGTH_LONG).show();
                    Log.i("PASS", "Password is right");
                    if(databaseWorker.isCapitalist(insertedLogin)){
                        Intent goToShowingActivity = new Intent(getApplicationContext(), PersonShowActivity.class);
                        goToShowingActivity.putExtra("login" , insertedLogin);
                        startActivity(goToShowingActivity);}
                    else if(databaseWorker.isWorker(insertedLogin)){
                        Intent goToChatActivity = new Intent(getApplicationContext(), ChatActivity.class);
                        goToChatActivity.putExtra("login" , insertedLogin);
                        startActivity(goToChatActivity);
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();
                    Log.i("PASS", "The Password is wrong");
                }

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegistration = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(goToRegistration);
            }
        });

    }
}