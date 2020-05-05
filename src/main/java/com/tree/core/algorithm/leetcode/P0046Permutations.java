package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class P0046Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        process(nums, visit, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void process(int[] nums, boolean[] visit, int i, List<Integer> list, List<List<Integer>> ans) {
        if (i == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visit[j]){
                continue;
            }
            visit[j] = true;
            list.add(nums[j]);
            process(nums, visit, i + 1, list, ans);
            list.remove(list.size() - 1);
            visit[j] = false;
        }
    }

}
