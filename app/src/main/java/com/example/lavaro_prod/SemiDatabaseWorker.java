package com.example.lavaro_prod;

import java.util.ArrayList;

public class SemiDatabaseWorker implements WorkingWithDatabase{

    @Override
    public String getPasswordByLogin(String login){
        for(Worker worker: SemiDatabase.kindaDatabaseOfWorkers){
            if(worker.login.equals(login)){
                return worker.password;
            }
        }
        for (Capitalist capitalist:SemiDatabase.kindaDatabaseOfCapitalists){
            if(capitalist.login.equals(login)){
                return capitalist.password;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Worker> getListOfAllWorkers() {
        return SemiDatabase.kindaDatabaseOfWorkers;
    }

    @Override
    public Worker getWorkerByNumberInList(int number) {
        return SemiDatabase.kindaDatabaseOfWorkers.get(number);
    }

    @Override
    public boolean isWorker(String login) {
        boolean result = false;

        for (Worker worker: SemiDatabase.kindaDatabaseOfWorkers) {
            if (worker.getLogin().equals(login)){
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean isCapitalist(String login) {
        boolean result = false;

        for (Capitalist capitalist: SemiDatabase.kindaDatabaseOfCapitalists) {
            if (capitalist.getLogin().equals(login)){
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public Worker getWorkerByName(String login) {
        Worker result = null;
        for (Worker worker: SemiDatabase.kindaDatabaseOfWorkers) {
            if (worker.getLogin().equals(login)){
                result = worker;
                break;
            }
        }
        return result;
    }

    @Override
    public Capitalist getCapitalistByName(String login) {
        Capitalist result = null;

        for (Capitalist capitalist: SemiDatabase.kindaDatabaseOfCapitalists) {
            if (capitalist.getLogin().equals(login)){
                result = capitalist;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean isLoginPresentedInAnyDatabase(String login) {
        return (getPasswordByLogin(login) != null);
    }

    @Override
    public void addWorkerToADatabase(Worker worker) {
        SemiDatabase.kindaDatabaseOfWorkers.add(worker);
    }

    @Override
    public void addCapitalistToADatabase(Capitalist capitalist) {
        SemiDatabase.kindaDatabaseOfCapitalists.add(capitalist);
    }

}

