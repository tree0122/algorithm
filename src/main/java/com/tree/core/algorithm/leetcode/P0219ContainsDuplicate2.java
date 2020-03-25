package com.tree.core.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class P0219ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k){
        if (nums == null || nums.length <= 1){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer idx = map.get(nums[i]);
            if (idx == null){
                map.put(nums[i], i);
            }else if (i - idx <= k){
                return true;
            }else {
                map.put(nums[i], i);
            }
        }
        return false;
    }


}
