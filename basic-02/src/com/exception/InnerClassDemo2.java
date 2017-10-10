package com.exception;

public class InnerClassDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract class ABSDemo{
	abstract void show();
}

class Outer2
{
	int x=3;
	//�����ڲ��ࡣ
	class Inner2 extends ABSDemo
	{
		void show()
		{
			System.out.println("show:x="+x);
		}
	}
	
	public void  function()
	{
		//�����ڲ����൱��ʵ��abstract��ͷ����൱�� new �������ʵ�ַ������൱�ڴ�����һ��ʵ����
		new ABSDemo()
		{

			@Override
			void show() 
			{
				// TODO Auto-generated method stub
				System.out.println("show:x="+x);
			}
			
		}.show();
	}
}
