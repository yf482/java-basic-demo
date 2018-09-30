package com.fto;

public class AnimalDemo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        getEat(new Cat());
        getEat(new Dog());
    }

    //相当于Animal a = new Cat();父类引用指向子类对象。
    //动态绑定。
    public static void getEat(Animal a) {
        a.eat();
    }

}

abstract class Animal {
    public String name;

    abstract void eat();
}

class Cat extends Animal {
    public String color;

    public void eat() {
        System.out.println("eat fish");
    }
}

class Dog extends Animal {
    public String color;
    public int size;

    public void eat() {
        System.out.println("eat bone");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
