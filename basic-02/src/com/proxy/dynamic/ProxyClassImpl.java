package com.proxy.dynamic;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 16:10
 **/
public class ProxyClassImpl implements IProxyClass  {
    @Override
    public int doSomething(int num) {
        System.out.println("方法执行中.....");
        return num;
    }
}
