package com.exception;

public class ExceptionDemo3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Demo2 d = new Demo2();
        try {
            int x = d.div(3, -2);
            System.out.println(x);
        } catch (FuShuException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("出现除数是负数");
        }

    }

}

class FuShuException extends Exception {
    private int value;

    public FuShuException() {
        super();
    }

    public FuShuException(String msg, int value) {
        super(msg);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

class Demo2 {
    //thorw后面是异常对象定义函数内，throws定义在行数外，后面接多个异常对象
    int div(int a, int b) throws FuShuException {
        if (b < 0) throw new FuShuException("出现了负数除数", b);
        return a / b;
    }
}
