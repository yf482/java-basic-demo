package com.exception;

public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t =new Thread1();
//		t.start();//开启县城并执行run的方法
		t.run();//仅仅是对象调用方法，而线程创建了没有进行
		for(int i=1;i<60;i++){
			System.out.println("MainThread---"+i);
		}

	}

}
class Thread1  extends Thread{

	public void run(){
		for(int i=1;i<60;i++){
			System.out.println("Thread1---"+i);
		}
	}
}
