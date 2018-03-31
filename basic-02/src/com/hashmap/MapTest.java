package com.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-03-31 18:44
 **/
public class MapTest {

    @Test
    public void test1() {
        long startTime = System.currentTimeMillis();
        Map<String, String> jdkMap = new HashMap<String, String>();
        for (int i = 0; i < 2000; i++) {
            jdkMap.put("yf-" + i, "liyunfeng-" + i);
        }
        for (int i = 0; i < 2000; i++) {
            String value = jdkMap.get("yf-" + i);
            System.out.println("value = " + value);
        }
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        System.out.println("costTime = " + costTime);
    }

    @Test
    public void test2() {
        long startTime = System.currentTimeMillis();
        YFHashMap<String, String> myMap = new YFHashMap<String, String>();
        for (int i = 0; i < 2000; i++) {
            myMap.put("yf-" + i, "liyunfeng2-" + i);
        }
        System.out.println("myMap = " + myMap.getSize());
        for (int i = 0; i < 2000; i++) {
            String value = myMap.get("yf-" + i);
            System.out.println("value = " + value);
        }
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        System.out.println("costTime = " + costTime);

    }
}
