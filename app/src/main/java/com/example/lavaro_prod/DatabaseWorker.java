package com.example.lavaro_prod;

import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseWorker implements WorkingWithDatabase {

    @Override
    public String getPasswordByLogin(String login) {
        for (Worker worker : SemiDatabase.kindaDatabaseOfWorkers) {
            if (worker.login.equals(login)) {
                return worker.password;
            }
        }
        for (Capitalist capitalist : SemiDatabase.kindaDatabaseOfCapitalists) {
            if (capitalist.login.equals(login)) {
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
    public ArrayList<Capitalist> getListOfAllCapitalists() {
        return SemiDatabase.kindaDatabaseOfCapitalists;
    }

    @Override
    public boolean isWorker(String login) {
        boolean result = false;

        for (Worker worker : SemiDatabase.kindaDatabaseOfWorkers) {
            if (worker.getLogin().equals(login)) {
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean isCapitalist(String login) {
        boolean result = false;

        for (Capitalist capitalist : SemiDatabase.kindaDatabaseOfCapitalists) {
            if (capitalist.getLogin().equals(login)) {
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public Worker getWorkerByName(String login) {
        Worker result = null;
        for (Worker worker : SemiDatabase.kindaDatabaseOfWorkers) {
            if (worker.getLogin().equals(login)) {
                result = worker;
                break;
            }
        }
        return result;
    }

    @Override
    public Capitalist getCapitalistByName(String login) {
        Capitalist result = new Capitalist("aaaaaa", "aaaaa", "aaaa");

        for (Capitalist capitalist : SemiDatabase.kindaDatabaseOfCapitalists) {
            if (capitalist.getLogin().equals(login)) {
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

    @Override
    public void deleteWorkerByLogin(String login) {
        for (Worker w :
                SemiDatabase.kindaDatabaseOfWorkers) {
            if (w.login.equals(login)) {
                SemiDatabase.kindaDatabaseOfWorkers.remove(w);
                break;
            }
        }
    }
    @Override
    public void deleteCapitalistByLogin(String login) {
        for (Capitalist c :
                SemiDatabase.kindaDatabaseOfCapitalists) {
            if (c.login.equals(login)) {
                SemiDatabase.kindaDatabaseOfCapitalists.remove(c);
                break;
            }
        }
    }

    @Override
    public void addACapitalistToAWorkerByName(String loginOfWorker, String loginOfCapitalist) {
        for (Worker w :
                SemiDatabase.kindaDatabaseOfWorkers) {
            if (w.login.equals(loginOfWorker)) {
                String[] a = new String[w.capList.length + 1];
                System.arraycopy(w.capList, 0, a, 0, a.length - 1);
                a[a.length - 1] = loginOfCapitalist;
                w.capList = a;
                break;
            }
        }
    }
}




