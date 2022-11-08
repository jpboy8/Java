package com.company;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteApp extends JFrame {
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JComboBox comboBox;
    private JComboBox comboBox2;

    private JButton delete;
    private JButton back;


    public DeleteApp(){
        connection= Connect.ConnectDB();
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setVisible(true);

        getContentPane().setBackground(new Color(44,62,80));

        comboBox = new JComboBox(DBdoctor.doctors.toArray());
        comboBox.setBounds(150,100,170,20);
        add(comboBox);

        label1 = new JLabel("Choose doctor");
        label1.setBounds(30,100,100,20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new java.awt.Font("Times New Roman",1,15));
        add(label1);

        label2= new JLabel("Patient name: ");
        label2.setBounds(30,150,100,20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new java.awt.Font("Times New Roman",1,15));
        add(label2);

        label3= new JLabel("Choose day: ");
        label3.setBounds(30,200,100,20);
        label3.setForeground(Color.WHITE);
        label3.setFont(new java.awt.Font("Times New Roman",1,15));
        add(label3);

        comboBox2 = new JComboBox(Day.values());
        comboBox2.setBounds(150,200,170,20);
        add(comboBox2);



        textField1 = new JTextField();
        textField1.setForeground(Color.white);
        textField1.setBackground(new Color(108,122,137));
        textField1.setBounds(150,150,100,20);
        add(textField1);

        delete = new JButton("DELETE");
        delete.setBounds(150,280,80,30);
        delete.setBackground(new Color(34,167,240));
        add(delete);

        back = new JButton("BACK");
        back.setBounds(235,280,80,30);
        back.setBackground(new Color(34,167,240));
        add(back);

        ArrayList<Appointment> appointments = new ArrayList<>();
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query =" delete from appointments where Doctor = ? and patientName =?  and day =? ";
                try {

                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1, String.valueOf(comboBox.getSelectedItem()));
                    preparedStatement.setString(2,textField1.getText());
                    preparedStatement.setString(3,String.valueOf(comboBox2.getSelectedItem()));
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Appointment was successfully deleted");

                    preparedStatement.close();

                } catch (SQLException ex) {
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
