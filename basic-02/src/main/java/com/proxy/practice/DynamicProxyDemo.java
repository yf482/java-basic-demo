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
public class DynamicProxyDemo {

    public static void main(String[] args) {
        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(new ReqTaskHandle());
        DynamicProxyHandler proxyHandler2 = new DynamicProxyHandler(new CheckTaskHandle());
        TaskHandle taskHandle1 = (TaskHandle) proxyHandler.newProxyInstance();
        TaskHandle taskHandle2 = (TaskHandle) proxyHandler2.newProxyInstance();
        Queue<TaskStatus> runTask = new LinkedList<>();
        Queue<TaskStatus> lastTask = new LinkedList<>();
        lastTask.add(new TaskStatus(false,"success","testRet"));
        lastTask.add(new TaskStatus(false,"false"));
        System.out.println("lastTask = " + lastTask.toString());
        boolean reRun = true;
        InterruptMsg interruptMsg = new InterruptMsg(false,"test");


        TaskStatus taskStatus = taskHandle1.handle(reRun,runTask,lastTask,interruptMsg,"test1");
        if(!taskStatus.isSuccess()){
            System.out.println("taskStatus = " + taskStatus);
            return ;
        }
        String param =  taskStatus.getResult();
        TaskStatus taskStatus2 = taskHandle2.handle(reRun,runTask,lastTask,interruptMsg,param);
        if(!taskStatus2.isSuccess()){
            System.out.println("taskStatus2 = " + taskStatus2);
            return ;
        }
        System.out.println("runTask = " + runTask.toString());

    }
}
