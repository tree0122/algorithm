package com.tree.core.algorithm.leetcode;

public class P0160IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        int len1 = 0, len2 = 0, delta = 0;
        ListNode n1 = headA, n2 = headB;
        while (n1 != null){
            len1++;
            n1 = n1.next;
        }
        while (n2 != null){
            len2++;
            n2 = n2.next;
        }
        if (len1 < len2){
            n1 = headB;
            n2 = headA;
        }else {
            n1 = headA;
            n2 = headB;
        }
        delta = Math.abs(len1 - len2);
        while (delta > 0){
            n1 = n1.next;
            delta--;
        }
        while (n1 != null && n2 != null){
            if (n1 == n2){
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

}
