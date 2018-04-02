package com.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author yunfeng
 * @version V.1.0
 * @Desc 集合构造方法中传入比较器
 * @create 2017/10/15 23:35
 **/
public class ComparatorDemo {

    @Test
    public void test1() {
        Comparator<String> cmp = new ComparatorByLen();
        Set<String> set = new TreeSet<String>(cmp);
        set.add("abc");
        set.add("a");
        set.add("ade");
        set.add("123");
        set.add("aaee");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


}

class ComparatorByLen implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int tempt = o1.length() - o2.length();

        return tempt == 0 ? o1.compareTo(o2) : tempt;
    }

}
