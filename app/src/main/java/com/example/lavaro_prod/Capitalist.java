package com.example.lavaro_prod;

public class Capitalist extends Person{

    public String organisation = "";

    public Capitalist(String login, String password, String info, String phone, String mail, String job, String wage, String organisation) {
        super(login, password, info, phone, mail, job, wage);
        this.organisation = organisation;
    }

    public Capitalist(String login, String password, String info) {
        super(login, password, info);
    }
}
