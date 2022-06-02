package com.example.lavaro_prod;

public class Worker extends Person {

    public String surname = "";
    public String[] capList = {};
    public String[] workXP = {};
    public String city = "";
    public String education = "";
    public String educationPlace = "";


    public Worker(String login, String password, String info, String phone, String mail, String job, String wage, String surname, String[] capList, String[] workXP, String city, String education, String educationPlace) {
        super(login, password, info, phone, mail, job, wage);
        this.surname = surname;
        this.capList = capList;
        this.workXP = workXP;
        this.city = city;
        this.education = education;
        this.educationPlace = educationPlace;
    }

    public Worker(String login, String password, String info) {
        super(login, password, info);
    }
}
