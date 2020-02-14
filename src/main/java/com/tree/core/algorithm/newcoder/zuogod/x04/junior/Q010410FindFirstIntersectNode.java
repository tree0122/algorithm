package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 两个单链表相交的一系列问题
 *
 * 【题目】 在本题中, 单链表可能有环, 也可能无环. 给定两个
 * 单链表的头节点 head1和head2, 这两个链表可能相交, 也可能
 * 不相交. 请实现一个函数,  如果两个链表相交, 请返回相交的
 * 第一个节点;如果不相交, 返回null 即可.  要求:如果链表1
 * 的长度为N, 链表2的长度为M, 时间复杂度请达到 O(N+M), 额外
 * 空间复杂度请达到O(1).
 */
public class Q010410FindFirstIntersectNode {

    public Node find(Node n1, Node n2){
        if (n1 == null || n2 == null){
            return null;
        }
        Node l1 = loopNode(n1);
        Node l2 = loopNode(n2);
        if (l1 == null && l2 == null){
            return noLoop(n1, n2);
        }
        if (l1 != null && l2 != null){
            return bothLoop(n1, n2, l1, l2);
        }
        return null;
    }

    private Node bothLoop(Node n1, Node n2, Node l1, Node l2) {
        Node c1 = n1;
        Node c2 = n2;
        if (l1 == l2){
            int delta = 0;
            while (c1.next != l1){
                delta++;
                c1 = c1.next;
            }
            while (c2.next != l2){
                delta--;
                c2 = c2.next;
            }
            if (delta < 0){
                c1 = n1;
                n1 = n2;
                n2 = c1;
                delta = -delta;
            }
            while (delta > 0){
                n1 = n1.next;
                delta--;
            }
            while (n1 != n2){
                n1 = n1.next;
                n2 = n2.next;
            }
            return n1;
        }else {
            c1 = l1.next;
            while (c1 != l1){
                if (c1 == l2){
                    return l2;
                }
                c1 = c1.next;
            }
            return null;
        }
    }

    private Node noLoop(Node n1, Node n2) {
        Node c1 = n1;
        Node c2 = n2;
        int delta = 0;
        while (c1.next != null){
            c1 = c1.next;
            delta++;
        }
        while (c2.next != null){
            c2 = c2.next;
            delta--;
        }
        if (c1 != c2){
            return null;
        }
        if (delta < 0){
            c1 = n1;
            n1 = n2;
            n2 = c1;
            delta = -delta;
        }
        while (delta > 0){
            c1 = n1.next;
            delta--;
        }
        c2 = n2;
        while (c1 != c2){
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1;
    }

    private Node loopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node c1 = head.next;
        Node c2 = head.next.next;
        while (c1 != c2){
            if (c2.next == null || c2.next.next == null){
                return null;
            }
            c1 = c1.next;
            c2 = c2.next.next;
        }
        c1 = head;
        while (c1 != c2){
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1;
    }

    private class Node{
        Node next;
    }

}
