package com.company;

import java.util.ArrayList;

public class DBdoctor {
    static ArrayList<Doctor> doctors = new ArrayList<>();

    static {
        doctors.add(new Doctor("Axl","Rose","psychologist","Axl","qwerty"));
        doctors.add(new Doctor("Roger","Taylor","dentist","Roger","qwerty"));
    }
}
