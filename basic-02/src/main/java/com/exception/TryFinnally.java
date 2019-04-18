package com.exception;

import java.util.ArrayList;
import java.util.List;

public class TryFinnally {

    public static void main(String[] args) {

//        int test = test2();
//        System.out.println("test = " + test);
//        List list = testWrap();
//        System.out.println("list = " + list);
        int i = testBasic4();
        System.out.println("i = " + i);
    }

    /**
     *  返回2
     * @return
     */
    public static int test1(){
        int x = 1;
        try
        {
            x++;
            return x;
        }
        finally
        {
            ++x;
        }
    }

    public static Integer test2(){
        Integer x = 1;
        try
        {
            x++;
            return x;
        }
        finally
        {
            ++x;
        }
    }

    public static Integer test3(){
        Integer x = 1;
        try
        {
            x++;
            return x;
        }
        finally
        {
            ++x;
            return x;
        }
    }

    public static  int testBasic(){
        int i = 1;
        try{
            i++;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
            return i;
        }
    }


    public static  int testBasic2(){
        int i = 1;
        try{
            i++;
            int m = i / 0 ;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
            return i;
        }
    }

    public static List<Object> testWrap(){
        List<Object> list = new ArrayList<>();
        try{
            list.add("try");
            System.out.println("try block");
            return list;
        }catch(Exception e){
            list.add("catch");
            System.out.println("catch block");
            return list;
        }finally{
            list.add("finally");
            System.out.println("finally block ");
        }
    }

    public static  int testBasic4(){
        int i = 1;
        try{
            i++;
            Integer.parseInt(null);
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            String.valueOf(null);
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            int m = i / 0;
            System.out.println("finally block i = "+i);
        }
    }
}
