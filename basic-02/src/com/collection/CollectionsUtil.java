package com.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yunfeng
 * @version V.1.0
 * @Desc 默认比较器 自定义比较器
 * @create 2017/10/15 23:27
 **/
public class CollectionsUtil {

    @Test
    public void test1() {
        List<String> list = new ArrayList<String>();
        list.add("see");
        list.add("dog");
        list.add("chicken");
        list.add("lion");
        //sort collection by Collections 默认采用string比较
        Collections.sort(list);
        System.out.println(list);
        //input comparator 使用长度比较器
        Comparator cmp = new ComparatorByLength();
        Collections.sort(list, cmp);
        System.out.println(list);
        int index = Collections.binarySearch(list, "see");
        System.out.println(index);

        String max = Collections.max(list, cmp);
        System.out.println("max：" + max);

    }

}

class ComparatorByLength implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int gap = o1.length() - o2.length();

        return gap == 0 ? o1.compareTo(o2) : gap;
    }

}
