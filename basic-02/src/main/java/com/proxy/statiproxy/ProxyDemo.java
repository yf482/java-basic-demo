package com.proxy.statiproxy;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 15:59
 **/
public class ProxyDemo {

    public static int sing(IDoSomething sing, int num) {
        return sing.doSometing(num);
    }
    public static void main(String[] args) {
        System.out.println(ProxyDemo.sing(new SingProxy(), 5));
        System.out.println(ProxyDemo.sing(new DanceProxy(), 5));

    }
}

