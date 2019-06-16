package com.list;

public class MergeSortList {


    public static ListNode  mergeSortList(ListNode head){
        if(head == null && head.next == null){
            return head;
        }
        ListNode mid = fingMidNode(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode  left = mergeSortList(head);
        ListNode  right = mergeSortList(head2);
        return mergeSort(left,right);
    }

    /**
     * 前提链表都时间从小到大排序
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode mergeSort(ListNode head1, ListNode head2) {

        ListNode head = head1.value < head2.value ? head1 : head2;

        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;

        //cur1的前一个节点
        ListNode pre = null;
        //cur的后一个节点
        ListNode next = null;
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

    private static ListNode fingMidNode(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
