package com.proxy.practice;

import java.util.Queue;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 16:25
 **/
public class ReqTaskHandle implements TaskHandle {



    @Override
    public TaskStatus handle(boolean reRun, Queue<TaskStatus> runTask, Queue<TaskStatus> lastTask, InterruptMsg interruptMsg, String args) {
        System.out.println("ReqTaskHandle run args: " + args );
        return new TaskStatus(true,"success","tset");
    }
}
