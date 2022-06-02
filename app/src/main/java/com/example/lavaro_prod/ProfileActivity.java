package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class ProfileActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        DatabaseWorker databaseWorker = new DatabaseWorker();

        String login = extras.getString("login");
        String info = extras.getString("info");
        Worker worker = databaseWorker.getWorkerByName(login);
        boolean isCapitalist = extras.getBoolean("isCapitalist");
        String capLogin = "";
        if(isCapitalist){
            capLogin = extras.getString("capName");
        }

        TextView loginView = findViewById(R.id.loginTextOnProfile);
        TextView infoView = findViewById(R.id.infoInProfile);
        TextView jobPrefView = findViewById(R.id.jobPref);
        TextView wagePrefView = findViewById(R.id.wagePref);
        TextView educationView = findViewById(R.id.edInProf);
        TextView educationPlaceView = findViewById(R.id.edPlaceInProf);
        TextView phoneView = findViewById(R.id.phoneInProfile);
        TextView emailView = findViewById(R.id.emailInProfile);
        TextView cityView = findViewById(R.id.cityInProfile);
        TextView workExpView = findViewById(R.id.workHistory);

        loginView.setText(login);
        infoView.setText(info);
        jobPrefView.setText("Предпочтение в работе: " + worker.job);
        wagePrefView.setText("Предпочтение в зарплате: " + worker.wage);
        educationView.setText(worker.education);
        educationPlaceView.setText(worker.educationPlace);
        phoneView.setText(worker.phone);
        emailView.setText(worker.mail);
        cityView.setText(worker.city);
        String workXP = "Опыт Работы \n";
        try{
        for (int i = 0; i < worker.workXP.length; i += 2) {
            workXP += worker.workXP[i] + ": " + worker.workXP[i+1]+ " лет \n";
        }}catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        Log.i("OPYT", workXP + "   " + Arrays.asList(worker.workXP));
        workExpView.setText(workXP);

        ImageButton back = findViewById(R.id.backFromProfile);

        String finalCapLogin = capLogin;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCapitalist){
                    Intent goToList = new Intent(getApplicationContext(), PersonShowActivity.class);
                    goToList.putExtra("login", finalCapLogin);
                    startActivity(goToList);
                }else{
                    Intent goToChat = new Intent(getApplicationContext(), ChatActivity.class);
                    goToChat.putExtra("login", login);
                    startActivity(goToChat);
                }
            }
        });

        Button edit = findViewById(R.id.edit_btn);
        if(isCapitalist){
            edit.setVisibility(View.INVISIBLE);
        }else{
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent toScaryThing = new Intent(getApplicationContext(), ChangeProfileActivity.class);
                    toScaryThing.putExtra("login", login);
                    startActivity(toScaryThing);
                }
            });
        }
        Button hire = findViewById(R.id.hire);
        if(!isCapitalist){
            hire.setVisibility(View.INVISIBLE);
        }else {
            String finalCapLogin1 = capLogin;
            hire.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    databaseWorker.addACapitalistToAWorkerByName(login, finalCapLogin1);
                }
            });

        }


    }
}