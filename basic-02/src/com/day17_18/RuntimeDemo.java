package com.day17_18;

import java.io.IOException;

public class RuntimeDemo {

    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("c:\\saolei");
        Thread.sleep(4000);
        p.destroy();

    }

}
