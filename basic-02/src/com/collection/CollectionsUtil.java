package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/** 
 * @author 作者 :
 * @version 创建时间：2017-3-13 下午5:51:07 
 * 类说明 
 */
public class CollectionsUtil {
	
	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("see");
		list.add("dog");
		list.add("chicken");
		list.add("lion");
			
		//sort collection by Collections
		Collections.sort(list);
		System.out.println(list);
		//input comparator
		Comparator cmp = new ComparatorByLength();
		Collections.sort(list, cmp);
		System.out.println(list);
		int index = Collections.binarySearch(list, "see");
		System.out.println(index);
		
		String max = Collections.max(list, cmp);
		System.out.println("max" + max);
		
		
		
		List<String> list2 = new ArrayList<String>();
		list2.add("see");
		list2.add("dog");
		list2.add("chicken");
		list2.add("lion");
		
		
		
	}
	
	@Test
	public void test2(){
		
		
		List<String> list2 = new ArrayList<String>();
		list2.add("see");
		list2.add("dog");
		list2.add("chicken");
		list2.add("lion");
		
		
		
	}
	
	

}

class ComparatorByLength implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		int gap = o1.length() - o2.length();
		
		return gap == 0 ? o1.compareTo(o2) : gap;
	}
	
}
