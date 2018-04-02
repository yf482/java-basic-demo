package com.thread2;

public class InnerSingleton {

    private static class Singletion {
        private static Singletion single = new Singletion();
    }

    public static Singletion getInstance() {
        return Singletion.single;
    }

}
