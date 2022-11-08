package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
    private static Connection connection=null;
    private static Statement statement=null;
    private static ResultSet resultSet= null;
    private static String url = "jdbc:mysql://localhost/dataPatients?serverTimezone=Europe/Moscow&useSSL=false";
    private static String user="root";
    private static String pass="";

    public static Connection ConnectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,user,pass);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
