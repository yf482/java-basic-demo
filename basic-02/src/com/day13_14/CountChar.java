package com.day13_14;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CountChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		charCount("sfsdj,,,fjek222hskahfklda");
	}
	
	public static String charCount(String str)
	{
		char[] chs = str.toCharArray();
		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
		int count=0;
		for(int i=0;i<chs.length;i++)
		{
			if(!(chs[i]>='a'&&chs[i]<='z'||chs[i]>='A'&&chs[i]<='Z'))
				continue;
			Integer value =tm.get(chs[i]);
			
			if(value!=null)
				count=value;
			count++;
			tm.put(chs[i],count);
			count=0;
				
			//һ���Ч��
			/*
			if(value==null)
			{
				tm.put(chs[i], 1);
				
			}
			else
			{
				value =value+1;
				tm.put(chs[i],value);
			}
			*/
		}
		System.out.println(tm);
		StringBuffer sb =new StringBuffer();
		Set<Entry<Character,Integer>> entrySet =tm.entrySet();
		Iterator<Entry<Character, Integer>> it = entrySet.iterator();
		while(it.hasNext())
		{
			Entry<Character,Integer> me = it.next();
			Character ch  =me.getKey();
			Integer value =me.getValue();
			sb.append(ch+"("+value+")--");
		}
		System.out.println(sb);
		return null;
	}

}
