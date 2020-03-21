package com.tree.core.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class P0021MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0), cur = head;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null){
            cur.next = l1;
        }
        if (l2 != null){
            cur.next = l2;
        }
        return head.next;
    }

    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }


}
