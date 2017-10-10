 package com.collection;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/**
 * TreeSet对元素进行排序的方式一： 让元素自身具备比较功能，元素就需要实现Comparable接口，覆盖compareTo方法。\
 * 如果不要按照对象中具备的自然顺序进行排序。如果对象中不具备自然顺序。怎么办？
 * 可以使用TreeSet集合第二种排序方式：
 * 让集合自身具备比较功能，定义一个类实现Comparator接口，覆盖compare方法。
 * 将该类对象作为参数传递给TreeSet集合的构造函数。
 * 
 * 如果自定义类实现了Comparable接口，并且TreeSet的构造函数中也传入了比较器，那么将以比较器的比较规则为准。
 * TreeSet集合的底层是二叉树进行排序的。
 * 
 * @author v_wbyfli
 *
 */
public class TreeSetDemo {

	@Test
	public void testCompareTo() {
		//根据compareTo >0 排在后面，<0排在前面
		TreeSet tr =new TreeSet();
		tr.add(new Cat("cat2",11));
		tr.add(new Cat("cat1",16));
		tr.add(new Cat("cat3",3));
		tr.add(new Cat("cat4",13));
		
		Iterator it =tr.iterator();
		while(it.hasNext())
		{
			Cat c =(Cat) it.next();
			System.out.println(c.getName()+"---"+c.getWeight());
		}
		
	}

}

class Cat  implements Comparable{
	private String name;
	private int weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Cat(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Cat)){
			throw new RuntimeException();
		}
		Cat c =(Cat) o;
		int tempt = this.weight - c.weight;
		/*if(this.weight>c.weight)
			return 1;
		if(this.weight==c.weight)
			return this.name.compareTo(c.name);
		return -1;*/
		return tempt == 0 ? this.name.compareTo(c.name) : tempt;
	}
	
	
	
}