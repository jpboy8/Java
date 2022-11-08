package com.company;

import java.io.Serializable;

public class Doctor implements Serializable {
    private String name;
    private String surname;
    private String specialty;
    private String log;
    private String pass;

    public Doctor(String name, String surname, String specialty, String log, String pass) {
        this.name = name;
        this.surname = surname;
        this.specialty = specialty;
        this.log = log;
        this.pass = pass;
    }

    public Doctor(String name, String surname, String specialty) {
        this.name = name;
        this.surname = surname;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return name+" "+ surname+" " + specialty;
    }
}
