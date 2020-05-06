package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class P0055JumpGame {

    public boolean canJump(int[] nums) {
        int idx = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= idx){
                idx = i;
            }
        }
        return idx == 0;
    }

    public boolean understand(int[] nums){
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach || reach >= nums.length - 1){
                break;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= nums.length - 1;
    }

}
