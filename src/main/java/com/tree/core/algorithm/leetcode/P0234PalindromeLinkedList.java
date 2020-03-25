package com.tree.core.algorithm.leetcode;

import java.util.LinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 */
public class P0234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head){
        ListNode cur = head;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()){
            if (stack.pop().val != cur.val){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
