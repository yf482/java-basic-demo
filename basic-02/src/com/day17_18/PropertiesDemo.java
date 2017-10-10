package com.day17_18;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class PropertiesDemo {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //properties map集合
        Properties prop = System.getProperties();

//		prop.list(System.out);
        prop.list(new PrintStream("e:\\properties.txt"));


    }

}
