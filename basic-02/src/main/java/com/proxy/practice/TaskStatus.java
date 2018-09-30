package com.proxy.practice;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-06-30 16:23
 **/
public class TaskStatus {

    private boolean success;
    private String msg;
    private String result;

    public TaskStatus() {
    }

    public TaskStatus(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public TaskStatus(boolean success, String msg, String result) {
        this.success = success;
        this.msg = msg;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
