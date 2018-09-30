package com.proxy.practice;

import com.proxy.dynamic.ProxyClassImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Queue;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 16:10
 **/
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    /**
     * @param proxied 被代理对象
     */
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    /**
     * 返回代理对象
     * @return
     */
    public Object newProxyInstance() {
        return Proxy.newProxyInstance(proxied.getClass().getClassLoader(), proxied.getClass().getInterfaces(), this);
    }

    private boolean isNotNext(boolean reRun,Queue<TaskStatus> lastTask){
        TaskStatus taskStatus = lastTask == null ? null :  lastTask.isEmpty() ? null : lastTask.remove();
        boolean  isNotNext =  reRun   && taskStatus != null &&  taskStatus.isSuccess();
        return isNotNext;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 代理方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //将代理对象生成字节码到F盘上，方便反编译出java文件查看，实际动态代理是不需要自己生成的
        addClassToDisk(proxy.getClass().getName(), ProxyClassImpl.class,"D:/$Proxy0.class");
        System.out.println("method:"+method.getName());
        System.out.println("args:"+args[0].getClass().getName());
        System.out.println("Before invoke method...");
        boolean reRun = (boolean) args[0];
        Queue<TaskStatus> runTask = (Queue<TaskStatus>) args[1];
        Queue<TaskStatus> lastTask = (Queue<TaskStatus>) args[2];
        InterruptMsg interruptMsg = (InterruptMsg) args[3];
        TaskStatus runStatus = null;
        TaskStatus lastStatus = lastTask  == null ? null : lastTask.isEmpty() ? null : lastTask.peek();
        String param = (String) args[4];
        if(isNotNext(reRun,lastTask)){
            runStatus = lastStatus;
        }else{
            Object object = method.invoke(proxied, reRun,runTask,lastTask,interruptMsg,param);
            runStatus = (TaskStatus) object;
        }
        runTask.offer(runStatus);
        System.out.println("After invoke method...");
        return runStatus;
    }

    /**
     * 用于生产代理对象的字节码，并将其保存到硬盘上
     * @param className
     * @param cl
     * @param path
     */
    private void addClassToDisk(String className, Class<?> cl, String path) {
        //用于生产代理对象的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(className, cl.getInterfaces());
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            //将代理对象的class字节码写到硬盘上
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
