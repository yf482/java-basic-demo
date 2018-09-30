package com.reflect.demo2;

import java.lang.reflect.Method;

public class LoggerOperation implements IOperation {
    @Override
    public void start(Method method) {
        System.out.println("method start:  " + method.getName() + " time: " + System.currentTimeMillis());
    }

    @Override
    public void end(Method method) {
        System.out.println("method end:  " + method.getName() + " time: " + System.currentTimeMillis());

    }
}
