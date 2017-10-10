package com.day20_21;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {


//			testProperties();
//			testLoad();
            testLoad2();


        } catch (IOException e) {

            throw new RuntimeException();

        }
    }

    /**
     * 通过流读取里面的信息  存储到properties
     *
     * @throws IOException
     */
    public static void testProperties() throws IOException {
        //properties 是一个map集合 键对形式
        BufferedReader bufr = new BufferedReader(new FileReader("e:\\properties.txt"));

        String line = null;
        Properties prop = new Properties();

        while ((line = bufr.readLine()) != null) {
            String[] arr = line.split("=");
//			System.out.println(arr[0]+"--"+arr[1]);
            prop.setProperty(arr[0], arr[1]);

        }

        System.out.println(prop);


    }

    public static void testLoad() throws IOException {

        Properties prop = new Properties();
        //从流中取出properties  加载数据时候 需要数据有固定形式 键 = 值
        FileInputStream fis = new FileInputStream("e:\\properties.txt");
        prop.load(fis);
        System.out.println(prop);

        prop.setProperty("liyf", "25");

        //将prop 用流的形式 存到文件 数据持久化
        FileOutputStream fos = new FileOutputStream("e:\\properties.txt");

        prop.store(fos, "haha");

        fos.close();
        fis.close();

    }

    /*
     *读取文件的使用次数
     */
    public static void testLoad2() throws IOException {

        Properties prop = new Properties();
        File file = new File("e:\\connt.ini");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);

        int count = 0;
        String value = prop.getProperty("time");
        if (value != null) {
            count = Integer.parseInt(value);
            if (count >= 5)
                System.out.println("使用次数上线达到5次");
            return;

        }

        count++;
        prop.setProperty("time", count + "");

        FileOutputStream fos = new FileOutputStream(file);
        prop.store(fos, "使用次数");

        fis.close();
        fos.close();
    }

}
