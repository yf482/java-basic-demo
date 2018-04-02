package com.collection;

/**
 * @author yunfeng
 * @version V.1.0
 * @Desc 类上的泛型
 * @create 2017/10/15 23:51
 **/
public class GenericDemo {

    public static void main(String[] args) {
        Tol t = new Tol();
        t.setObj(new Dog());
        Dog g = (Dog) t.getObj();

        Utils<Bird> ut = new Utils<Bird>();
        ut.setObj(new Bird());
        Bird bb = ut.getObj();

        Demo<String> d = new Demo<String>();
        d.show("string");
        d.print(6);
        Demo.method("ddd");
    }

}

class Dog {

}

class Bird {

}

class Tol {
    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }
}

class Utils<QQ> {
    private QQ qq;

    public void setObj(QQ qq) {
        this.qq = qq;
    }

    public QQ getObj() {
        return qq;
    }
}

class Demo<T> {
    public void show(T t) {
        System.out.println("show---" + t);
    }

    public <Q> void print(Q q) {
        System.out.println("print---" + q);
    }

    public static <D> void method(D d) {
        System.out.println("method--" + d);
    }
}
