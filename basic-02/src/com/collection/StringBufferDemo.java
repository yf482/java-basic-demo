package com.collection;

/**
 * @author v_wbyfli
 */
public class StringBufferDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //实质是一个缓冲区16字符的字符串，还是数组。容器对象
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = sb.append("abc");
        System.out.println(sb);
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
        sb.append("def").append(true).append(12);
        p(sb);
        sb.insert(1, "qq");
        p(sb);
        sb.delete(1, 3);//
        p(sb);
        sb.deleteCharAt(1);
        p(sb);
        sb.reverse();//
        p(sb);
        sb.delete(0, sb.length());
        p(sb + "()");
        getChar();


    }


    public static void p(Object obj) {
        System.out.println(obj);
    }

    public static void builder() {
        //stringBuffer 线程同步，效率低  用于多线程
        //stringBuider 线程非	同步，效率高
    }

    public static void method_update() {
        StringBuffer sb = new StringBuffer("aabb");
        sb.replace(1, 4, "java");
        sb.setCharAt(1, 'c');


    }

    public static void getChar() {
        StringBuffer sb = new StringBuffer("saabdd");
        char[] chs = new char[6];
        sb.getChars(1, 4, chs, 1);
        for (int i = 0; i < chs.length; i++) {
            System.out.println("chs[" + i + "]" + chs[i] + ";");
        }
    }

}
