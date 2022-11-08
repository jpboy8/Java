package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {

    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static Socket socket;


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",1892);
        MainFrame frame= new MainFrame();


    }
}
