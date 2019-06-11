package com.singleton.serialize;

import java.io.*;

/**
 * 为什么序列化会破坏单例?：序列化会通过反射调用无参数的构造方法创建一个新的对象。
 * hasReadResolveMethod:如果实现了serializable 或者 externalizable接口的类中包含readResolve则返回true
 * invokeReadResolve:通过反射的方式调用要被反序列化的类的readResolve方法。
 *  主要在Singleton中定义readResolve方法，并在该方法中指定要返回的对象的生成策略，就可以防止单例被破坏。
 */
public class SerializableDemo1 {
        //为了便于理解，忽略关闭流操作及删除文件操作。真正编码时千万不要忘记
        //Exception直接抛出
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            //Write Obj to file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/tempFile"));
            Singleton singleton = Singleton.getSingleton();
            System.out.println("singleton = " + singleton);
            oos.writeObject(singleton);
            //Read Obj from file
            File file = new File("D:/tempFile");
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            Singleton newInstance = (Singleton) ois.readObject();
            System.out.println("newInstance = " + newInstance);
            //判断是否是同一个对象
            System.out.println(newInstance == Singleton.getSingleton());
        }
}
