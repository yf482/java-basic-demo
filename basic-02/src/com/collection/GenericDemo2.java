package com.collection;

/**
 * @author yunfeng
 * @version V.1.0
 * @Desc 泛型的继承
 * @create 2017/10/15 23:52
 **/
public class GenericDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}

interface Inter<T> {
    void show(T t);
}

class InterImpl<T> implements Inter<T> {

    @Override
    public void show(T t) {
        System.out.println("show --" + t);
    }


}