package com.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeSet tr = new TreeSet();//new MyComparator()
        tr.add(new Cat1("cat2", 11));
        tr.add(new Cat1("cat1", 12));
        tr.add(new Cat1("cat3", 13));
        tr.add(new Cat1("cat4", 13));

        Iterator it = tr.iterator();
        while (it.hasNext()) {
            Cat1 c = (Cat1) it.next();
            System.out.println(c.getName() + "---" + c.getWeight());
        }

    }

}

class Cat1 implements Comparable {
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

    public Cat1(String name, int weight) {
        super();
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub

        System.out.println(this.name + "compareTo" + "");
        if (!(o instanceof Cat1)) {
            throw new RuntimeException();
        }
        Cat1 c = (Cat1) o;
        if (this.weight > c.weight)
            return 1;
        if (this.weight == c.weight)
            return this.name.compareTo(c.name);
        return -1;
    }


}

class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        Cat c1 = (Cat) o1;
        Cat c2 = (Cat) o2;

        int num = c1.getName().compareTo(c2.getName());

        if (num == 0) {

//			return Integer.valueOf(c1.getWeight()).compareTo(Integer.valueOf(c2.getWeight()));
            return new Integer(c1.getWeight()).compareTo(new Integer(c2.getWeight()));
            //			if(c1.getWeight()>c2.getWeight())
//				return 1;
//			if(c1.getWeight()==c2.getWeight())
//				return 0;
//					
//				return -1;
        }
        return num;


    }

}