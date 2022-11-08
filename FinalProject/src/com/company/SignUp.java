package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SignUp extends JFrame {
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    private JLabel JLlogin;
    private JLabel Jlpass;
    private JLabel Jlname;
    private JLabel Jlsurname;
    private JLabel JlphoneNumber;
    private JLabel JLemail;
    private JLabel JLdateOfBirth;

    private JTextField textLog;
    private JTextField textPass;
    private JTextField textName;
    private JTextField textSurname;
    private JTextField textPhoneNumber;
    private JTextField textEmail;
    private JTextField textDateOfBirth;

    private JButton back;
    private JButton signUp;

    public SignUp(){
        connection = Connect.ConnectDB();
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(true);
        getContentPane().setBackground(new Color(44,62,80));

        JLlogin = new JLabel("Login:");
        JLlogin.setForeground(Color.white);
        JLlogin.setFont(new java.awt.Font("Times New Roman",1,15));
        JLlogin.setBounds(40,35,90,20);
        add(JLlogin);

        Jlpass = new JLabel("Password:");
        Jlpass.setForeground(Color.white);
        Jlpass.setFont(new java.awt.Font("Times New Roman",1,15));
        Jlpass.setBounds(40,65,90,20);
        add(Jlpass);

        Jlname = new JLabel("Name:");
        Jlname.setForeground(Color.white);
        Jlname.setFont(new java.awt.Font("Times New Roman",1,15));
        Jlname.setBounds(40,95,90,20);
        add(Jlname);

        Jlsurname = new JLabel("Surname:");
        Jlsurname.setForeground(Color.white);
        Jlsurname.setFont(new java.awt.Font("Times New Roman",1,15));
        Jlsurname.setBounds(40,125,90,20);
        add(Jlsurname);

        JlphoneNumber = new JLabel("Phone Number:");
        JlphoneNumber.setForeground(Color.white);
        JlphoneNumber.setFont(new java.awt.Font("Times New Roman",1,15));
        JlphoneNumber.setBounds(40,155,110,20);
        add(JlphoneNumber);

        JLemail = new JLabel("Email:");
        JLemail.setForeground(Color.white);
        JLemail.setFont(new java.awt.Font("Times New Roman",1,15));
        JLemail.setBounds(40,185,90,20);
        add(JLemail);

        JLdateOfBirth = new JLabel("Date of Birth:");
        JLdateOfBirth.setForeground(Color.white);
        JLdateOfBirth.setFont(new java.awt.Font("Times New Roman",1,15));
        JLdateOfBirth.setBounds(40,215,110,20);
        add(JLdateOfBirth);

        textLog=new JTextField();
        textLog.setForeground(Color.white);
        textLog.setFont(new java.awt.Font("Times New Roman",1,15));
        textLog.setBackground(new Color(108,122,137));
        textLog.setBounds(160,35,130,20);
        add(textLog);

        textPass= new JTextField();
        textPass.setForeground(Color.white);
        textPass.setFont(new java.awt.Font("Times New Roman",1,15));
        textPass.setBackground(new Color(108,122,137));
        textPass.setBounds(160,65,130,20);
        add(textPass);

        textName=new JTextField();
        textName.setForeground(Color.white);
        textName.setFont(new java.awt.Font("Times New Roman",1,15));
        textName.setBackground(new Color(108,122,137));
        textName.setBounds(160,95,130,20);
        add(textName);

        textSurname=new JTextField();
        textSurname.setForeground(Color.white);
        textSurname.setFont(new java.awt.Font("Times New Roman",1,15));
        textSurname.setBackground(new Color(108,122,137));
        textSurname.setBounds(160,125,130,20);
        add(textSurname);

        textPhoneNumber=new JTextField();
        textPhoneNumber.setForeground(Color.white);
        textPhoneNumber.setFont(new java.awt.Font("Times New Roman",1,15));
        textPhoneNumber.setBackground(new Color(108,122,137));
        textPhoneNumber.setBounds(160,155,130,20);
        add(textPhoneNumber);

        textEmail=new JTextField();
        textEmail.setForeground(Color.white);
        textEmail.setFont(new java.awt.Font("Times New Roman",1,15));
        textEmail.setBackground(new Color(108,122,137));
        textEmail.setBounds(160,185,130,20);
        add(textEmail);

        textDateOfBirth=new JTextField();
        textDateOfBirth.setForeground(Color.white);
        textDateOfBirth.setFont(new java.awt.Font("Times New Roman",1,15));
        textDateOfBirth.setBackground(new Color(108,122,137));
        textDateOfBirth.setBounds(160,215,130,20);
        add(textDateOfBirth);

        back = new JButton("BACK");
        back.setBackground(new Color(34,167,240));
        back.setBounds(130,265,80,30);
        add(back);

        signUp = new JButton("SIGN UP");
        signUp.setBackground(new Color(34,167,240));
        signUp.setBounds(220,265,80,30);
        add(signUp);

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query ="Insert into patients (login,password,name,surname,phoneNumber,email,dateOfBirth) values (?,?,?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1,textLog.getText());
                    preparedStatement.setString(2,textPass.getText());
                    preparedStatement.setString(3,textName.getText());
                    preparedStatement.setString(4,textSurname.getText());
                    preparedStatement.setString(5,textPhoneNumber.getText());
                    preparedStatement.setString(6,textEmail.getText());
                    preparedStatement.setString(7,textDateOfBirth.getText());

                    preparedStatement.execute();

                    JOptionPane.showMessageDialog(null, "New acoount created");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

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
