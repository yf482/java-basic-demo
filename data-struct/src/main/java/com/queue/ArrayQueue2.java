package com.queue;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 */
public class ArrayQueue2 {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public ArrayQueue2(Stack<Integer> stackPush,Stack<Integer> stackPop){
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void push(Integer num){
        if(stackPush == null || stackPop == null){
            throw new RuntimeException("error");
        }
        this.stackPush.push(num);
    }

    public Integer poll(){
        if(stackPush == null || stackPop == null){
            throw new RuntimeException("error");
        }
        if(!stackPush.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public Integer peek(){
        if(stackPush == null || stackPop == null){
            throw new RuntimeException("error");
        }
        if(!stackPush.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        ArrayQueue2 queue = new ArrayQueue2(new Stack<Integer>(),new Stack<Integer>());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        Integer num = queue.peek();
        System.out.println("num = " + num);
        Integer num2 = queue.poll();
        System.out.println("num2 = " + num2);
        System.out.println(queue.stackPop);

    }

}
