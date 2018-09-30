package com.proxy.practice;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 16:58
 **/
public class InterruptMsg {

    private boolean isInterrupt;
    private String msg;
    public InterruptMsg(){

    }
    public InterruptMsg(boolean isInterrupt, String msg) {
        this.isInterrupt = isInterrupt;
        this.msg = msg;
    }

    public boolean isInterrupt() {
        return isInterrupt;
    }

    public void setInterrupt(boolean interrupt) {
        isInterrupt = interrupt;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
