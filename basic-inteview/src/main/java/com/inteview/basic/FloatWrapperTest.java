package com.inteview.basic;

/**
 * @ClassName: FloatWrapperTest
 * @Description: TODO
 * @Author yunfeng
 * @Date 2019-06-18
 * @Version V1.0
 **/
public class FloatWrapperTest {
    /**
     *A: true
     * B: false b
     * C: 由硬件指令决定
     * @param args
     */
    public static void main(String[] args) {
        Float a = Float.valueOf(1.0f - 0.9f);
        System.out.println("a = " + a);
        Float b = Float.valueOf(0.9f - 0.8f);
        System.out.println("b = " + b);
        if (a.equals(b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
