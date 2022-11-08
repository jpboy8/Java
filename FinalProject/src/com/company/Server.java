package com.company;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
        public static void main(String[] args) throws IOException {

                ServerSocket serverSocket = new ServerSocket(1892);
                System.out.println("Waiting client");
                Socket socket= serverSocket.accept();
                System.out.println("Client is connected");

        }
    }

