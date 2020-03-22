package com.tree.core.algorithm.leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 */
public class P0110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root){
        return height(root) >= 0;
    }

    private int height(TreeNode node) {
        if (node == null){
            return 0;
        }
        int leftH = height(node.left);
        if (leftH < 0){
            return -1;
        }
        int rightH = height(node.right);
        if (rightH < 0){
            return -1;
        }
        if (Math.abs(leftH - rightH) > 1){
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
