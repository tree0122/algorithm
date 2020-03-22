package com.tree.core.algorithm.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class P0053MaximumSubarray {

    public int maxSubarray(int[] nums){
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        int max = nums[nums.length - 1];
        // lastMax表示, 以i开头的子数组中, 子数组和的最大值
        for (int i = nums.length - 2, lastMax = max; i >= 0; i--) {
            lastMax = nums[i] + lastMax > 0 ? lastMax : 0;
            max = Math.max(max, lastMax);
        }
        return max;
    }

    public int understand(int[] nums){
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1){
            return nums[0];
        }
        // a[i]表示, 以i开始的子数组中, 数组和的最大值
        int[] a = new int[nums.length];
        a[a.length - 1] = nums[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            a[i] = nums[i] + a[i + 1] > 0 ? a[i + 1] : 0;
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        return max;
    }

}
