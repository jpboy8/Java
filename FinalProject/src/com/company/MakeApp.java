package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MakeApp extends JFrame {

    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    private JLabel JLname;
    private JLabel JLchooseDoc;
    private JLabel JLprintTime;
    private JLabel JLprintDay;
    private JTextField txtName;
    private JTextField txtTime;
    private JComboBox comboBoxDay;
    private JComboBox comboBoxDoctor;
    private JButton enroll;
    private JButton back;
    private ArrayList<Object> Appointment = new ArrayList<>();




    public MakeApp(){
        connection= Connect.ConnectDB();
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setVisible(true);

        getContentPane().setBackground(new Color(44,62,80));

        comboBoxDoctor = new JComboBox(DBdoctor.doctors.toArray());
        comboBoxDoctor.setBounds(150,70,170,20);
        add(comboBoxDoctor);

        JLchooseDoc = new JLabel("Choose doctor");
        JLchooseDoc.setBounds(30,70,100,20);
        JLchooseDoc.setForeground(Color.WHITE);
        JLchooseDoc.setFont(new java.awt.Font("Times New Roman",1,15));
        add(JLchooseDoc);

        JLname= new JLabel("Name: ");
        JLname.setBounds(30,120,100,20);
        JLname.setForeground(Color.WHITE);
        JLname.setFont(new java.awt.Font("Times New Roman",1,15));
        add(JLname);

        txtName = new JTextField();
        txtName.setForeground(Color.white);
        txtName.setBackground(new Color(108,122,137));
        txtName.setBounds(150,120,100,20);
        add(txtName);

        JLprintTime = new JLabel("Print time:");
        JLprintTime.setBounds(30,170,100,20);
        JLprintTime.setForeground(Color.WHITE);
        JLprintTime.setFont(new java.awt.Font("Times New Roman",1,15));
        add(JLprintTime);

        txtTime = new JTextField();
        txtTime = new JTextField();
        txtTime.setForeground(Color.white);
        txtTime.setBackground(new Color(108,122,137));
        txtTime.setBounds(150,170,100,20);
        add(txtTime);

        JLprintDay = new JLabel("Choose day:");
        JLprintDay.setBounds(30,220,100,20);
        JLprintDay.setForeground(Color.WHITE);
        JLprintDay.setFont(new java.awt.Font("Times New Roman",1,15));
        add(JLprintDay);


        comboBoxDay = new JComboBox(Day.values());
        comboBoxDay.setBounds(150,220,170,20);
        add(comboBoxDay);


        enroll = new JButton("ENROLL");
        enroll.setBounds(150,270,80,30);
        enroll.setBackground(new Color(34,167,240));
        add(enroll);

        back = new JButton("BACK");
        back.setBounds(235,270,80,30);
        back.setBackground(new Color(34,167,240));
        add(back);



            enroll.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String query ="Insert into appointments (Doctor,time,patientName,day) values (?,?,?,?)";
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, String.valueOf(comboBoxDoctor.getSelectedItem()));
                        preparedStatement.setString(2,txtTime.getText());
                        preparedStatement.setString(3,txtName.getText());
                        preparedStatement.setString(4,String.valueOf(comboBoxDay.getSelectedItem()));

                        preparedStatement.execute();

                        JOptionPane.showMessageDialog(null, "New appointment created");

                    }catch (Exception ex){
                        ex.printStackTrace();
                    }


                }
            });

            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    Login l = new Login();
                    l.setVisible(true);
                }
            });


    }

}
