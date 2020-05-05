package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class P0047Permutations2 {

    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        boolean[] visit = new boolean[nums.length];
        process(nums, visit, 0, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    private void process(int[] nums, boolean[] visit, int i, List<Integer> list, Set<List<Integer>> ans) {
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
