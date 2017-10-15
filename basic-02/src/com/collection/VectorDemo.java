package com.collection;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * vector 内部是数组结构，增删比较慢，查询也慢，是同步的。
 * ArrayList 内部是数组结构，是不同步的， 替代了vector ,查询速度快
 * LinkLisk 内部是链表结构，查询慢，增删快。不同步。
 *
 * @author 作者 :
 * @version 创建时间：2017-3-13 下午3:01:29
 * 类说明
 */
public class VectorDemo {

    @Test
    public void test1() {
        Vector vc = new Vector();
        vc.addElement("ss1");
        vc.addElement("ss2");
        vc.addElement("ss3");
        vc.addElement("ss4");
        Enumeration enume = vc.elements();
        while (enume.hasMoreElements()) {
            System.out.println("nextElement" + enume.nextElement());
        }

        Iterator it = vc.iterator();
        while (it.hasNext()) {
            System.out.println("nextObj:" + it.next());
        }
    }


}
