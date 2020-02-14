package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 反转单向和双向链表
 *
 * 【题目】 分别实现反转单向链表和反转双向链表的函数。
 * 【要求】 如果链表长度为N,时间复杂度要求为O(N),额外空间
 * 复杂度要求为O(1)
 */
public class Q010404ReverseList {

    public Node reverse(Node head){
        if (head == null){
            return null;
        }
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

    public Denode reverse(Denode head){
        if (head == null){
            return null;
        }
        Denode cur = head;
        Denode pre = null;
        Denode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            cur.prev = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private class Denode{
       Denode prev;
       Denode next;
    }

    private class Node{
        Node next;
    }

}
