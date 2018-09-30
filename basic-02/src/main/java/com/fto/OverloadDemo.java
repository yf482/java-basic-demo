package com.fto;

public class OverloadDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //定义了同一函数名称，通过参数列表来区分多个同名函数
        add(3, 4);
        add(3, 4, 5);

    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int add(int x, int y, int z) {
        return add(x, y) + z;//进一步提高代码的复用性

    }

}
