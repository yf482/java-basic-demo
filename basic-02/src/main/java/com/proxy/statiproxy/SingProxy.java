package com.proxy.statiproxy;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 15:57
 **/
public class SingProxy implements IDoSomething {

    private IDoSomething sing = new Sing();


    @Override
    public int doSometing(int num) {
        System.out.println("Befor singing ");
        int result = sing.doSometing(num);
        System.out.println("After singing");
        return result;
    }

}
