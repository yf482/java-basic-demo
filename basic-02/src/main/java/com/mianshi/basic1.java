package com.mianshi;
public class basic1 {
    public static void main(String[] args) {
        print1();
        print2();
        System.out.println("num = " + getNum());
    }
    public static void print1(){
        int count =0;
        for(int i=0;i<100;i++){
            count = count++;
            count = ++count;
            count = --count;
            count = count--;
        }
        System.out.println("count = " + count);
    }
    public static void print2(){
        final byte Max = (byte) 128;
        final byte Max2 = (byte) 127;
        final byte Min = 2;
        System.out.println(Max/Min);
        System.out.println(Max2/Min);

    }
    public static int getNum(){
        int num;
        try {
            System.out.println("info");
            num = 3;
//            int num = 2/0;
            System.out.println("info2");
            return num;
        }catch (Exception e){
            System.out.println("error");
            num = 1;
            return num;
        }finally {
            System.out.println("final");
            num = 2;
//            return num;
        }
    }

}
