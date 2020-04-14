package com.tree.core.algorithm.leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class P0019RemoveNthFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n){
        if (head == null || n < 0){
            return head;
        }
        ListNode tmp = new ListNode(0), fast = tmp, cur = tmp;
        tmp.next = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return tmp.next;
    }

    private class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
