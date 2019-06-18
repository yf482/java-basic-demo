package com.inteview.basic;

import java.math.BigDecimal;

/**
 * @ClassName: BigDecimalTest
 * @Description: TODO
 * @Author yunfeng
 * @Date 2019-06-18
 * @Version V1.0
 **/
public class BigDecimalTest {
    /**
     * 下列哪种说法是正确的：
     *      *
     *      * A: 两种赋值的方式是一样的
     *      * B: 推荐a的赋值方式
     *      * C: 推荐b的赋值方式
     * @param args
     */
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
    }
}
