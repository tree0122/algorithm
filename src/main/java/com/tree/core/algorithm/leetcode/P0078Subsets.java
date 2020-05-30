package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class P0078Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        p(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void p(int[] nums, int i, ArrayList<Integer> c, ArrayList<List<Integer>> ans) {
        if (i == nums.length){
            ans.add(new ArrayList<>(c));
            return;
        }
        p(nums, i + 1, c, ans);
        c.add(nums[i]);
        p(nums, i + 1, c, ans);
        c.remove(c.size() - 1);
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
