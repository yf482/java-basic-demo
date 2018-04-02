package com.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2017-12-16 11:14
 **/
public class SyncCollection {


    @Test
    public void test() {
        int capacity = 130;
        float loadFactor = 0.75f;
        Map<String, String> map = new HashMap<>(capacity, loadFactor);
        //使用collecttions工具类可以使变为同步
        Collections.synchronizedMap(map);

    }

    @Test
    public void test2() {
        int capacity = 130;
        float loadFactor = 0.75f;
        Map<String, String> map = new HashMap<>(capacity, loadFactor);
        //使用collecttions工具类可以使变为同步
        synchronized (this) {
            map.put("key", "dd");
        }
        synchronized (this) {
            map.get("key");
        }

    }

    @Test
    public void test3() {
        int capacity = 130;
        float loadFactor = 0.75f;
        Map<String, String> map = new ConcurrentHashMap<>(capacity, loadFactor);

    }
}
