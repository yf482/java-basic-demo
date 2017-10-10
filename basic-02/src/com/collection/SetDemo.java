package com.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 * 哈希表确定元素是否相同
 * 1.判断的是两个元素的哈希值是否相同。
 * 如果相同，再判断两个对象的内容是否相同。
 * 2. 判断哈希值相同，其实判断的是对象的HashCode方法。判断内容相同，用的是equals方法。
 * 如果哈希值不同，不需要判断equals。
 *  HashSet 内部是哈希表，是不同步的
 * TreeSet 内部树结构，是不同步的。
 * set 的接口和collection 一致
 * 
 * @author v_wbyfli
 *
 */
public class SetDemo {

	@Test
	public  void test() {
		HashSet hs =new HashSet();
		hs.add(new Person1("z1",22));
		System.out.println(hs.add(new Person1("z1",22)));
		hs.add(new Person1("z3",23));
		hs.add(new Person1("z4",24));
		hs.add(new Person1("z5",25));
		Iterator it = hs.iterator();
		while(it.hasNext())
		{
			Person1 p =(Person1) it.next();
			System.out.println(p.getName()+"---"+p.getAge());
		}
		
	}
	
	@Test
	public  void testLinkHashSet() {
		//hashSet hash表的排序
		Set set =new HashSet();
		String str1 = "abc";
		String str2 = "bcd";
		String str3 = "sw";
		String str4 = "aabc";
		set.add(str1);
		set.add(str2);
		set.add(str3);
		set.add(str4);
		System.out.println(str1 + "-" + str1.hashCode());
		System.out.println(str2 + "-" + str2.hashCode());
		System.out.println(str3 + "-" + str3.hashCode());
		System.out.println(str4 + "-" + str4.hashCode());
		Iterator it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}

}

class Person1 
{
	private String name;
	private int age;
	@Override
	public int hashCode() {
		int hashCode = name.hashCode() + age*9;
		return hashCode;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person1))
			return false;
		
		Person1 other = (Person1) obj;
		System.out.println(this.name+"--equals---"+other.name);
		
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}