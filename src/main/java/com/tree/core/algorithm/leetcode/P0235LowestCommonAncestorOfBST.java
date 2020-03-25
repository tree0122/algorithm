package com.tree.core.algorithm.leetcode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in
 * T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class P0235LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, q, q);
        }
        return root;
    }

    public TreeNode awesome(TreeNode root, TreeNode p, TreeNode q){
        TreeNode cur = root;
        while (cur != null){
            if (p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            }else if (p.val > cur.val && q.val > cur.val){
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
