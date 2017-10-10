package com.exception;


import java.util.Arrays;
import java.util.Scanner;
/*
 * һ���Թ̶��ٶ���ʻ����,�峿˾����̱��ϴ����ҵĶ���ʹ��ҵ���ļ�����һ���,
 * �������95859,2Сʱ��,��̱����ֳ���һ���µĶԳ���
 * ,�ʴ˳���ʱ���Ƕ���?����µĶԳ�����ʲô?����̱�Ϊ5λ����.
 * */
public class TestDuiCheng {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		is_duichen(1221);
		
		int initialNum=22322; //�����ǵ�һ�ε������
        Scanner scan = new Scanner(System.in);
        System.out.println("�����뵱ǰ�����:");
        String str=scan.nextLine();
        StringBuilder sb = new StringBuilder(str);
        scan.close();
        sb.reverse();
        String str1 = sb.toString();
        if(str.equals(str1)) {
            System.out.println("������ǻ���");
            int lastNum=Integer.parseInt(str);
            int speed=(lastNum-initialNum)/2;
            System.out.println("��ǰʱ��Ϊ��"+speed+"KM/ÿСʱ");
        } else {
            System.out.println("������ǻ���");
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
	       System.out.println("�ǶԳ���"+data);
	        return 0;
	    }
	    else
	    {
	        System.out.println(data+"���ǶԳ���");
	        return -1;
	    }
	}

}
