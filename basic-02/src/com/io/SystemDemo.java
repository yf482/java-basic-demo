package com.io;

import java.util.Properties;

public class SystemDemo {

    /**
     * @param args
     */
    /*
     *  System类中的方法和属性都是静态的
	 *  out标准输出默认是控制台
	 *  in,标准输入，默认是键盘
	 *
	 *
	 * */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Properties prop = System.getProperties();

        //因为Properties是HashTable的子类，也就是一个Map集合的子类
        //那么可以通过map的方法取出该集合的元素
        prop.setProperty("key1", "itheima");

        for (Object obj : prop.keySet()) {
            String str = (String) prop.get(obj);
            System.out.println(str);
        }

        //获取指定信息
        System.out.println(prop.getProperty("key1"));
        System.out.println(System.getProperty("key1"));
        //可不可以在jvm启动时候，动态加载一些属性信息呢
        System.out.println(prop.getProperty("haha"));

    }

}
