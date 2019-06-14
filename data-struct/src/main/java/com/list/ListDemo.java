package com.list;

import org.junit.Test;


/**
 * @ClassName: ListDemo
 * @Description: TODO
 * @Author yunfeng
 * @Date 2019-06-14
 * @Version V1.0
 **/
public class ListDemo {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3= new ListNode(13);

        listNode.next = listNode2;
        listNode2.next = listNode3;

        MyList.travelList(listNode);
        //反转链表
        ListNode nodes = reverseNode(listNode);

        MyList.travelList(nodes);

        //取中间值
        ListNode midNode = getMid(nodes);

        System.out.println("midNode = " + midNode.value);

    }

    @Test
    public void testMerge(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node3.next = node4;

//        ListNode head = mergeTwoList(node1,node3);
//        MyList.travelList(head);

        ListNode head2 = mergeTwoList2(node1,node3);
        MyList.travelList(head2);
    }

    /**
     * 反转数组
     * @param head
     * @return
     */
    public static ListNode reverseNode(ListNode head){
        ListNode pre = null;//当前节点上一个节点
        ListNode next = null;//当前节点下一个节点
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;


    }

    /**
     * 取中间节点（偶数节点取中间节点前面一个节点）
     * 原理：快、慢指针
     * @param head
     * @return
     */
    public static ListNode getMid(ListNode head){
        if(head == null){
            return null;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode.next != null && fastNode.next.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

        }
        return slowNode;
    }


    /**
     * 合并两个链表  -- 递归形式
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoList(ListNode head1,ListNode head2){
        if(head1 == null && head2 == null){
            return null;
        }

        if(head1 == null){
            return head2;
        }

        if(head2 == null){
            return head1;
        }

        ListNode head = null;
        if(head1.value < head2.value){
            head = head1;
            head.next = mergeTwoList(head1.next,head2);
        }else {
            head = head2;
            head.next = mergeTwoList(head1,head2.next);
        }

        return head;
    }



    /**
     * 合并两个链表  -- 循环形式
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoList2(ListNode head1,ListNode head2){
        if(head1 == null || head2 == null){
            return head1 != null ? head1 : head2;
        }

        ListNode head  = head1.value  < head2.value ? head1 : head2;

        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;

        ListNode pre = null ;//cur1的前一个元素
        ListNode next = null ;//cur2的前一个元素

        while(cur1 != null && cur2 != null){
            if(cur1.value < cur2.value){
                pre = cur1;
                cur1 = cur1.next;
            }else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;

        return head;
    }



    /**
     * 链表奇数位升序，偶数位降序，合并两个链表，要求时间复杂度O(n)
     * 1、奇数和偶数位拆分为两个链表
     * 2、偶数位链表反转
     * 3、合并两个链表
     *
     * @param head
     * @return
     */
    public static ListNode[] splitNodeList(ListNode head){
       ListNode head1 = null;
       ListNode head2 = null;

       ListNode cur1 = null;
       ListNode cur2 = null;

       int count = 1;
       while(head != null){
           if(count % 2 == 1){
                if(cur1 != null){
                    cur1.next = head;
                    cur1 = cur1.next;
                }else {
                    cur1 = head;
                    head1 = cur1;
                }
                
           }else {
               if(cur2 != null){
                   cur2.next = head;
                   cur2 = cur2.next;
               }else {
                   cur2 = head;
                   head2 = cur2;
               }

           }
           head = head.next;
           count++;
        }


        ListNode [] nodes = new ListNode[]{head1,head2};

        return  nodes;
    }

    @Test
    public  void handleNode(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode [] nodes = splitNodeList(node1);

        ListNode head1 = nodes[0];
        ListNode head2 = nodes[1];

        head2  = reverseNode(head2);

        ListNode result = mergeTwoList(head1,head2);

        MyList.travelList(result);
    }


}
