package com.inteview.basic;

/**
 * @ClassName: FloatPrimitiveTest
 * @Description: TODO
 * @Author yunfeng
 * @Date 2019-06-18
 * @Version V1.0
 **/
public class FloatPrimitiveTest {

    /**
     * A: true
     * B: false  b
     * C: 由硬件指令决定
     * @param args
     */
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        System.out.println("a = " + a);
        float b = 0.9f - 0.8f;
        System.out.println("b = " + b);
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
