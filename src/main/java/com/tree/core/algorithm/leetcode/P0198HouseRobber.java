package com.tree.core.algorithm.leetcode;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class P0198HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int max = nums[0];
        int i = nums[0];
        int j = Math.max(nums[0], nums[1]);
        max = Math.max(max, j);
        int k = Math.max(nums[0] + nums[2], nums[1]);
        max = Math.max(max, k);
        for (int p = 3; p < nums.length; p++) {
            int t = Math.max(i, j) + nums[p];
            i = j;
            j = k;
            k = t;
            max = Math.max(max, t);
        }
        return max;
    }

}
