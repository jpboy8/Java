package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckInfo extends JFrame {

    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    private JLabel printName;
    private JLabel printSurname;
    private JTextField txtName;
    private JTextField txtSurname;
    private JButton back;
    private JButton check;
    private JTextArea textArea;
    ArrayList<Patient> patients = new ArrayList<>();
    public CheckInfo(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(true);
        getContentPane().setBackground(new Color(44,62,80));

        connection=Connect.ConnectDB();

        textArea = new JTextArea();
        textArea.setBounds(10,80,350,200);
        textArea.setBackground(new Color(108,122,137));
        add(textArea);

        printName = new JLabel("Patient's name:");
        printName.setForeground(Color.WHITE);
        printName.setFont(new java.awt.Font("Times New Roman",1,16));
        printName.setBounds(10,20,120,20);
        add(printName);

        printSurname = new JLabel("Patient's surname:");
        printSurname.setForeground(Color.WHITE);
        printSurname.setFont(new java.awt.Font("Times New Roman",1,16));
        printSurname.setBounds(10,50,145,20);
        add(printSurname);

        txtName = new JTextField();
        txtName.setForeground(Color.white);
        txtName.setFont(new java.awt.Font("Times New Roman",1,18));
        txtName.setBackground(new Color(108,122,137));
        txtName.setBounds(165,20,130,20);
        add(txtName);

        txtSurname = new JTextField();
        txtSurname.setForeground(Color.white);
        txtSurname.setFont(new java.awt.Font("Times New Roman",1,18));
        txtSurname.setBackground(new Color(108,122,137));
        txtSurname.setBounds(165,50,130,20);
        add(txtSurname);

        check = new JButton("CHECK");
        check.setBounds(10,300,80,30);
        check.setBackground(new Color(34,167,240));
        add(check);

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

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement statement = null;
                try {
                    statement = connection.prepareStatement("SELECT * FROM patients");
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()){
                        String name = resultSet.getString("name");
                        String surname = resultSet.getString("surname");
                        String phoneNumber = resultSet.getString("phoneNumber");
                        String email = resultSet.getString("email");
                        String dateOfBirth = resultSet.getString("dateOfBirth");

                        patients.add(new Patient(name,surname,phoneNumber,email,dateOfBirth));


                    }

                    int n=0;
                    for (int i = 0; i <patients.size() ; i++) {
                        if(patients.get(i).getName().equals(txtName.getText())&&patients.get(i).getSurname().equals(txtSurname.getText())){
                            textArea.selectAll();
                            textArea.replaceSelection("");
                            textArea.append(patients.get(i).toString());
                            n++;
                            break;
                        }
                    }
                    if(n<1){
                        JOptionPane.showMessageDialog(null, "Patient not found");

                    }

                    statement.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
