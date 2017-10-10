package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 取出 map 中的所有元素。
 * 原理，通过 keySet 方法获取 map 中所有的键所在的 set 集合，在通过 set 的迭代器获取到每一个键。
 * 再对每一个键通过 map 集合的 get 方法获取其对应的值即可。
 * Map常用的子类：
|--Hashtable：内部结构是哈希表，是同步的。不允许null作为键，null作为值。
|--Properties：用来存储键值对型的配置文件的信息，可以和IO技术相结合。
|--HashMap：内部结构式哈希表，不是同步的。允许null作为键，null作为值。
|--TreeMap：内部结构式二叉树，不是同步的。可以对Map结合中的键进行排序。
hashSet实现Set接口，由哈希表（实际上是一个HashMap实例）支持。

 * 
 * @author v_wbyfli
 *
 */
public class MapTest {

	@Test
	public void testBasic() {
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("put:"+map.put("01", "zhangsan1"));
		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");
		
		System.out.println(map.containsKey("01"));
		System.out.println(map.containsKey("011"));
		map.put("04",null);
		System.out.println(map.get("04"));
		//map.values()
		Collection <String> coll =map.values();
		System.out.println(coll);
		//by keyset get Obj
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext())
		{
			String key =it.next();
			String value =map.get(key);
			System.out.println("key:"+key+"---value:"+value);
		}
		//by entrySet get Obj
		/*
		通过Map转成Set就可以迭代。
		找到了另一个方法，entrySet。
		该方法将键和值的映射关系作为对象存储到了Set集合中，而这个映射关系的类型就是Map.Entry类型
		*/
		Set<Map.Entry<String, String>> entrySet =map.entrySet();
		Iterator <Map.Entry<String, String>> it2 =entrySet.iterator();
		
		while(it2.hasNext())
		{
			Map.Entry<String, String> me = it2.next();
			String key =me.getKey();
			String value =me.getValue();
			System.out.println("key:"+key+"---value---: "+value);
			
		}
	}

	@Test
	public  void test() {
		/*
		HashMap<String,HashMap<String,String>>  czbk =new HashMap<String,HashMap<String,String>>();
		
		HashMap<String,String>  yuyeban =new HashMap<String,String>();
		HashMap<String,String>  jiuyeban=new HashMap<String,String>();
		
		czbk.put("yuye",yuyeban);
		czbk.put("jiuye",jiuyeban);
		
		yuyeban.put("01", "zhangsan1");
		yuyeban.put("02", "zhangsan2");
		
		jiuyeban.put("01", "lisi1");
		jiuyeban.put("02", "lisi2");
		
		
//		getStudentInfo(yuyeban);
//		getStudentInfo(jiuyeban);
		
		Iterator<String> it2 = czbk.keySet().iterator();
		while(it2.hasNext())
		{
			String roomName =it2.next();
			System.out.println(roomName);
			HashMap<String,String>  roomMap =czbk.get(roomName);
			getStudentInfo(roomMap);
			
		}
		*/
		
		demo();
	}
	
	public static   void getStudentInfo(HashMap<String ,String> roomMap)
	{
		Iterator<String> it = roomMap.keySet().iterator();
		while(it.hasNext())
		{
			String id =it.next();
			String name =roomMap.get(id);
			System.out.println(id+"--"+name);
		}
	}
	
	@Test
	public  void demo()
	{
		HashMap<String,List<Student>> czbk = new HashMap<String,List<Student>>();
		List<Student>  yuye =new ArrayList<Student>();
		List<Student>  jiuye=new ArrayList<Student>();
		czbk.put("yuyeban", yuye);
		czbk.put("jiuyeban", jiuye);
		
		yuye.add(new Student("zhangsan1",13));
		yuye.add(new Student("zhangsan2",14));
		
		jiuye.add(new Student("lisi1",22));
		jiuye.add(new Student("lisi2",23));
		
		Iterator<String> it =czbk.keySet().iterator();
		
		while(it.hasNext())
		{
			String roomName =it.next();
			List<Student> room =czbk.get(roomName);
			System.out.println(room);
			getInfo(room);
			
		}
		
		
	}
	
	public static void getInfo(List<Student>  stu)
	{
		Iterator<Student> it  = stu.iterator();
		while(it.hasNext())
		{
			Student s =it.next();
			System.out.println(s);
		}
	}

}
