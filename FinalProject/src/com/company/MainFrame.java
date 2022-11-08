package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainFrame extends JFrame {
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    private JLabel JJlog;
    private JLabel JLpass;
    private JTextField textLog;
    private JPasswordField textPass;

    private JButton JBlogin;
    private JButton JBsignup;


    public MainFrame(){
        connection=Connect.ConnectDB();
        setSize(400,400);
        setTitle("ESTELIFE CLINIC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setVisible(true);

        getContentPane().setBackground(new Color(44,62,80));

        JJlog=new JLabel("Login:");
        JJlog.setFont(new java.awt.Font("Times New Roman",1,18));
        JJlog.setForeground(Color.white);
        JJlog.setBounds(62,70,70,20);
        add(JJlog);

        textLog=new JTextField();
        textLog.setForeground(Color.white);
        textLog.setFont(new java.awt.Font("Times New Roman",1,18));
        textLog.setBackground(new Color(108,122,137));
        textLog.setBounds(150,70,130,20);
        add(textLog);

        JLpass = new JLabel("Password:");
        JLpass.setForeground(Color.WHITE);
        JLpass.setFont(new java.awt.Font("Times New Roman",1,18));
        JLpass.setBounds(62,110,80,20);
        add(JLpass);

        textPass=new JPasswordField();
        textPass.setForeground(Color.white);
        textPass.setBackground(new Color(108,122,137));
        textPass.setBounds(150,110,160,20);
        add(textPass);

        JBlogin = new JButton("LOGIN");
        JBlogin.setBounds(150,150,80,30);
        JBlogin.setBackground(new Color(34,167,240));
        add(JBlogin);

        JBsignup = new JButton("SIGN UP");
        JBsignup.setBounds(235,150,80,30);
        JBsignup.setBackground(new Color(34,167,240));
        add(JBsignup);

        JBlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "select * from patients where login=? and password=?";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1,textLog.getText());
                    preparedStatement.setString(2,textPass.getText());
                    resultSet = preparedStatement.executeQuery();

                    boolean check=false;
                    for (int i = 0; i < DBdoctor.doctors.size(); i++) {
                        if(DBdoctor.doctors.get(i).getLog().equals(textLog.getText())&&DBdoctor.doctors.get(i).getPass().equals(textPass.getText())){
                            check=true;
                        }
                    }

                    if(resultSet.next()){
                        resultSet.close();
                        preparedStatement.close();
                        setVisible(false);

                       new Loading().setVisible(true);
                    }
                    else if(check==true){
                        setVisible(false);
                        Admin a = new Admin();
                        a.setVisible(true);
                    }
                        else {
                        JOptionPane.showMessageDialog(null,"Incorrect login or password");
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JBsignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp s= new SignUp();
                s.setVisible(true);
            }
        });


    }
}
