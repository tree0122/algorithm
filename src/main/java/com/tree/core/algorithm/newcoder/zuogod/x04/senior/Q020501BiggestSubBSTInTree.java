package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.HashMap;

/**
 * 给定一棵二叉树的头节点head,请返回最大搜索二叉子树的大小
 *
 * 树行dp 通用方法论:
 * 1. 列可能性
 * 2. 简化信息
 * 3. 改递归
 */
public class Q020501BiggestSubBSTInTree {

    public int maxSize(Node head){
        return process(head).size;
    }

    public RetData process(Node node){
        if (node == null){
            return new RetData(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        RetData leftD = process(node.left);
        RetData rightD = process(node.right);
        if (leftD.head == node.left
                && rightD.head == node.right
                && leftD.max < node.val
                && rightD.min > node.val
        ){
            return new RetData(
                    node,
                    leftD.size + rightD.size + 1,
                    leftD.min,
                    rightD.max
            );
        }
        return leftD.size >= rightD.size ? leftD : rightD;
    }

    private class RetData{
        Node head;
        int size;
        int max;
        int min;

        public RetData(Node head, int size, int max, int min) {
            this.head = head;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    private class Node{
        int val;
        Node left;
        Node right;
    }
}
