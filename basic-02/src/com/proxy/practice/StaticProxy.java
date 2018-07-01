package com.proxy.practice;

import java.util.Queue;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 16:30
 **/
public class StaticProxy implements TaskHandle {

    private TaskHandle taskHandle;

    public StaticProxy(TaskHandle taskHandle) {
        this.taskHandle = taskHandle;
    }

    private boolean isNotNext(boolean reRun,Queue<TaskStatus> lastTask){
        TaskStatus taskStatus = lastTask == null ? null :  lastTask.isEmpty() ? null : lastTask.remove();
        boolean  isNotNext =  reRun   && taskStatus != null &&  taskStatus.isSuccess();
        return isNotNext;
    }

    @Override
    public TaskStatus handle(boolean reRun, Queue<TaskStatus> runTask, Queue<TaskStatus> lastTask, InterruptMsg interruptMsg, String args) {
        TaskStatus runStatus = null;
        TaskStatus lastStatus = lastTask  == null ? null : lastTask.isEmpty() ? null : lastTask.peek();
        if(isNotNext(reRun,lastTask)){
            runStatus = lastStatus;
        }else{
            runStatus = taskHandle.handle(reRun,runTask,lastTask,interruptMsg,args);
        }
        runTask.offer(runStatus);
        return runStatus;
    }
}
