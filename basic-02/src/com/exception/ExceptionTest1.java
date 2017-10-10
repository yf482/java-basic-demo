package com.exception;

public class ExceptionTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rec rec=null;
//		try {
			rec = new Rec(-3, 4);
//		} catch (NoValueException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.println();
//		}
		rec.getArea();

	}

}
interface Shape{
	public void getArea();
}
class Rec implements Shape{
	private int len, wid;
	Rec(int len ,int wid){//throws NoValueException{
		if(len<=0||wid<=0)
			throw new NoValueException("���ַǷ�ֵ");
		this.len=len;
		this.wid=wid;
	}
	public void getArea(){
		System.out.println(len*wid);
	}
}

class NoValueException extends RuntimeException{
	NoValueException(String msg){
		super(msg);
	}
}


