package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.LinkedList;

/**
 * 判断一棵二叉树是否是平衡二叉树
 *
 * 判断一棵二叉树是否是搜索二叉树
 *
 * 判断一棵二叉树是否是完全二叉树
 */
public class I0086Q020504IBT {

    /**
     * 判断一棵二叉树是否是平衡二叉树
     *
     * @param head
     * @return
     */
    public boolean isBT(Node head){
        return process(head) >= 0;
    }

    /**
     * 判断一棵二叉树是否是搜索二叉树
     *
     * @param head
     * @return
     */
    public boolean isBST(Node head){
        if (head == null){
            return true;
        }
        Node cur = head;
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

    /**
     * 判断一棵二叉树是否是完全二叉树
     *
     * @param head
     * @return
     */
    public boolean isCST(Node head){
        if (head == null){
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        Node cur = head;
        queue.offer(cur);
        Node left = null;
        Node right = null;
        boolean leaf = false;
        while (!queue.isEmpty()){
            cur = queue.poll();
            left = cur.left;
            right = cur.right;
            if (left == null && right != null){
                return false;
            }
            if (leaf && (left != null || right != null)){
                return false;
            }
            if (left != null){
                queue.offer(left);
            }
            if (right != null){
                queue.offer(right);
            }else {
                leaf = true;
            }
        }
        return true;
    }

    public int process(Node node){
        if (node == null){
            return 0;
        }
        int leftH = process(node.left);
        if (leftH < 0){
           return -1;
        }
        int rightH = process(node.right);
        if (rightH < 0){
            return -1;
        }
        if (Math.abs(leftH - rightH) > 1){
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }

    private class Node {
        int val;
        Node left;
        Node right;
    }

}
