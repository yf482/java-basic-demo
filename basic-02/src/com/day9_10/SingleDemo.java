package com.day9_10;

public class SingleDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

//����ʽ
class Single {
    private Single() {
    }

    private static final Single s = new Single();

    public static Single getInstance() {
        return s;
    }
}

//����ʽ
class Single2 {
    private static Single2 s = null;

    private Single2() {
    }

    public static Single2 getInstance() {
        if (s == null) {
            synchronized (Single.class) {
                if (s == null)
                    s = new Single2();

            }


        }
        return s;
    }


}
