package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Appointment implements Serializable {
    Connect connect;
    private String time;
    private String patientName;
    private String day;
    private Object doctor;

    public Appointment( String time, String patientName, String day, Object doctor) {
        this.time = time;
        this.patientName = patientName;
        this.day = day;
        this.doctor = doctor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Object getDoctor() {
        return doctor;
    }

    public void setDoctor(Object doctor) {
        this.doctor = doctor;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return
                " Time: " + time + "\n" +
                " Patient name:" + patientName + "\n" +
                " Day:" + day +"\n"+
                " Doctor:" + doctor+"\n"+
                "__________"+"\n";
    }
}
