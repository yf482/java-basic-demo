package com.reflect.demo2;

public class Test {
    public static void main(String[] args) {
        IHello hello = (IHello) new DynaProxyHello().bind(new Hello(), new LoggerOperation());
        hello.sayGoogBye("Double J");
        hello.sayHello("Double J");
    }
}


