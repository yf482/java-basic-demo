package com.collection;

import java.util.*;

public class HashMapDemo {


    public static void main(String[] args) {
        //put会返回键对应原来的值，第一次返回null.添加相同的键，后添加的值会覆盖原有的键对应的值
        Map<String, String> map = new HashMap<String, String>();
        System.out.println("put:" + map.put("01", "zhangsan1"));
        map.put("02", "zhangsan2");
        map.put("03", "zhangsan3");

        System.out.println(map.containsKey("01"));
        System.out.println(map.containsKey("011"));
        map.put("04", null);
        System.out.println(map.get("04"));

        Collection<String> coll = map.values();

        System.out.println(coll);

        //map集合两种取出方式
        //1.KeySet：将map中所有的键存入到Set集合.因为set具备迭代器。
        //所有可以将迭代方式取出所有的键，然后调用get方式取出

        //先获取map集合的所有键的Set集合，keySey()
        Set<String> keySet = map.keySet();
        //有了Set集合就可以获取其迭代器了
        Iterator<String> it = keySet.iterator();

        while (it.hasNext()) {
            String key = it.next();
            //有了键就可以获取键值了
            String value = map.get(key);
            System.out.println("key:" + key + "---value:" + value);
        }
        //2.将Map集合中映射关系复制到entrySet()
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry<String, String> me = it2.next();
            String key = me.getKey();
            String value = me.getValue();
            System.out.println("key:" + key + "---value---: " + value);

        }
    }

}
