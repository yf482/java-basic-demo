package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/** 
 * @author 作者 :
 * @version 创建时间：2017-3-13 下午5:44:25 
 * 类说明 
 */
public class LinkHashMapDemo {
	
	@Test
	public void test(){
		//使用LinkedHashMap则是跟原来存入的顺序是一致的。
		HashMap<Integer,String> hm = new LinkedHashMap<Integer,String>();
		hm.put(5, "123");
		hm.put(1, "123a");
		hm.put(4, "123s");
		hm.put(7, "1232");
		
		Iterator<Map.Entry<Integer, String>>  it = hm.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, String> en = it.next();
			Integer key = en.getKey();
			String value = en.getValue();
			System.out.println(key + "---" + value);
		}
	}
	

}
