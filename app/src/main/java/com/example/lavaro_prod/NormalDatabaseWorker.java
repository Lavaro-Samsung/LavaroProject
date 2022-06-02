package com.example.lavaro_prod;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NormalDatabaseWorker implements WorkingWithDatabase{

    public NormalDatabaseWorker(DBHelper databaseHelper){
        this.databaseHelper = databaseHelper;
    }

    private final DBHelper databaseHelper;


    @Override
    public String getPasswordByLogin(String login) {
        return null;
    }

    @Override
    public ArrayList<Worker> getListOfAllWorkers() {
        return null;
    }

    @Override
    public ArrayList<Capitalist> getListOfAllCapitalists() {
        return null;
    }

    @Override
    public boolean isWorker(String login) {
        return false;
    }

    @Override
    public boolean isCapitalist(String login) {
        return false;
    }

    @Override
    public Worker getWorkerByName(String login) {
        return null;
    }

    @Override
    public Capitalist getCapitalistByName(String login) {
        return null;
    }

    @Override
    public boolean isLoginPresentedInAnyDatabase(String login) {
        return false;
    }

    @Override
    public void addWorkerToADatabase(Worker worker) {
//        SQLiteDatabase db = databaseHelper.getWritableDatabase();
//        String workexp = "";
//        for (String s:
//             worker.workXP) {
//            workexp += s;
//            workexp += "|";
//        }
//
//        String capString = "";
//        for (String s:
//             worker.capList) {
//            capString += s;
//            capString += "|";
//        }
//
//        String values = "";
//        String[] valuesList = { worker.city,worker.login, worker.surname,worker.password,worker.mail,worker.phone,worker.job,worker.wage,worker.educationPlace,worker.education,workexp,capString };
//        for (int i = 0; i < 11; i++) {
//            values += valuesList[i] + ", "
//        }
//
//        db.execSQL("INSERT INTO " + DBHelper.TABLE_CONTACTS + " VALUES (" +values+");");
    }

    @Override
    public void addCapitalistToADatabase(Capitalist capitalist) {

    }

    @Override
    public void deleteWorkerByLogin(String login) {

    }

    @Override
    public void deleteCapitalistByLogin(String login) {

    }

    @Override
    public void addACapitalistToAWorkerByName(String loginOfWorker, String loginOfCapitalist) {

    }
}
