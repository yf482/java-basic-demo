package com.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class FangXingDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		al.add("aa1");
		al.add("aa2");
		al.add("aa3");
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(1);
		al2.add(2);
		al2.add(3);
		pritColl(al);
		pritColl(al2);
		
	}
	public static void pritColl(ArrayList<?> al)//��ռλ����ȷ����
	{
		Iterator<?> it =al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	//ArrayList<Student> al = new  ArrayList<Person>();�������ͱ���һ�� 
	public static <T> void pritColl2(ArrayList<T> al)//������ȷ����
	{
		Iterator<T> it =al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}


