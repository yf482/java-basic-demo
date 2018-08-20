package com.socket;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-08-19 10:21
 **/
public class MyProxyView  implements InvocationHandler{

    private Map<Object,Object> map = null;

    private MyProxyView(){
        this.map = new HashMap<Object,Object>();
    }

    public static Object newInstance(Class[] interfaces){
        return Proxy.newProxyInstance(MyProxyView.class.getClassLoader(),interfaces,new MyProxyView());

    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        String methodName = method.getName();
        System.out.println("methodName = " + methodName);
        Class returnType = method.getReturnType();
        System.out.println("args length = " + args.length);
        System.out.println("args = " + args);
        System.out.println("returnType = " + returnType);
        String ret = "123";
        return ret;
    }

    public static void main(String[] args) {
        UserInterface userInterface = (UserInterface) MyProxyView.newInstance(new Class[]{UserInterface.class});
//        System.out.println("userInterface = " + userInterface);
        String ret = userInterface.show("ddd");
        System.out.println("ret = " + ret);


    }
}
