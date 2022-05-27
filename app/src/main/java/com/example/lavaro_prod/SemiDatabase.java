package com.example.lavaro_prod;

import java.util.*;
public class SemiDatabase {

    public static ArrayList<Worker> kindaDatabaseOfWorkers = new ArrayList<>();
    static {
        kindaDatabaseOfWorkers.add(new Worker("oler3229", "aaa", "Pi Sonic programmer"));
        kindaDatabaseOfWorkers.add(new Worker("juryk", "bbb", "zlataa praha je dobraa"));
        kindaDatabaseOfWorkers.add(new Worker("rose_s", "Karl Marx", "Teacher"));
        kindaDatabaseOfWorkers.add(new Worker("worker4", "A_4Bastard", "Kachock"));
    }
    public static ArrayList<Capitalist> kindaDatabaseOfCapitalists = new ArrayList<>();
    static {
        kindaDatabaseOfCapitalists.add(new Capitalist("krupp", "Adolf Hitler", "Gutt mit uns"));
        kindaDatabaseOfCapitalists.add(new Capitalist("deripaska", "CaPiTaLiSm JoY FuCkInG GoOd!!!", "I have a lot of aluminium"));
        kindaDatabaseOfCapitalists.add(new Capitalist("deliveryclub", "cccaaa", "Свободу Кириллу Украинцеву! Бойкот Деливери Клаб!"));
        kindaDatabaseOfCapitalists.add(new Capitalist("capitalist4", "F_O453advsn", "Kachock"));
    }

}
