package com.tree.core.algorithm.leetcode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class P0203RemoveLinkedListElement {

    public ListNode removeElements(ListNode head, int val){
        ListNode pre = new ListNode(0), res = pre;
        pre.next = head;
        while (pre.next != null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}
