package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 是否为搜索二叉树
 *
 * 思路:
 * 1. 中序遍历过程中, 前一个数 与 当前数 比较
 */
public class I0035Q010505IsSearchTree {

    public boolean isS(Node node){
        if (node == null){
            return true;
        }
        Node cur = node;
        Node mostRightInLeft = null;
        Node pre = null;
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
            if (pre != null && pre.val >= cur.val){
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

    private class Node{
        int val;
        Node left;
        Node right;
    }

}
