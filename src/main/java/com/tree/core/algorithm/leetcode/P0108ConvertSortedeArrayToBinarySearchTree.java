package com.tree.core.algorithm.leetcode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *  思路: 二分查找
 */
public class P0108ConvertSortedeArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums){
        if (nums == null || nums.length == 0){
            return null;
        }
        return BST(nums, 0, nums.length - 1);
    }

    private TreeNode BST(int[] nums, int i, int j) {
        if (i > j){
            return null;
        }
        int mid = (i + j) >> 1;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = BST(nums, i, mid - 1);
        cur.right = BST(nums, mid + 1, j);
        return cur;
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
