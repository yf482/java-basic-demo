package com.collection;

import org.junit.Test;

public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str="abkkdkksskkakljkk";
		System.out.println(getSubCount2(str,"kk"));
		
		
//		String s1="sdfdfhellojlusaqqqoi";
//		String s2="defaxxhellozer";
//		System.out.println(getMaxString(s1, s2));
	}
	
	@Test
	public void test1(){
		
		String s1 ="kk";
		s1="abc";
		String s3="abc";
		String s2 =new String("abc");
		//string对象在内存的问题
		System.out.println(s1==s3);
		System.out.println(s1==s2);
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equalsIgnoreCase("ABC"));
		
		
		String s = "abcssadf";
		System.out.println(s.length());
		System.out.println(s.charAt(1));
		System.out.println(s.charAt(3));
		//不存在的，会java.lang.StringIndexOutOfBoundsException
//		System.out.println(s.charAt(11));
		System.out.println(s.indexOf("a"));
		System.out.println(s.indexOf("a",3));
		System.out.println(s.indexOf("a",12));
		System.out.println(s.lastIndexOf("f"));
	}
	
	@Test
	public void test2(){
		
		String s1 ="kdAck";
		char[] ch = s1.toCharArray();
		System.out.println(ch[2]);
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		
		String s2 = "abcdsss";
		System.out.println(s2.replace('c', 'd'));
		System.out.println(s2);
		System.out.println(s2.replace("ab", "ee"));
		//没有替换成功则返回原串
		System.out.println(s2.replace("aeab", "ee"));
		
		String  s3 =" abc ";
		System.out.println(s3.trim());
		System.out.println(s3.startsWith("a"));
		System.out.println(s3.endsWith("c"));
		
		//concat 和 + 区别效果更高
		System.out.println("bbb".concat("123"));
		//按字典顺序比较 ASCII
		System.out.println("abc".compareTo("acd"));
	
	}
	
	/**
	 * 获取字串的数量
	 * @param str
	 * @param key
	 * @return
	 */
	public static int getSubCount(String str,String key){
		
		int count=0;
		int index=0;
		while((index=str.indexOf(key))!=-1){
			str=str.substring(index+key.length());
			System.out.println(str);
			count++;
			
		}
		return count;
	}
	/**
	 * 获取字串的数量
	 * @param str
	 * @param key
	 * @return
	 */
	public static int getSubCount2(String str,String key){
			int count=0;
			int index=0;
			while((index=str.indexOf(key,index))!=-1){
				index = index+key.length();
//				str=str.substring(index+key.length());
				System.out.println(str.substring(index));
				count++;
			
			}
		return count;
	}
	
	/**
	 * 判断是否字串
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String getMaxString(String s1,String s2){
		String max="",min="";
		max = (s1.length()>s2.length())?s1:s2;
		min = (max==s1)?s2:s1;
		for(int x=0;x<min.length();x++)
		{
			for(int y =0,z=min.length()-x;z!=min.length();y++,z++)
			{
				String temp = min.substring(y,z);
//				System.out.println(temp);
				if(max.contains(temp))
					return temp;
			}
			
		}
		return "";
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String myTrim(String str){
		
		/**
		 * String str="   assd   ";
		p("("+str+")");
		str=myTrim(str);
		p("("+str+")");
		int a =999;
		String ss =a+"";
		String s2 = Integer.toString(a);
		 */
		int start=0;
		int end =str.length()-1;
		while(start<=end&&str.charAt(start)==' ')
			start++;
		while(start<=end&&str.charAt(end)==' ')
			end--;
		
		return str.substring(start,end+1);
	}
	
	
	private static String reverseArr(char[] ch) {
		
//		String str = "cccbbaaa";
//		char[] ch =str.toCharArray();
//		str = reverseArr(ch);
//		System.out.println(str);
		for(int start=0, end=ch.length-1;start<end;start++,end--)
		{
			swap(ch ,start,end);
		}
		return new String(ch);
	}


	private static void swap(char[] ch, int start, int end) {
		// TODO Auto-generated method stub
		char c = ch[start];
		ch[start]=ch[end];
		ch[end]=c;
	}
	
	/**
	 * 按照字典顺序排序数组----select sort
	 * @param arr
	 * @return
	 */	
	public void sortByDictionary(String [] arr){
		
		for(int x=0;x<arr.length-1;x++){
			for(int y=x+1;y<arr.length;y++){
				if(arr[x].compareTo(arr[y]) > 0){
					String temp = arr[x];
					arr[y] = arr[x];
					arr[x] = temp;
				}
			}
			
		}
		
	}
	
	
}
