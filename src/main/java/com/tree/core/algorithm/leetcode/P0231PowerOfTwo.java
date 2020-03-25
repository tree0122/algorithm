package com.tree.core.algorithm.leetcode;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 */
public class P0231PowerOfTwo {

    public boolean isPowerOfTwo(int n){
        if (n <= 0){
            return false;
        }
        int cnt = 0;
        while (n != 0){
            n = n & (n - 1);
            cnt++;
        }
        return cnt == 1;
    }

    public boolean awesome(int n){
        if (n <= 0){
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
