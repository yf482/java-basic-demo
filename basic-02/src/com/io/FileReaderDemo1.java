package com.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo1 {

    /**
     * @param args
     */
    static FileReader fr = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        readMethod2();


    }

    public static void readMethod1() {
        try {
            fr = new FileReader("e:\\d.txt");
            int c = fr.read();
            System.out.println((char) c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readMethod2() {

        try {
            fr = new FileReader("e:\\d.txt");
            //实际开发时候new char[1024];两个字节
            char[] c = new char[3];
            int num = 0;
            //num为read进去的字符数
            while ((num = fr.read(c)) != -1) {
                System.out.println(num + "---" + new String(c, 0, num));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
