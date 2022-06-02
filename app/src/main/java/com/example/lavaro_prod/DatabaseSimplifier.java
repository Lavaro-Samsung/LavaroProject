package com.example.lavaro_prod;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DatabaseSimplifier {

    public static ArrayList<Worker> fetchAllWorkers(DBHelper dataBaseHelper) {
        ArrayList<Worker> result = new ArrayList<>();

        SQLiteDatabase database = dataBaseHelper.getReadableDatabase();

        String[] columns = DBHelper.ALL_WORKERS_COLUMNS;

        @SuppressLint("Recycle") Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, columns, null, null, null, null, null);
        int idPos = cursor.getColumnIndex(DBHelper.KEY_ID);
        int namePos = cursor.getColumnIndex(DBHelper.KEY_NAME);
        int passPos = cursor.getColumnIndex(DBHelper.KEY_PASSWORD);
        int surnamePos = cursor.getColumnIndex(DBHelper.KEY_SURNAME);
        int phonePos = cursor.getColumnIndex(DBHelper.KEY_PHONE);
        int aboutPos = cursor.getColumnIndex(DBHelper.KEY_ABOUT);
        int cityPos = cursor.getColumnIndex(DBHelper.KEY_CITY);
        int workexpPos = cursor.getColumnIndex(DBHelper.KEY_WORKEXP);
        int mailPos = cursor.getColumnIndex(DBHelper.KEY_MAIL);
        int educationPlacePos = cursor.getColumnIndex(DBHelper.KEY_EDUCATION_PLACE);
        int educationPos = cursor.getColumnIndex(DBHelper.KEY_EDUCATION);
        int capListPos = cursor.getColumnIndex(DBHelper.KEY_EMPLOYERS_LIST);
        int jobPos = cursor.getColumnIndex(DBHelper.KEY_JOB);
        int wagePos = cursor.getColumnIndex(DBHelper.KEY_SALARY);

        while (cursor.moveToNext()) {
            String name = cursor.getString(namePos);
            String password = cursor.getString(passPos);
            String surname = cursor.getString(surnamePos);
            String phone = cursor.getString(phonePos);
            String about = cursor.getString(aboutPos);
            String city = cursor.getString(cityPos);
            String workexp = cursor.getString(workexpPos);
            String mail = cursor.getString(mailPos);
            String educationPlace = cursor.getString(educationPlacePos);
            String education = cursor.getString(educationPos);
            String capList = cursor.getString(capListPos);
            String job = cursor.getString(jobPos);
            String wage = cursor.getString(wagePos);

            result.add(new Worker(name, password, about, phone, mail, job, wage, surname, capList.split("\\|"), workexp.split("\\|"), city, education, educationPlace));

        }

        return result;
    }

    public static ArrayList<Capitalist> fetchAllCapitalists(DBHelper dataBaseHelper){
        ArrayList<Capitalist> result = new ArrayList<>();
        SQLiteDatabase database = dataBaseHelper.getReadableDatabase();
        String[] columns = DBHelper.ALL_CAPITALISTS_COLUMNS;
        @SuppressLint("Recycle") Cursor cursor = database.query(DBHelper.TABLE_CONTACTS_EMP, columns, null, null, null, null, null);

        int idPos = cursor.getColumnIndex(DBHelper.KEY_ID);
        int namePos = cursor.getColumnIndex(DBHelper.KEY_NAME);
        int passPos = cursor.getColumnIndex(DBHelper.KEY_PASSWORD);
        int phonePos = cursor.getColumnIndex(DBHelper.KEY_PHONE);
        int infoPos = cursor.getColumnIndex(DBHelper.KEY_INFO);
        int mailPos = cursor.getColumnIndex(DBHelper.KEY_MAIL);
        int orgPos = cursor.getColumnIndex(DBHelper.KEY_ORGANIZATION);
        int jobPos = cursor.getColumnIndex(DBHelper.KEY_JOB);
        int wagePos = cursor.getColumnIndex(DBHelper.KEY_SALARY);

        while (cursor.moveToNext()){
            String name = cursor.getString(namePos);
            String password = cursor.getString(passPos);
            String phone = cursor.getString(phonePos);
            String info = cursor.getString(infoPos);
            String mail = cursor.getString(mailPos);
            String job = cursor.getString(jobPos);
            String wage = cursor.getString(wagePos);
            String org = cursor.getString(orgPos);

            result.add(new Capitalist(name, password, phone, info, mail, job, wage, org));

        }
        return result;

    }


}
