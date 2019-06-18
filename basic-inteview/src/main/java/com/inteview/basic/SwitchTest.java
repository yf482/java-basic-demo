package com.inteview.basic;

/**
 * @ClassName: SwitchTest
 * @Description: TODO
 * @Author yunfeng
 * @Date 2019-06-18
 * @Version V1.0
 **/
public class SwitchTest {
    /**
     * 这段代码输出的结果是：
     *
     * A: true
     * B: false
     * C: 编译出错  C
     * jdk5 之前不允许switch出现字符，之后不允许有null
     * @param args
     */
    public static void main(String[] args) {
        String param = null;
//        String param = "A";
//        switch (param) {
//            case "null":
//                System.out.println("null");
//                break;
//            default:
//                System.out.println("default");
//        }
    }
}
