package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ListApp extends JFrame {

    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    private JTextArea area;
    private JLabel JLname;
    private JTextField txtName;
    private JButton JBlist;
    private JButton JBback;

    public ListApp(){

        connection= Connect.ConnectDB();

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(44,62,80));


        area = new JTextArea();
        area.setBounds(10,70,350,200);
        area.setBackground(new Color(108,122,137));
        add(area);

        JLname = new JLabel("Name:");
        JLname.setForeground(Color.WHITE);
        JLname.setFont(new java.awt.Font("Times New Roman",1,18));
        JLname.setBounds(10,20,80,20);
        add(JLname);

        txtName = new JTextField();
        txtName.setForeground(Color.white);
        txtName.setFont(new java.awt.Font("Times New Roman",1,18));
        txtName.setBackground(new Color(108,122,137));
        txtName.setBounds(80,20,130,20);
        add(txtName);

        JBlist = new JButton("SHOW");
        JBlist.setBounds(10,300,80,30);
        JBlist.setBackground(new Color(34,167,240));
        add(JBlist);

        JBback = new JButton("BACK");
        JBback.setBounds(95,300,80,30);
        JBback.setBackground(new Color(34,167,240));
        add(JBback);

        ArrayList<Appointment> appointments = new ArrayList<>();
            JBlist.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        PreparedStatement statement = connection.prepareStatement("SELECT * FROM appointments");
                        ResultSet resultSet = statement.executeQuery();

                        while(resultSet.next()){
                            Object doctor = resultSet.getObject("Doctor");
                            String time = resultSet.getString("time");
                            String patientName = resultSet.getString("patientName");
                            String day = String.valueOf(resultSet.getString("day"));

                            appointments.add(new Appointment(time,patientName,day,doctor));

                        }

                        int n =0;
                        for (int i=0;i<appointments.size();i++){
                            if(appointments.get(i).getPatientName().equals(txtName.getText())){
                                area.selectAll();
                                area.replaceSelection("");
                                area.append(appointments.get(i).toString());
                                n++;
                                break;
                            }
                        }
                        if(n<1){
                            JOptionPane.showMessageDialog(null, txtName.getText()+" doesnt have appointment");

                        }
                        statement.close();




                        } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            });

            JBback.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    Login l = new Login();
                    l.setVisible(true);
                }
            });
    }
}
