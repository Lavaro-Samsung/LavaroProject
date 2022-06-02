package com.example.lavaro_prod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Locale;

public class ChangeProfileActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd, btnAddWE; // test  // test  // test  // test  // test  // test  // test
    EditText etName ,etEmail , etPlace , etYear , etAboutYou , etCity , etPhone , etEducationPlace , etPassword , etSalary, etJob , etEmp; // test  // test  // test  // test  // test  // test  // test  // test
    String allWE = "";
    String employersList = "" ;   // test  // test  // test  // test  // test  // test  // test  // test  // test  // test  // test  // test  // test
    DBHelper dbHelper;
    String phone, email ;
    Spinner education ;
    Worker worker;
    String login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
        // test  // test  // test  // test  // test  // test  // test  // test  // test

        /*
        btnEmpAdd = (Button) findViewById(R.id.btnAddEmp);
        btnEmpAdd.setOnClickListener(this); // test  */
        // test  // test  // test  // test  // test  // test  // test  // test  // test  // test
        
        login = getIntent().getExtras().getString("login");
        worker = new DatabaseWorker().getWorkerByName(login);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnAddWE = (Button) findViewById(R.id.btnAddWE);
        btnAddWE.setOnClickListener(this);
        
        
        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword) ;
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPlace = (EditText) findViewById(R.id.etPlace);
        etSalary = (EditText) findViewById(R.id.etSalary);
        etJob = (EditText) findViewById(R.id.etJob);
        etYear = (EditText) findViewById(R.id.etYear);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etCity = (EditText) findViewById(R.id.etCity);
        etAboutYou = (EditText) findViewById(R.id.etAboutYou);
        etEducationPlace = (EditText) findViewById(R.id.educationPlace);
        education =  (Spinner) findViewById(R.id.spEducation) ;

        etName.setText(worker.login);
        etPassword.setText(worker.password);
        etEmail.setText(worker.mail);
        etSalary.setText(worker.wage);
        etJob.setText(worker.job);
        etPhone.setText(worker.phone);
        etCity.setText(worker.city);
        etAboutYou.setText(worker.info);
        etEducationPlace.setText(worker.educationPlace);

        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.education,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        education.setAdapter(adapter);


        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String password = etPassword.getText().toString();
        String city = etCity.getText().toString();
        String salary = etSalary.getText().toString();
        String job = etJob.getText().toString();
        String aboutUser = etAboutYou.getText().toString();
        String educationPlace = etEducationPlace.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        switch (v.getId()) { // С помощью этого обалденного условия смотрим на какую кнопку был нажатие
            

            case R.id.btnAddWE:
                String place = etPlace.getText().toString();
                String years = etYear.getText().toString();
                String spec =  place + "qqq0006969420qqq" + years + " qqq0006969420qqq" ; // формируем строку
                allWE += spec ; // добавляем к той что для БД
                etYear.setText("");
                etPlace.setText("");
                Toast toast = Toast.makeText(this , "Опыт работы добавлен" , Toast.LENGTH_SHORT );
                toast.show();
                break;

            case R.id.btnAdd:

                if (etEmail.getText().toString().matches(".+@.+\\..+")) {  // Проверка строки на то является ли строка email адресом , я очень плохую регулярку сделал но она работает
                    email = etEmail.getText().toString();
                }else{
                    Toast toast1 = Toast.makeText(this , "Почта введена неверно" , Toast.LENGTH_LONG ); // Тут следует продумать что делать если email передан неверно
                    email = "Почта не указана.";
                    toast1.show();
                }
                if (etPhone.getText().toString().matches("^(\\+7|8)[0-9]{10,11}")) { //  Тоже регулярка не очень нужно будет по хорошему другую сделать ( скорее всего я сделаю ) , она тоже рабочая но не все ситуации для записи номера обрабатывает например 8 900 015 23 46 или  8 (904) 477 43 43  или  8-904-319-32-34        .
                    phone = etPhone.getText().toString();

                }else{ // Если номер не прошел по регулярке , значение phone ( email тоже ) попадут в БД с тестом "Телефон не указан." поэтому else нужно дописать тосты бы оставил с телефона выглядит прикольно
                    Toast toast1 = Toast.makeText(this , "Номер введен неверно" , Toast.LENGTH_LONG );
                    phone = "Телефон не указан.";
                    toast1.show();
                }
                contentValues.put(DBHelper.KEY_MAIL, email);
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_PASSWORD, password);
                contentValues.put(DBHelper.KEY_JOB, job);
                contentValues.put(DBHelper.KEY_SALARY, salary);
                contentValues.put(DBHelper.KEY_PHONE, phone);
                contentValues.put(DBHelper.KEY_CITY, city);
                contentValues.put(DBHelper.KEY_ABOUT, aboutUser);
                contentValues.put(DBHelper.KEY_EDUCATION, education.getSelectedItem().toString());
                contentValues.put(DBHelper.KEY_EDUCATION_PLACE, educationPlace);
                contentValues.put(DBHelper.KEY_WORKEXP, allWE);

                Log.i("ALWE",Arrays.asList( allWE.split("qqq0006969420qqq")).toString());
                contentValues.put(DBHelper.KEY_EMPLOYERS_LIST, employersList);  // test  // test // test // test // test // test // test

                new DatabaseWorker().deleteWorkerByLogin(login);
                new DatabaseWorker().addWorkerToADatabase(new Worker(name.toLowerCase(Locale.ROOT), password, aboutUser, phone, email, job, salary,"", worker.capList, allWE.split("qqq0006969420qqq"), city, education.getSelectedItem().toString(), educationPlace));

                //database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                break;
                

        }
        dbHelper.close();
    }




}