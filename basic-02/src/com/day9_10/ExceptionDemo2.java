package com.day9_10;

public class ExceptionDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Demo d = new Demo();
        try {
            d.div(5, 0);
//		}catch(Exception e){
//			System.out.println(e.toString());
//			e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("����Խ����");
        } catch (ArithmeticException e) {
            System.out.println("������");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }

}

class Demo {
    int div(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        int[] arr = new int[a];
        System.out.println(arr[4]);
        return a / b;
    }
}
