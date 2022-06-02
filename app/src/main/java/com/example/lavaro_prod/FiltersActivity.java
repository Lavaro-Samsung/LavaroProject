package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class FiltersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        String login = getIntent().getExtras().getString("login");

        Button back = findViewById(R.id.backToListOfWorkersFromFilters);

        CheckBox none = findViewById(R.id.nothing);
        CheckBox notEndedMid = findViewById(R.id.semiMid);
        CheckBox endedMid = findViewById(R.id.midFull);
        CheckBox midSpec = findViewById(R.id.midSpec);
        CheckBox hiBack = findViewById(R.id.hiBack);
        CheckBox hiMag = findViewById(R.id.hiMag);
        TextView cityView =findViewById(R.id.cityInFilters);

        none.setChecked(true);

        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notEndedMid.setChecked(false);
                endedMid.setChecked(false);
                midSpec.setChecked(false);
                hiBack.setChecked(false);
                hiMag.setChecked(false);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToShowingActivity = new Intent(getApplicationContext(), PersonShowActivity.class);
                goToShowingActivity.putExtra("login" , login);
                goToShowingActivity.putExtra("isFiltered", true);
                goToShowingActivity.putExtra("none", none.isChecked());
                goToShowingActivity.putExtra("endedMid", endedMid.isChecked());
                goToShowingActivity.putExtra("notEndedMid", notEndedMid.isChecked());
                goToShowingActivity.putExtra("midSpec", midSpec.isChecked());
                goToShowingActivity.putExtra("hiBack", hiBack.isChecked());
                goToShowingActivity.putExtra("hiMag", hiMag.isChecked());
                goToShowingActivity.putExtra("city", cityView.getText().toString());
                startActivity(goToShowingActivity);
            }
        });

    }
}