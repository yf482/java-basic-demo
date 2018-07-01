package com.proxy.practice;

import java.util.Queue;

public interface TaskHandle {

    public TaskStatus handle(boolean reRun,Queue<TaskStatus> runTask,Queue<TaskStatus> lastTask,InterruptMsg interruptMsg,String args);
}
