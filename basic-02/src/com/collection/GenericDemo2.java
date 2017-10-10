package com.collection;

public class GenericDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Inter<T>{
	void show(T t);
}

class InterImpl<T> implements Inter<T>{

	@Override
	public void show(T t) {
		// TODO Auto-generated method stub
		System.out.println("show --"+t);
	}

	
	
}