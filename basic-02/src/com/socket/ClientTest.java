package com.socket;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-08-18 22:15
 **/
public class ClientTest {



    @Test
    public  void test1(){
        try {
            Socket socket = new Socket("localhost",8089);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            writer.println("com.socket.User|show|test123");
            writer.flush();
            String test = br.readLine();
            System.out.println("test = " + test);
            writer.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void test2(){
        try {
            Socket socket = new Socket("localhost",8089);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            writer.println("com.socket.UserInterface|show|test123");
            writer.flush();
            String test = br.readLine();
            System.out.println("test = " + test);
            writer.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
