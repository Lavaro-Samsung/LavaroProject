package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeFormActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd, btnRead, btnClear , btnToFirst;
    EditText etName, etEmail , etPhone , etPassword , etJob , etSalary , etInfo , etOrganiation;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_form);

        String login = getIntent().getExtras().getString("login");
        Capitalist capitalist = new DatabaseWorker().getCapitalistByName(login);


        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etSalary = (EditText) findViewById(R.id.etSalary);
        etJob = (EditText) findViewById(R.id.etJob);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etInfo = (EditText) findViewById(R.id.etInfo);
        etOrganiation = (EditText) findViewById(R.id.etOrganization);

        etName.setText(capitalist.login);
        etEmail.setText(capitalist.mail);
        etSalary.setText(capitalist.wage);
        etJob.setText(capitalist.job);
        etPhone.setText(capitalist.phone);
        etPassword.setText(capitalist.password);
        etInfo.setText(capitalist.info);
        etOrganiation.setText(capitalist.organisation);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        String job = etJob.getText().toString();
        String salary = etSalary.getText().toString();
        String password = etPassword.getText().toString();
        String organization = etOrganiation.getText().toString();
        String info = etInfo.getText().toString();


        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

            contentValues.put(DBHelper.KEY_NAME, name);
            contentValues.put(DBHelper.KEY_MAIL, email);
            contentValues.put(DBHelper.KEY_JOB, job);
            contentValues.put(DBHelper.KEY_SALARY, salary);
            contentValues.put(DBHelper.KEY_PHONE, phone);
            contentValues.put(DBHelper.KEY_PASSWORD, password);
            contentValues.put(DBHelper.KEY_ORGANIZATION, organization);
            contentValues.put(DBHelper.KEY_INFO, info);

            new DatabaseWorker().deleteCapitalistByLogin(name);
            new DatabaseWorker().addCapitalistToADatabase(new Capitalist(name, password, info, phone, email, job, salary, organization));
            //database.insert(DBHelper.TABLE_CONTACTS_EMP, null, contentValues);
        dbHelper.close();
    }
}