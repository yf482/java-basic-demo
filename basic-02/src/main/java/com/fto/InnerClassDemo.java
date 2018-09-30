package com.fto;

/*
 * 内部类访问规则：
 * 1.内部类可以访问外部类的成员，包括私有
 * 之所以可以直接访问外部类中的成员，是因为内部类持有一个外部类的引用，格式，外部类名.this
 * 2.外不累要访问内部类，必须建立内部类对象
 * 访问格式：1.当内部类定义在外部类的成员位置上，而且非私有，可以在外部其他类中。
 * 可以直接遍历内部类对象。
 * 格式： 外部类名.内部类名   变量名 = 外部类对象.内部类对象
 *
 * 2.当内部类在成员位置上就可以呗成员修饰符所修饰。比如private将内部类在外部类中进行封装。
 * statiproxy :内部类就具备static的特性。只能直接访问外部类中的static 成员，出现了访问局限。
 * 在外部其他类中，如何直接访问static内部类的非静态成员呢？、
 * new Outer.Inner.function();
 * 在外部其他类中，如何直接访问static内部类的静态成员员？
 * outer.Inner.function();
 * 注意：当内部类中定义静态成员，该内部类必须是static 当外部类中的静态方法访问内部类是，内部类也必须是static的。
 *
 * 当描述事物的时候，事物的内部还有事物，该事物用内部类来描述。
 * 因为内部事物在使用外部事物的内容。
 * class Body
 * {
 * 	private class Xinzhang
 * 	{
 *
 * 	}
 *
 * }
 *
 * */
public class InnerClassDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();

        Outer.Inner in = new Outer().new Inner();


    }


}

class Outer {
    private int x = 3;

    //内部类 当作类成员  可以设置private权限
    class Inner {
        int x = 4;

        void function() {
            System.out.println("inner:x=" + x + Outer.this.x);

        }
    }

    void method() {
        Inner in = new Inner();
        in.function();
    }
}
