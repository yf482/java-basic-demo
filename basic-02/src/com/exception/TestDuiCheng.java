package com.exception;


import java.util.Arrays;
import java.util.Scanner;
/*
 * 一辆以固定速度行驶的汽车,清晨司机看到里程表上从左到右的读数和从右到左的计数是一样的,
 * 这个数是95859,2小时后,里程表上又出现一个新的对称数
 * ,问此车的时速是多少?这个新的对称数是什么?设里程表为5位数字.
 * */
public class TestDuiCheng {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		is_duichen(1221);

		int initialNum=22322; //假设是第一次的里程数
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入当前里程数:");
		String str=scan.nextLine();
		StringBuilder sb = new StringBuilder(str);
		scan.close();
		sb.reverse();
		String str1 = sb.toString();
		if(str.equals(str1)) {
			System.out.println("里程数是回文");
			int lastNum=Integer.parseInt(str);
			int speed=(lastNum-initialNum)/2;
			System.out.println("当前时速为："+speed+"KM/每小时");
		} else {
			System.out.println("里程数不是回文");
		}
	}

	static int is_duichen(int data)
	{
		int tmp, new_data;
		tmp = data;
		new_data = 0;
		while(tmp>0)
		{
			new_data = new_data*10 + tmp/10;
			tmp = tmp/10;
		}

		if(new_data == data)
		{
			System.out.println("是对称数"+data);
			return 0;
		}
		else
		{
			System.out.println(data+"不是对称数");
			return -1;
		}
	}

}
