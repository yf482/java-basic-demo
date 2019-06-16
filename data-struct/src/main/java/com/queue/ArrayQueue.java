package com.queue;

/**
 * 队列形式实现队列
 */
public class ArrayQueue {
    public int [] arrays;
    public int front;//队列头
    public int rear;//队列尾部

    public ArrayQueue(int [] arrays,int front,int rear){
        this.arrays = arrays;
        this.front = front;
        this.rear = rear;
    }

    /**
     *判断是否为满
     * @param queue
     * @return
     */
    public static boolean isFull(ArrayQueue queue){
        int num = (queue.rear + 1) % queue.arrays.length;
        if(num == queue.front){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 判断是否为空
     * @param queue
     * @return
     */
    public static boolean isEmpty(ArrayQueue queue){
        if(queue.front == queue.rear){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 入队
     * @param queue
     * @param value
     */
    public static void  enQueue(ArrayQueue queue,int value){
        if(!isFull(queue)){
            queue.arrays[queue.rear] = value;
            queue.rear = (queue.rear + 1) % queue.arrays.length;
        }
    }

    /**
     * 遍历
     * @param queue
     */
    public static void travelQueue(ArrayQueue queue){
            int i = queue.front;
        while( i!= queue.rear){
            System.out.println("i = " + queue.arrays[i] + " ");
            i= (i+1) % queue.arrays.length;
        }
        System.out.println();
    }


    public static void outQueue(ArrayQueue queue){
        if(!isEmpty(queue)){
            int value = queue.arrays[queue.front];
            System.out.println("value = " + value);
            queue.front = (queue.front + 1) % queue.arrays.length;
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(new int[5],0,0);
        boolean isEmpty = isEmpty(queue);
        System.out.println("isEmpty = " + isEmpty);
        enQueue(queue,1);
        enQueue(queue,2);
        enQueue(queue,3);
        enQueue(queue,4);
        System.out.println(isFull(queue));
        travelQueue(queue);
        outQueue(queue);

    }
}
