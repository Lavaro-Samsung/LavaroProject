package com.example.lavaro_prod;

public class Capitalist extends Person{

   private String wage;

    public Capitalist(String login, String password, String info) {
        this.login = login;
        this.password = password;
        this.info = info;
    }

    public String getWage() {
        return wage;
    }
}
