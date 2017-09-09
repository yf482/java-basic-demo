package com.thinkjava.proctrl;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc For
 * @create 2017-09-09 13:20
 **/
public class ForTest {
    public static void main(String[] args) {
        for(char c = 0;c<128;c++){
            if(Character.isLowerCase(c)){
                System.out.println("c = " + (int)c + "-" + c);
            }
        }
        commaOperator();
    }

    static void commaOperator(){
        for(int i=1,j=i + 10;i<5;i++, j=i*2){
            System.out.println("i = " + i);
            System.out.println("j = " + j);


        }
    }
}
