package com.tree.core.algorithm.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 */
public class P0045JumpGame2 {

    public int jump(int[] nums) {
        int cn = 0;
        for (int i = 0, pre = 0, cur = 0; cur < nums.length - 1;) {
            pre = cur;
            while (i <= pre){
                cur = Math.max(cur, i + nums[i++]);
            }
            cn++;
        }
        return cn;
    }


    public int understand(int[] nums){
        int cn = 0;
        for (int i = 0, cur = 0, last = 0; i < nums.length; i++) {
            cur = Math.max(cur, i + nums[i]);
            if (last == i){
                last = cur;
                cn++;
                if (cur >= nums.length - 1){
                    break;
                }
            }
        }
        return cn;
    }

}
