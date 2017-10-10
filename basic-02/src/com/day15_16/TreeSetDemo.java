package com.day15_16;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

    /**
     * @param args
     */
    //当主要条件相同时候，一定要判断次要条件。
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeSet tr = new TreeSet();
        tr.add(new Cat("cat2", 11));
        tr.add(new Cat("cat1", 12));
        tr.add(new Cat("cat3", 13));
        tr.add(new Cat("cat4", 13));//没存进去

        Iterator it = tr.iterator();
        while (it.hasNext()) {
            Cat c = (Cat) it.next();
            System.out.println(c.getName() + "---" + c.getWeight());
        }

    }

}

//该接口强制让学生具备比较性
class Cat implements Comparable {
    private String name;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Cat(String name, int weight) {
        super();
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub

        System.out.println(this.name + "compareTo" + "");
        if (!(o instanceof Cat)) {
            throw new RuntimeException();
        }
        Cat c = (Cat) o;
        if (this.weight > c.weight)
            return 1;
        if (this.weight == c.weight)
            return this.name.compareTo(c.name);
        return -1;
    }


}