package com.tree.core.algorithm.leetcode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class P0025ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = null, cur = head, next = null, lastGroupTail = null, groupTail = null, ans = null;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 1; i * k <= len; i++) {
            groupTail = cur;
            for (int j = 0; j < k; j++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            if (lastGroupTail == null){
                ans = pre;
            }else {
                lastGroupTail.next = pre;
            }
            lastGroupTail = groupTail;
            groupTail.next = cur;
        }
        return ans;
    }

    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

}
