package com.exception;

public class MultiThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Thread1()).start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(new Thread2()).start();
		
		
		
		
	}
	
	private static class Thread1 implements Runnable
	{

		@Override
		public void run() {
			/*���������Thread1�������Thread2�ڲ���run������ͬһ������Ϊ������
			�������ﲻ����this����Ϊ��thread2�����his�����Thread1��this����ͬһ������
			������MultiThread.class ����ֽ�����󣬵�ǰ�������������������ǣ�ָ��Ķ���ͬһ������
			*/
			synchronized (MultiThread.class) {
				System.out.println("enter thread1");
				System.out.println("thread1 is waiting");
				
				/*
				 * �ͷ��������ַ�ʽ����һ�ַ�ʽ�ǳ�����Ȼ�뿪�������ķ�Χ��Ҳ�����뿪��synchronized�ؼ��ֹ�Ͻ
				 * �Ĵ��뷶Χ�������з�ʽ������synchronized�ؼ��ӹ�Ͻ�Ĵ����ڲ����ü����������wait����������ʹ��wait�����ͷ���
				 * */
				try {
					MultiThread.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread1 is going on...");
				System.out.println("thread1 is being over!");
				
			}
			
		}
		
	}
	
	private static class Thread2 implements Runnable{

		@Override
		public void run() {
			
			synchronized (MultiThread.class) {
				System.out.println("enter thread2...");
				System.out.println("thread2 notify other thread can release wait status..");
			MultiThread.class.notify();
			System.out.println(" thread2 is sleeping ten millisecond");
			/*
			 * ����notify�����ͷ���
			 * ��ʱthread2���������sleep������Ϣ��10���룬��thread1��Ȼ����ִ�У�
			 * ��Ϊthread2û���ͷ���
			 * ����thread1�޷��ò�����
			 * */
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("thread2 is going on...");
			System.out.println("thread2 is being over!");
			}
		}
		
	}

}

