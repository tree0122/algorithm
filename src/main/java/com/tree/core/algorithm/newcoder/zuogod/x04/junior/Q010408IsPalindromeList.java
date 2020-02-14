package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.ArrayDeque;

/**
 * 判断一个链表是否为回文结构
 *
 * 【题目】 给定一个链表的头节点head,请判断该链表是否为回
 * 文结构。 例如: 1->2->1,返回true。 1->2->2->1,返回true。
 * 15->6->15,返回true。 1->2->3,返回false。
 * 进阶: 如果链表长度为N,时间复杂度达到O(N),额外空间复杂
 * 度达到O(1)。
 */
public class Q010408IsPalindromeList {

    public boolean isP(Node head){
        if (head == null){
            return true;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            if (cur.val != stack.pop().val){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public boolean best(Node head){
        if (head == null){
            return true;
        }
        Node c1 = head;
        Node c2 = head;
        while (c2.next != null && c2.next.next != null){
            c1 = c1.next;
            c2 = c2.next.next;
        }
        c2 = c1;
        c1 = c2 = reverse(c2.next);
        boolean ans = true;
        while (c2 != null){
            if (head.val != c2.val){
                ans = false;
                break;
            }
            head = head.next;
            c2 = c2.next;
        }
        reverse(c1);
        return ans;
    }

    private Node reverse(Node head){
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private class Node{
        int val;
        Node next;
    }

}
