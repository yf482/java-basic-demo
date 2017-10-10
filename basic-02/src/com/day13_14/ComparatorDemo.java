package com.day13_14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/** 
 * @author 作者 :
 * @version 创建时间：2017-3-13 下午4:34:29 
 * 类说明 
 */
public class ComparatorDemo {
	
	@Test
	public void test1(){
		
		Comparator<String> cmp = new ComparatorByLen();
		Set<String> set = new TreeSet<String>(cmp);
		set.add("abc");
		set.add("a");
		set.add("ade");
		set.add("123");
		set.add("aaee");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	

}

class ComparatorByLen implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		int tempt = o1.length() - o2.length();
		
		return tempt == 0 ? o1.compareTo(o2) : tempt;
	}
	
}
