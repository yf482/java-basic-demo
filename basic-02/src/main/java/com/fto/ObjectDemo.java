package com.fto;

public class ObjectDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Demo d1 = new Demo(2);
        Demo d2 = new Demo(2);
        Demo d3 = d1;
        //反编译从java文件中知道类的结构
        Class c = d1.getClass();
        System.out.println(c.getName() + "@" + Integer.toHexString(d1.hashCode()));

        System.out.println(d1.equals(d3));//比较对象内容true
        System.out.println(d1 == d2);//比较引用本身是否同一对象 false
        System.out.println(d1.equals(d2));//比较对象内容true
        System.out.println(d1 == d3);//true
        System.out.println(d1.toString());
        System.out.println(d3.toString());

    }

}

class Demo {
    private int num;

    Demo(int num) {
        this.num = num;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Demo) {
            Demo d = (Demo) obj;
            return this.num == d.num;
        } else
            return false;

    }

}

