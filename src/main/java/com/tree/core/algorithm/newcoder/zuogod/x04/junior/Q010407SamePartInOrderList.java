package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 在行列都排好序的矩阵中找数
 *
 * 【题目】 给定一个有N*M的整型矩阵matrix和一个整数K,
 * matrix的每一行和每一 列都是排好序的。实现一个函数,判断K
 * 是否在matrix中。 例如: 0 1 2 5 2 3 4 7 4
 * 4 4 8 5 7 7 9 如果K为7,返回true;如果K为6,返
 * 回false。
 * 【要求】 时间复杂度为O(N+M),额外空间复杂度为O(1)。
 */
public class Q010407SamePartInOrderList {

    public Node samePart(Node n1, Node n2){
        if (n1 == null || n2 == null){
            return null;
        }
        Node c1 = n1;
        Node c2 = n2;
        while (c1 != null && c2 != null){
            if (c1.val < c2.val){
                c1 = c1.next;
            }else if (c1.val > c2.val){
                c2 = c2.next;
            }else {
                return c1;
            }
        }
        return null;
    }

    private class Node{
        int val;
        Node next;
    }

}
