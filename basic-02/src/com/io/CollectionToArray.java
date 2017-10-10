package com.io;

import java.util.*;

public class CollectionToArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        forEachDemo();


    }

    public static void forEachDemo() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("ddd1");
        al.add("ddd2");
        al.add("ddd3");

        Iterator<String> it = al.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        //增强型for循环,被遍历的集合（collection）或者数组
        //迭代器除了遍历，还可以进行remove集合中元素的动作
        //对集合的操作：ListIterator  还可以对集合进行增删改查的操作
        //在遍历数组时候还是希望传统for，传统for有角标
        for (String s : al) {
            System.out.println(s);
        }

        int[] arr2 = {2, 3, 4};
        for (int x : arr2) {
            System.out.print(x + "\t");
        }
        System.out.println();

        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "aa1");
        hm.put(2, "aa2");
        hm.put(3, "aa3");

        Set<Integer> keySet = hm.keySet();
        for (Integer i : keySet) {
            System.out.println(i + "--" + hm.get(i));
        }

//		Set<Map.Entry<Integer, String>> entrySet =hm.entrySet();
//		for(Map.Entry<Integer, String> map :entrySet)
//		{}

        for (Map.Entry<Integer, String> map : hm.entrySet()) {
            System.out.println(map.getKey() + "--" + map.getValue());
        }

    }


    //集合转数组
    public static void collectionToArr() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("ddd1");
        al.add("ddd2");
        al.add("ddd3");

        String[] arr = al.toArray(new String[5]);
        System.out.println(Arrays.toString(arr));
    }

}
