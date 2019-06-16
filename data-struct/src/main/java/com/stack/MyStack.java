package com.stack;

import com.list.ListNode;

import java.util.List;

public class MyStack {
    public ListNode stackTop;
    public ListNode stackBottom;

    public MyStack(ListNode stackTop,ListNode stackBottom){
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    public  static void pushStack(MyStack myStack,int num){
        ListNode node = new ListNode(num);
        if(myStack == null){
            throw new RuntimeException("error");
        }
        node.next = myStack.stackTop;
        myStack.stackTop = node;
    }

    public  static void popStack(MyStack myStack){
        if(!isEmpty(myStack)){
            ListNode stackTop = myStack.stackTop;
            myStack.stackTop = stackTop.next;
            System.out.println("pop = " + stackTop.value);
        }
    }

    public  static  void travelStack(MyStack myStak){
        ListNode stackTop = myStak.stackTop;
        while(stackTop != myStak.stackBottom){
            System.out.println("node = " + stackTop.value);
            stackTop = stackTop.next;
        }
    }

    public static boolean isEmpty(MyStack stack){
        if(stack.stackTop == stack.stackBottom){
            return true;
        }else {
            return false;
        }
    }

    public static void clearStack(MyStack myStack){
        myStack.stackTop = null;
        myStack.stackBottom = myStack.stackTop;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(new ListNode(0),new ListNode(0));
        //栈底元素指向栈定
        stack.stackBottom = stack.stackTop;
        pushStack(stack,1);
        pushStack(stack,2);
        pushStack(stack,3);
        travelStack(stack);
        popStack(stack);
        boolean flag = isEmpty(stack);
        System.out.println("flag = " + flag);
        clearStack(stack);
        boolean flag2 = isEmpty(stack);
        System.out.println("flag = " + flag2);





    }
}
