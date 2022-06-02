package com.example.lavaro_prod;

import java.util.Objects;

public abstract class Person {
    String login = "";
    String password = "";
    String info = "";
    String id;
    String phone = "";
    String mail = "";
    String job = "";

    public Person(String login, String password, String info, String phone, String mail, String job, String wage) {
        this.login = login;
        this.password = password;
        this.info = info;
        this.phone = phone;
        this.mail = mail;
        this.job = job;
        this.wage = wage;
    }

    String wage = "";

    public Person(String login, String password, String info) {
        this.login = login;
        this.password = password;
        this.info = info;
    }

    public Person() {
    }


    public String getId() {
        return id;
    }


    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


    public String getInfo() {
        return info;
    }


    public int hashCode() {
        return Objects.hash(login, password, info);
    }

    public String[] getListOfParams(){
        return null;
    };


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(login, person.login);
    }

}
