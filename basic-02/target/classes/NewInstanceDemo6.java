class User{
    /*private User(){//将默认的构造方法私有化的话就不可以再创建对象，两种方法都是这样
    }*/
    public String toString() {
        return "User对象创建成功！";
    }
}

public class NewInstanceDemo6 {
    public static void main(String[] args) throws Exception {
        //传统方式创建对象
        System.out.println(new User());
//        创建对象：
//        1、使用Class对象的newInstance()方法创建该Class对象的实例，此时该Class对象必须要有无参数的构造方法。
//        2、使用Class对象获取指定的Constructor对象，再调用Constructor的newInstance（）方法创建对象类的实例，此时可以选择使用某个构造方法。如果这个构造方法被私有化起来，那么必须先申请访问，将可以访问设置为true；
        //使用反射的方式
        Class<User> c = User.class;
        User u = c.newInstance();//（直接newInstance的话必须保证默认的构造方法正常存在，也就是没有被私有化！这是前提条件）
        System.out.println(u);
    }
}
