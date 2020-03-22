package com.tree.core.algorithm.leetcode;

import java.util.LinkedList;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class P0101SymmetricTree {

    public boolean isSymmetricTree(TreeNode root){
        if (root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        return node1.val == node2.val
                && isMirror(node1.left, node2.right)
                && isMirror(node1.right, node2.left);
    }

    public boolean isMirror(TreeNode root){
        if (root == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null){
                continue;
            }
            if (n1 == null || n2 == null){
                return false;
            }
            if (n1.val != n2.val){
                return false;
            }
            queue.offer(n1.left);
            queue.offer(n2.right);
            queue.offer(n1.right);
            queue.offer(n2.left);
        }
        return true;
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
