package com.list;

public class MyList {

    /**
     * head insert
     */
    public static void headInsert(ListNode head,ListNode newNode){
        ListNode old = head;
        head = newNode;
        head.next = old;
    }

    /**
     * taild insert
     */
    public static void tailInsert(ListNode tail,ListNode newNode){
        ListNode old = tail;
        tail = newNode;
        old.next = newNode;
        tail.next = null;
    }

    public static void travelList(ListNode head){
        ListNode index = head;
        while (index != null){
            System.out.print(index.value + " ");
            index = index.next;
        }
        System.out.println();
    }


    public static void insert(ListNode p,ListNode newNode){
        ListNode old = p.next;
        p.next = newNode;
        newNode.next = old;


    }

    /**
     * taild insert
     */
    public static int find(ListNode list,int value){

        int index = -1;
        int count = 0;
        while(list !=null){

            if(list.value == value){
                index = count;
                return index;
            }
            count ++;
            list = list.next;
        }
        return -1;
    }


    public static void delete(ListNode head,ListNode q){
        if( q!=null && q.next != null){
            ListNode p = q.next;
            q.value = p.value;
            q.next = p.next;
            p = null;
        }
        if(q.next == null){
            while(head != null){
                if(head.next !=null && head.next == q){
                    head.next = null;
                    break;
                }
            }
        }


    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3= new ListNode(13);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        travelList(listNode);
        headInsert(listNode,new ListNode(4));
        travelList(listNode);
        insert(listNode,new ListNode(5));
        travelList(listNode);
        tailInsert(listNode,new ListNode(6));
        travelList(listNode);
        delete(listNode,listNode2);
        travelList(listNode);

    }




}
