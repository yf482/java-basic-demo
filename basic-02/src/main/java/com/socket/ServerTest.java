package com.socket;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-08-18 15:38
 **/
public class ServerTest {

    public static void main(String[] args)  {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        BufferedReader br = null;
        try{
            ServerSocket serverSocket = new ServerSocket();
//            serverSocket.bind(new InetSocketAddress("localhost",8089),50);
            serverSocket.bind(new InetSocketAddress("localhost",8089));
            while (true){
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                printWriter = new PrintWriter(outputStream);
                br = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                line = br.readLine();
                if(line != null){
                    String [] param = line.split("\\|");
                    String obj = param[0];
                    String method = param[1];
                    String paramList = param[2];
                    if("com.socket.User".equals(obj)){
                        Class cl = Class.forName(obj);
                        User user = (User) cl.newInstance();
                        Method md = cl.getMethod(method,String.class);
                        String ret = (String) md.invoke(user,paramList);
                        printWriter.println("run end : " + ret);
                    }else if("com.socket.UserInterface".equals(obj)){
                        Class cl = Class.forName(obj);
//                        UserInterface user = (UserInterface) cl.newInstance();
                        Method md = cl.getMethod(method,String.class);
                        String ret = (String) md.invoke(null,paramList);
                        printWriter.println("run end : " + ret);
                    }
                }else {
                    printWriter.println("run fail");
                }
                printWriter.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                printWriter.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
