package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 *
 * 【题目】 给定一个单向链表的头节点head,节点的值类型是整型,再给定一个
 * 整 数pivot. 实现一个调整链表的函数,将链表调整为左部分都是值小于 pivot
 * 的节点,中间部分都是值等于pivot的节点,右部分都是值大于 pivot的节点.
 * 除这个要求外,对调整后的节点顺序没有更多的要求.  例如:链表9->0->4->5-
 * >1,pivot=3.  调整后链表可以是1->0->4->9->5,也可以是0->1->9->5->4. 总
 * 之,满 足左部分都是小于3的节点,中间部分都是等于3的节点(本例中这个部
 * 分为空),右部分都是大于3的节点即可. 对某部分内部的节点顺序不做 要求.
 * 进阶: 在原问题的要求之上再增加如下两个要求.
 * 在左、中、右三个部分的内部也做顺序要求,要求每部分里的节点从左 到右的
 * 顺序与原链表中节点的先后次序一致.  例如:链表9->0->4->5->1,pivot=3.
 * 调整后的链表是0->1->9->4->5.  在满足原问题要求的同时,左部分节点从左到
 * 右为0、1. 在原链表中也 是先出现0,后出现1;中间部分在本例中为空,不再
 * 讨论;右部分节点 从左到右为9、4、5. 在原链表中也是先出现9,然后出现4,
 * 最后出现5.
 * 如果链表长度为N,时间复杂度请达到O(N),额外空间复杂度请达到O(1).
 */
public class I0030Q010411SmallEqualBig {

    public Node better(Node head, int num){
        Node less = new Node(), lessB = less;
        Node equal = new Node(), equalB = equal;
        Node more = new Node(), moreB = more;
        while (head != null){
            if (head.val == num){
                equal.next = head;
                equal = equal.next;
            }else if (head.val < num){
                less.next = head;
                less = less.next;
            }else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        equal.next = moreB.next;
        less.next = equalB.next;
        return lessB.next;
    }

    public Node part(Node head, int num){
        if (head == null || head.next == null){
            return head;
        }
        Node s1 = null;
        Node s2 = null;
        Node e1 = null;
        Node e2 = null;
        Node b1 = null;
        Node b2 = null;
        Node c = head;
        while (c != null){
            if (c.val == num){
                if (e1 == null){
                    e1 = e2 = c;
                }
                e2.next = c;
                e2 = c;
            }else if (c.val < num){
                if (s1 == null){
                    s1 = s2 = c;
                }
                s2.next = c;
                s2 = c;
            }else {
                if (b1 == null){
                    b1 = b2 = c;
                }
                b2.next = c;
                b2 = c;
            }
            c = c.next;
        }
        if (s1 == null){
            if (e1 == null){
                return b1;
            }else {
                e2.next = b1;
                return e1;
            }
        }else {
            if (e1 == null){
                s2.next = b1;
            }else {
                s2.next = e1;
                e2.next = b1;
            }
            return s1;
        }
    }

    private class Node{
        int val;
        Node next;
    }

}
