package com.tree.core.algorithm.newcoder.zuogod.x04.senior;


/**
 * 介绍一种时间复杂度O(N), 额外空间复杂度O(1)的二叉树遍历方式,
 * N为二叉树的节点个数
 *
 * 学术中的概念: 线索二叉树
 *
 * morris遍历, 遍历标准: (当前节点cur)
 * 1. 如果cur无左孩子, 则cur右移: cur = cur.right
 * 2. 如果cur有左孩子, 找到左子树上最右的节点, 为mostRight
 *      a. mostRight的右指针为null, 则mostRight.right = cur, 然后cur左移: cur = cur.left
 *      b. mostRight的右指针为cur, 则mostRight.right = null, 然后cur右移: cur = cur.right
 */
public class Q020304Morris {

    public void in(Node head){
        if (head == null){
            return;
        }
        Node cur = head;
        Node mostRightInLeft = null;
        while (cur != null){
            mostRightInLeft = cur.left;
            if (mostRightInLeft != null){
                while (mostRightInLeft.right != null && mostRightInLeft.right != cur){
                    mostRightInLeft = mostRightInLeft.right;
                }
                if (mostRightInLeft.right == null){
                    mostRightInLeft.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRightInLeft.right = null;
                }
            }
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public void pre(Node head){
        if (head == null){
            return;
        }
        Node cur = head;
        Node mostRightInLeft = null;
        while (cur != null){
            mostRightInLeft = cur.left;
            if (mostRightInLeft != null){
                while (mostRightInLeft.right != null && mostRightInLeft.right != cur){
                    mostRightInLeft = mostRightInLeft.right;
                }
                if (mostRightInLeft.right == null){
                    mostRightInLeft.right = cur;
                    cur = cur.left;
                    System.out.println(cur.val);
                    continue;
                }else {
                    mostRightInLeft.right = null;
                }
            }else {
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

    public void post(Node head){
        if (head == null){
            return;
        }
        Node cur = head;
        Node mostRightInLeft = null;
        while (cur != null){
            mostRightInLeft = cur.left;
            if (mostRightInLeft != null){
                while (mostRightInLeft.right != null && mostRightInLeft.right != cur){
                    mostRightInLeft = mostRightInLeft.right;
                }
                if (mostRightInLeft.right == null){
                    mostRightInLeft.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRightInLeft.right = null;
                    printRightEdgeOnReverse(cur.left);
                }
            }
            cur = cur.right;
        }
        printRightEdgeOnReverse(head);
    }

    private void printRightEdgeOnReverse(Node head) {
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null){
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        cur = pre;
        pre = null;
        while (cur != null){
            System.out.println(cur.val);
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
    }

    private class Node{
        int val;
        Node left;
        Node right;
    }



}
