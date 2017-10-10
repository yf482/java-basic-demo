package com.day03;

import org.junit.Test;

/**
 * 运算符
 *
 * @author v_wbyfli
 */
public class Opertater {

    @Test
    public void test1() {

        /**
         * 1、比较运算符
         *  ==、!= 、 <、>、  <=  >=
         *  结果都是boolean
         *
         *  2、逻辑运算符：
         *  &	| 	^	!	&& 	||
         *  ^符号的两边结果如果相同，结果是false。结果不同，结果是true。
         *
         *	3、位运算符
         *	<< 左移动  3<<2=12 --> 3*2*2=12
         *	>>  3>>1=1
         *	>>> 符号右移动 3>>>1=1
         *	|	6|3=7
         *	^ 异或 6^3=5 110 ^ 011 = 101
         *	~ ~6=-7
         *
         */


    }

    @Test
    public void test2() {

        /**
         * 1、三元运算符
         * 	()? x ：y
         *
         */
        int i = true ? 1 : 2;
        System.out.println("i:" + i);
        int y = false ? 1 : 2;
        System.out.println("y:" + y);


    }

}
