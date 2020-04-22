package com.tree.core.algorithm.leetcode;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class P0034FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]){
            return ans;
        }
        int low = 0, high = nums.length;
        while (low < high){
            int mid = (low + high) >> 1;
            if (nums[mid] >= target){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        if (nums[low] != target){
            return ans;
        }
        ans[0] = low;
        high = nums.length;
        while (low < high){
            int mid = (low + high) >> 1;
            if (nums[mid] > target){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        ans[1] = low - 1;
        return ans;
    }


}
