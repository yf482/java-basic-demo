package com.io;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Date d = new Date();
        System.out.println(d);
        //将模式封装到SimpleDateFormat对象中
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日E hh:mm:ss");
        //调用format方法让模式格式化Date对象
        String date = sdf.format(d);
        System.out.println(date);

        long l = System.currentTimeMillis();
        Date dd = new Date(l);
        System.out.println(dd);

    }

}
