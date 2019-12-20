package com.tree.core.algorithm.leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class P0016ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int m = i + 1;
            int n = nums.length - 1;
            while (m < n){
                int sum = nums[i] + nums[m] + nums[n];
                if (Math.abs(target - sum) < Math.abs(target - closest)){
                    closest = sum;
                }
                if (sum < target){
                    m++;
                }else {
                    n--;
                }
            }
        }
        return closest;
    }


}
