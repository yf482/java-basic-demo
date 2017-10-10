package com.day17_18;

import java.io.FileWriter;
import java.io.IOException;

public class FirstWriterDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FileWriter fw = null;
        try {
            fw = new FileWriter("e:\\d.txt");
            fw.write("ni hao ma ");
            fw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("catch:" + e.toString());
            e.printStackTrace();
        } finally {

            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
