package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class P0107BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        process(root, 0, ans);
        Collections.reverse(ans);
        return ans;
    }

    private void process(TreeNode node, int h, ArrayList<List<Integer>> list) {
        if (node == null){
            return;
        }
        if (h == list.size()){
            list.add(new ArrayList<>());
        }
        list.get(h).add(node.val);
        if (node.left != null){
            process(node.left, h + 1, list);
        }
        if (node.right != null){
            process(node.right, h+ 1, list);
        }
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
