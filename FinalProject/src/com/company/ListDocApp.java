package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.String.valueOf;

public class ListDocApp extends JFrame {
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    private JComboBox doctors;
    private JLabel JLdoc;
    private JTextArea area;
    private JButton show;
    private JButton back;



    public ListDocApp(){
        connection= Connect.ConnectDB();
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(44,62,80));

        doctors = new JComboBox(DBdoctor.doctors.toArray());
        doctors.setBounds(150,40,170,20);
        add(doctors);

        JLdoc = new JLabel("Choose doctor");
        JLdoc.setBounds(30,40,100,20);
        JLdoc.setForeground(Color.WHITE);
        JLdoc.setFont(new java.awt.Font("Times New Roman",1,15));
        add(JLdoc);

        area = new JTextArea();
        area.setBounds(10,90,350,200);
        area.setBackground(new Color(108,122,137));
        add(area);

        show = new JButton("SHOW");
        show.setBounds(10,300,80,30);
        show.setBackground(new Color(34,167,240));
        add(show);

        back = new JButton("BACK");
        back.setBounds(95,300,80,30);
        back.setBackground(new Color(34,167,240));
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Admin().setVisible(true);
            }
        });
        ArrayList<Appointment> appointments = new ArrayList<>();

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM appointments");
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()){
                        Object doctor = resultSet.getObject("Doctor");
                        String time = resultSet.getString("time");
                        String patientName = resultSet.getString("patientName");
                        String day = valueOf(resultSet.getString("day"));

                        appointments.add(new Appointment(time,patientName,day,doctor));
                    }


                    for (int i = 0; i < appointments.size(); i++) {
                        String d = String.valueOf(doctors.getSelectedItem());
                        String a= String.valueOf(appointments.get(i).getDoctor());
                        if(a.equals(d)){

                            area.append(appointments.get(i).toString());

                        }

                    }
                    statement.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });


    }
}
