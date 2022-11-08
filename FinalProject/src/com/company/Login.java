package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {


   private JButton makeAppointment;
   private JButton ListOfAppointment;
   private JButton deleteAppointment;
   private JButton back;
   private JLabel ad;


    public Login(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(true);
        getContentPane().setBackground(new Color(44,62,80));

        ad = new JLabel("You logged in as an PATIENT");
        ad.setBounds(40,30,400,40);
        ad.setForeground(Color.WHITE);
        ad.setFont(new java.awt.Font("Times New Roman",1,24));
        add(ad);

        ListOfAppointment= new JButton("List Of Appointment");
        ListOfAppointment.setBounds(70,120,200,20);
        add(ListOfAppointment);

        makeAppointment= new JButton("Make Appointment");
        makeAppointment.setBounds(70,80,200,20);
        add(makeAppointment);

        deleteAppointment= new JButton("Delete Appointment");
        deleteAppointment.setBounds(70,160,200,20);
        add(deleteAppointment);

        back= new JButton("BACK");
        back.setBounds(70,200,80,30);
        back.setBackground(new Color(34,167,240));
        add(back);


        makeAppointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MakeApp makeApp = new MakeApp();
                makeApp.setVisible(true);
            }
        });

        ListOfAppointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ListApp listApp = new ListApp();
                listApp.setVisible(true);
            }
        });

        deleteAppointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                DeleteApp d = new DeleteApp();
                d.setVisible(true);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainFrame m = new MainFrame();
                m.setVisible(true);
            }
        });




    }


}
