package com.fto;

public class CarDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Car c = new Car();
        System.out.println(c.color + c.num);
        new Car().color = "blue";
        new Car().num = 3;
        new Car().run();

    }

}

class Car {
    String color = "红色";
    int num = 4;

    void run() {
        System.out.println(color + num);
    }


}
