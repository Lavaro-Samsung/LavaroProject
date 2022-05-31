package com.example.lavaro_prod;

import java.util.ArrayList;

public interface WorkingWithDatabase {

    public String getPasswordByLogin(String login);

    public ArrayList<Worker> getListOfAllWorkers();

    public ArrayList<Capitalist> getListOfAllCapitalists();

    public boolean isWorker(String login);

    public boolean isCapitalist(String login);

    public Worker getWorkerByName(String login);

    public Capitalist getCapitalistByName(String login);

    public boolean isLoginPresentedInAnyDatabase(String login);

    public void addWorkerToADatabase(Worker worker);

    public void addCapitalistToADatabase(Capitalist capitalist);



}

