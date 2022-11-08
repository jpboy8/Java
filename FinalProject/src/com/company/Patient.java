package com.company;

public class Patient {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String dateOfBirth;

    public Patient(String name, String surname, String phoneNumber, String email, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "surname: " + surname + "\n" +
                "phoneNumber: " + phoneNumber + "\n" +
                "email: " + email + "\n" +
                "dateOfBirth: " + dateOfBirth+"\n";
    }
}
