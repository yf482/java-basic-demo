package com.proxy.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 16:43
 **/
public class StaticProxyDemo {

    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy(new ReqTaskHandle());
        StaticProxy staticProxy2 = new StaticProxy(new CheckTaskHandle());
        Queue<TaskStatus> runTask = new LinkedList<>();
        Queue<TaskStatus> lastTask = new LinkedList<>();
        lastTask.add(new TaskStatus(true,"success","testRet"));
        lastTask.add(new TaskStatus(false,"false"));
        System.out.println("lastTask = " + lastTask.toString());
        boolean reRun = true;
        InterruptMsg interruptMsg = new InterruptMsg(false,"test");
        TaskStatus taskStatus = staticProxy.handle(reRun,runTask,lastTask,interruptMsg,"test1");
        if(!taskStatus.isSuccess()){
            System.out.println("taskStatus = " + taskStatus);
            return ;
        }
        String param =  taskStatus.getResult();
        TaskStatus taskStatus2 = staticProxy2.handle(reRun,runTask,lastTask,interruptMsg,param);
        if(!taskStatus2.isSuccess()){
            System.out.println("taskStatus2 = " + taskStatus2);
            return ;
        }
        System.out.println("runTask = " + runTask.toString());

    }
}
