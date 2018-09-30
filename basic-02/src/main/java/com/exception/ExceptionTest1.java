package com.exception;

/**
 * @author yunfeng
 * @version V.1.0
 * @Desc 自定义异常  构造函数异常处理
 * @create 2017/10/15 22:21
 **/
public class ExceptionTest1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Rec rec = null;
//		try {
        rec = new Rec(-3, 4);
//		} catch (NoValueException e) {
////			e.printStackTrace();
//			System.out.println();
//		}
        rec.getArea();

    }

}

interface Shape {
    public void getArea();
}

class Rec implements Shape {
    private int len, wid;

    Rec(int len, int wid) {//throws NoValueException{
        if (len <= 0 || wid <= 0)
            throw new NoValueException("出现非法值");
        this.len = len;
        this.wid = wid;
    }

    public void getArea() {
        System.out.println(len * wid);
    }
}

class NoValueException extends RuntimeException {
    NoValueException(String msg) {
        super(msg);
    }
}


