package com.proxy.dynamic;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 16:12
 **/
public class SimpleProxyDemo {

    public static void main(String[] args) throws SecurityException, NoSuchMethodException {
        ProxyClassImpl c = new ProxyClassImpl();
        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(c);
        IProxyClass proxyClass = (IProxyClass)proxyHandler.newProxyInstance();
        System.out.println(proxyClass.getClass().getName());
        System.out.println(proxyClass.doSomething(5));


        /*DynamicProxyHandler proxyHandler2 = new DynamicProxyHandler();
        IProxyClass proxyClass2 = (IProxyClass)proxyHandler2.newProxyInstance();
        System.out.println(proxyClass2.getClass().getName());
        System.out.println(proxyClass2.doSomething(5));*/
    }

}
