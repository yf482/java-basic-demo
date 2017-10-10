package com.day15_16;

public class GenericDemo {

    /**
     * @param args
     */
    //为什么定义泛型
    public static void main(String[] args) {
        // TODO Auto-generated method stub
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

//泛型类定义的泛型，在整个类有效，如果呗方法使用，那么泛型类的对象明确要操作的具体类型后
//所有要操作的类型就已经固定，
//为了让不同方法操作不同类型，可以在方法上定义泛型
class Utils<QQ> {
    private QQ qq;

    public void setObj(QQ qq) {
        this.qq = qq;
    }

    public QQ getObj() {
        return qq;
    }
}

//泛型类  T在范围类有效
class Demo<T> {
    public void show(T t) {
        System.out.println("show---" + t);
    }

    //泛型方法  在方法里面有效
    public <Q> void print(Q q) {
        System.out.println("print---" + q);
    }

    public static <D> void method(D d) {
        System.out.println("method--" + d);
    }
}
