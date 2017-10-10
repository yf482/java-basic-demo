package com.day9_10;

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
            System.out.println("���ֳ����Ǹ���");
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
    //thorw�������쳣�����庯���ڣ�throws�����������⣬����Ӷ���쳣����
    int div(int a, int b) throws FuShuException {
        if (b < 0) throw new FuShuException("�����˸�������", b);
        return a / b;
    }
}
