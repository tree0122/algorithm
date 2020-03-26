package com.tree.core.algorithm.leetcode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 */
public class P0270ClosestBSTValue {

    public int closestValue(TreeNode root, double target){
        TreeNode cur = root;
        int ans = cur.val;
        while (cur != null){
            if (Math.abs(cur.val - target) < Math.abs(ans - target)){
                ans = cur.val;
            }
            if (target < cur.val){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return ans;
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

}
