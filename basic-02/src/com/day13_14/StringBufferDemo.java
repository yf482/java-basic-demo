package com.day13_14;

/*
 * StringBuffer是一个字符串缓冲区，是一个容器
 * */
public class StringBufferDemo {

    /**
     * 、
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = sb.append("abc");
        System.out.println(sb);
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
        sb.append("def").append(true).append(12);
        p(sb);
        sb.insert(1, "qq");
        p(sb);
        sb.delete(1, 3);//包含头，不包含尾部
        p(sb);
        sb.deleteCharAt(1);
        p(sb);
        sb.reverse();//反转字符串
        p(sb);
        //清空缓冲区
        sb.delete(0, sb.length());
        p(sb + "()");
        getChar();


    }

    public static void p(Object obj) {
        System.out.println(obj);
    }

    public static void method_update() {
        StringBuffer sb = new StringBuffer("aabb");
        sb.replace(1, 4, "java");//包含头不包含尾部
        sb.setCharAt(1, 'c');//替换一个字符
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
