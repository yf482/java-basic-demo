package com.exception;

public class DiguiDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		koo(10);

	}
	
	public static void koo(int num){
		if(num>0){
			koo(num/2);
		System.out.print(num+"\t");
		}
	}

}
