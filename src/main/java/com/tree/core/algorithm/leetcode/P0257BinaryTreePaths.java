package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class P0257BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root){
        ArrayList<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        process(root, "", res);
        return res;
    }

    private void process(TreeNode node, String s, ArrayList<String> res) {
        if (node.left == null && node.right == null){
            res.add(s + node.val);
        }
        if (node.left != null){
            process(node.left, s + node.val + "->", res);
        }
        if (node.right != null){
            process(node.right, s + node.val + "->", res);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
