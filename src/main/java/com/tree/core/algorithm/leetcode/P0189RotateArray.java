package com.tree.core.algorithm.leetcode;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class P0189RotateArray {

    public void rotate(int[] nums, int k){
        if (nums == null || nums.length <= 1 || k <= 0){
            return;
        }
        int[] t = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            t[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < t.length; i++) {
            nums[i] = t[i];
        }
    }

}
