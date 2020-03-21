package com.tree.core.algorithm.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 */
public class P0035SearchInsertPosition {

    public int searchInsert(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0, j = nums.length, mid = 0;
        while (i < j){
           mid = (i + j) >> 1;
           if (target <= nums[mid]){
               j = mid;
           }else {
               i = mid + 1;
           }
        }
        return i;
    }

}
