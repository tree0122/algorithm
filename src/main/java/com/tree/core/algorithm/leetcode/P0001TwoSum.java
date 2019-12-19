package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class P0001TwoSum {

    public int[] twoSum(int[] nums, int target){
        if (nums == null || nums.length < 2){
            return new int[]{};
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    list.add(new int[]{i, j});
                }
            }
        }
        if (!list.isEmpty()){
            return list.get(0);
        }
        return new int[]{};
    }

    public int[] better(int[] nums, int target){
        if (nums == null || nums.length < 2){
            return new int[]{};
        }
//        ArrayList<int[]> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer nextIdx = map.get(target - nums[i]);
            if (nextIdx != null){
//                list.add(new int[]{nextIdx, i});
                return new int[]{nextIdx, i};
            }

            map.put(nums[i], i);
        }
        /*if (!list.isEmpty()){
            return list.get(0);
        }*/
        return new int[]{};
    }

    /**
     * kSum 通用
     * @param nums
     * @param target
     * @param k
     * @return
     */
    public List<int[]> common(int[] nums, int target, int k){
        if (nums == null || nums.length < k){
            return new ArrayList<>();
        }
        int[] t = new int[k];
        List<int[]> res = new ArrayList<>();
        process(nums, target, k, 0, t, res);
        return res;
    }

    private void process(int[] nums, int target, int k, int i, int[] t, List<int[]> res) {
        if (i == nums.length){
            if (k == 0 && target == 0){
                res.add(Arrays.copyOf(t, t.length));
            }
            return;
        }
        process(nums, target, k, i + 1, t, res);
        if (k > 0){
            t[t.length - k] = i;
            process(nums, target - nums[i], k - 1, i + 1, t, res);
        }
    }

}
