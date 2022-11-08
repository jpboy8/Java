package com.company;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    private JProgressBar progressBar;
    Thread thread;


    public static void main(String[] args) {
        new Loading().setVisible(true);

    }

    public void setUploading(){
        setVisible(false);
        thread.start();
    }

    public void  run(){
        try {
            for (int i = 0; i < 200 ; i++) {

                int m = progressBar.getMaximum();
                int v =progressBar.getValue();
                if(v<m){
                    progressBar.setValue(progressBar.getValue()+1);
                }else{
                    i=201;
                    setVisible(false);
                    new Login().setVisible(true);
                }
                Thread.sleep(50);
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public Loading(){
        super("Loading");
        thread= new Thread((Runnable) this);

        setSize(400,400);
        setLayout(null);
        getContentPane().setBackground(new Color(44,62,80));


        progressBar= new JProgressBar();
        progressBar.setFont(new Font("Times New Roman",Font.BOLD,12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(70,135,250,30);
        add(progressBar);

        JLabel lbWait= new JLabel("Please wait...");
        lbWait.setFont(new Font("Times New Roman",Font.BOLD,15));
        lbWait.setForeground(Color.white);
        lbWait.setBounds(80,165,150,25);
        add(lbWait);


        setUploading();

    }
}
