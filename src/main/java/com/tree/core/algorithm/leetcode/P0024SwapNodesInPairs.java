package com.tree.core.algorithm.leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class P0024SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(0), after = null, pre = ans;
        ans.next = head;
        while (pre.next != null && pre.next.next != null){
            after = pre.next.next;
            pre.next.next = after.next;
            after.next = pre.next;
            pre.next = after;
            pre = after.next;
        }
        return ans.next;
    }

    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

}
