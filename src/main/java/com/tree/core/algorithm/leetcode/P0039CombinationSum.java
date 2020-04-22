package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class P0039CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return ans;
        }
        process(candidates, target, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void process(int[] candidates, int target, int i, LinkedList<Integer> cur, List<List<Integer>> ans) {
        if (i == candidates.length){
            if (target == 0){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int j = 0; j * candidates[i] <= target; j++) {
            for (int x = 0; x < j; x++) {
                cur.add(candidates[i]);
            }
            process(candidates, target - j * candidates[i], i + 1, cur, ans);
            for (int x = 0; x < j; x++) {
                cur.pollLast();
            }
        }
    }

}
