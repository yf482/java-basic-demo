package com.proxy.statiproxy;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 15:57
 **/
public class Sing implements IDoSomething {
    @Override
    public int doSometing(int num) {
        System.out.println("Sing a song");
        return num;
    }
}
