package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame {
    private JLabel ad;
    private JButton checkInfo;
    private JButton listApp;
    private JButton deleteApp;
    private JButton back;

    public Admin(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(true);
        getContentPane().setBackground(new Color(44,62,80));

        ad = new JLabel("You logged in as an DOCTOR");
        ad.setBounds(40,30,400,40);
        ad.setForeground(Color.WHITE);
        ad.setFont(new java.awt.Font("Times New Roman",1,24));
        add(ad);

        checkInfo= new JButton("Patient's Information");
        checkInfo.setBounds(70,120,200,20);
        add(checkInfo);

        listApp= new JButton("List Of Appointment");
        listApp.setBounds(70,80,200,20);
        add(listApp);

        deleteApp= new JButton("Delete Appointment");
        deleteApp.setBounds(70,160,200,20);
        add(deleteApp);

        back= new JButton("BACK");
        back.setBounds(70,200,80,30);
        back.setBackground(new Color(34,167,240));
        add(back);

        checkInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CheckInfo().setVisible(true);
            }
        });

        listApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ListDocApp().setVisible(true);
            }
        });

        deleteApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new DeleteAppDoc().setVisible(true);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MainFrame().setVisible(true);
            }
        });
    }
}
