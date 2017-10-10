package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import org.junit.Test;



public class CollectionDemo {

	@Test
	public  void listUse()
	{
		Collection al = new  ArrayList();
		
		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		al.add("abc4");
		System.out.println("al"+al);
		al.remove(2);
		System.out.println("a2"+al);
		System.out.println("ss:"+al.contains("abc1"));
		//al.clear();
		
		System.out.println(al.isEmpty());
		
		Collection al2 = new  ArrayList();
		//add collection c
		al2.addAll(al);
		//add object
		al2.add("abc1");
		al2.add("abc22");
		al2.add("abc33");
		al2.add("abc44");
		System.out.println(al2);
		//intersection 
		al.retainAll(al2);
		System.out.println(al);
		
	}
	@Test
	public  void iteratorUse()
	{
		ArrayList al = new ArrayList();
		al.add("ab1");
		al.add("ab2");
		al.add("ab3");
		al.add("ab4");	
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		//for is efficient
//		for(Iterator it1 = al.iterator();it1.hasNext();)
//		{
//			System.out.println(it1.next());
//		}
	}
	@Test
	public  void ListIteratorUse()
	{
		ArrayList al = new ArrayList();
		al.add("ab1");
		al.add("ab2");
		al.add("ab3");
		al.add("ab4");
		System.out.println(al);
		ListIterator it = al.listIterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if(obj.equals("ab2"))
			{
				it.set("aaa");
			}
		}
		System.out.println(al);
		System.out.println(it.hasNext());
		System.out.println(it.hasPrevious());
		//iterator can alter element
		while(it.hasPrevious())
		{
			Object obj = it.previous();
			System.out.println(obj);
		}
	}
	
	@Test
	public  void collSearch(){
		ArrayList al = new ArrayList();
		al.add("ab1");
		al.add("ab2");
		al.add("ab3");
		al.add("ab4");
		System.out.println(al);
		al.add(1, "ab5");
		System.out.println(al);
		al.remove(2);
		System.out.println(al);
		al.set(1, "bbb");
		System.out.println(al);
		System.out.println(al.get(1));
		for(int x=0;x<al.size();x++)
		{
			System.out.print(al.get(x)+"--");
		}
	}
	
	
	
	@Test
	public  void collCalculate(){
		Collection al = new ArrayList();
		al.add("ab1");
		al.add("ab2");
		al.add("ab3");
		al.add("ab4");
		Collection al2 = new ArrayList();
		al2.add("ab1");
		al2.add("ab2");
		System.out.println(al.contains("ab1"));
		System.out.println(al.containsAll(al2));
		al.removeAll(al2);
		showCollection(al);
		
//		al.clear();
//		al.remove(1);
		al.remove("ab3");
		showCollection(al);
		
		
	}
	
	@Test
	public  void collCalculate2(){
		Collection al = new ArrayList();
		al.add("ab1");
		al.add("ab2");
		al.add("ab3");
		al.add("ab4");
		Collection al2 = new ArrayList();
		al2.add("ab1");
		al2.add("ab2");
		
		al.retainAll(al2);
		
		showCollection(al);
		
		
	}
	public static void showCollection(Collection c){
		Iterator it = c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	

}
