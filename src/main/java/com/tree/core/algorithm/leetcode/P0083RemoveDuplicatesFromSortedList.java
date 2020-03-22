package com.tree.core.algorithm.leetcode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class P0083RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return null;
        }
        ListNode cur = head.next, res = head, pre = head;
        while (cur != null){
            if (pre.val != cur.val){
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
