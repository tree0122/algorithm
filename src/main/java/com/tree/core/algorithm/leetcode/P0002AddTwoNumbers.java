package com.tree.core.algorithm.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class P0002AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode ans = null;
        ListNode t = null;
        int delta = 0;
        while (c1 != null || c2 != null){
            int v1 = c1 != null ? c1.val : 0;
            int v2 = c2 != null ? c2.val : 0;
            int v = v1 + v2 + delta;
            int val = v >= 10 ? v - 10 : v;
            delta = v >= 10 ? 1 : 0;
            if (ans == null){
                ans = t = new ListNode(val);
            }else {
                t.next = new ListNode(val);
                t = t.next;
            }
            if (c1 != null){
                c1 = c1.next;
            }
            if (c2 != null){
                c2 = c2.next;
            }
        }
        if (delta > 0){
            t.next = new ListNode(delta);
        }
        /*
        while (c1 != null && c2 != null){
            int c = c1.val + c2.val + delta;
            int val = c >= 10 ? c - 10 : c;
            delta = c >= 10 ? 1 : 0;
            if (ans == null){
                ans = t = new ListNode(val);
            }else {
                t.next = new ListNode(val);
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null){
            int c = c1.val + delta;
            int val = c >= 10 ? c - 10 : c;
            delta = c >= 10 ? 1 : 0;
            if (ans == null){
                ans = t = new ListNode(val);
            }else {
                t.next = new ListNode(val);
            }
            c1 = c1.next;
        }
        while (c2 != null){
            int c = c2.val + delta;
            int val = c >= 10 ? c - 10 : c;
            delta = c >= 10 ? 1 : 0;
            if (ans == null){
                ans = t = new ListNode(val);
            }else {
                t.next = new ListNode(val);
            }
            c2 = c2.next;
        }
        if (delta > 0){
            t.next = new ListNode(delta);
        }*/
        return ans;
    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
}
