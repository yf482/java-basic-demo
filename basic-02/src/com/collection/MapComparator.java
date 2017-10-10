package com.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class MapComparator {

	
	@Test
	public void test() {
		HashMap<Student,String> hm =new HashMap<Student,String>();
		hm.put(new Student("lisi1",21), "shanghai1");
		hm.put(new Student("lisi3",23), "shanghai2");
		hm.put(new Student("lisi4",24), "shanghai3");
		hm.put(new Student("lisi5",25), "shanghai4");
		Set<Student> keySet = hm.keySet();
		Iterator<Student>  it =keySet.iterator();
		while(it.hasNext())
		{
			Student stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu+"--"+addr);
			
		}
		Set<Map.Entry<Student, String>> entrySet = hm.entrySet();
		Iterator<Map.Entry<Student, String>> it2 =entrySet.iterator();
		
		while(it2.hasNext())
		{
			Map.Entry<Student, String> me = it2.next();
			Student stu =me.getKey();
			String addr =me.getValue();
			System.out.println(stu+"--"+addr);
		}
		

	}
	
	@Test
	public void test2() {
		HashMap<String,Student> hm =new HashMap<String,Student>();
		hm.put("shanghai1",new Student("lisi1",21));
		hm.put("shanghai2",new Student("lisi2",19));
		hm.put("shanghai3",new Student("lisi3",32));
		//achieve sort of student 
		Set<String> set = hm.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			Student stu = hm.get(it.next());
			System.out.println(stu);
		}
	}
	
	
	@Test
	public void testComparator() {
		TreeMap<Student,String> hm =new TreeMap<Student,String>(new StudentComparator());
		hm.put(new Student("lisi1",21),"shanghai1");
		hm.put(new Student("lisi2",21),"shanghai1");
		hm.put(new Student("lisi3",12),"shanghai1");
		//achieve sort of student 
		Set<Student> keySet = hm.keySet();
		Iterator<Student>  it =keySet.iterator();
		while(it.hasNext())
		{
			Student stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu+"--"+addr);
			
		}
	}

}
/**
 * achieve list sort student by comparator
 * @author v_wbyfli
 *
 */
class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int tempt = new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
		return tempt == 0 ? o1.getName().compareTo(o2.getName()) : tempt;
	}
	
}

/**
 * achieve student sort by implements comparable interface
 * @author v_wbyfli
 *
 */
class Student implements Comparable<Student> {
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public int hasCode()
	{
		return name.hashCode()+age*34;
	}
	public boolean equals(Object obj)
	{
		if(obj instanceof Student)
			throw new ClassCastException("参数传入student");
		Student s =(Student)obj;
		return this.name==s.getName()&&this.age==s.getAge();
		
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

	

	@Override
	public int compareTo(Student o) {
		//by int object -> Integer with compareTo function
		int num=new Integer(this.age).compareTo(new Integer(o.getAge()));
		if(num==0)
			return this.name.compareTo(o.getName());
		return num;
			
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}

