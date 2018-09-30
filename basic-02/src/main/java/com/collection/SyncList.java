package com.collection;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncList {

    @Test
    public void test1() {
        List<String> strList = new ArrayList<>();
        Collections.synchronizedList(strList);
    }


}