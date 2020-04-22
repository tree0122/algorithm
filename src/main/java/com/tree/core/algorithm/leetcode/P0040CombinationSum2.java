package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
public class P0040CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return ans;
        }
        Arrays.sort(candidates);
        process(candidates, target, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void process(int[] candidates, int target, int i, LinkedList<Integer> cur, List<List<Integer>> ans) {
        if (target < 0){
            return;
        }
        if (i == candidates.length){
            if (target == 0){
                ArrayList<Integer> out = new ArrayList<>(cur);
                if (!ans.contains(out)){
                    ans.add(out);
                }
            }
            return;
        }
 /*       for (int j = i; j < candidates.length; j++) {
            if (j > 0 && candidates[j] == candidates[j - 1]){
                continue;
            }
            cur.add(candidates[j]);
            process(candidates, target - candidates[i], i + 1, cur, ans);
            cur.pollLast();
        }*/
        cur.add(candidates[i]);
        process(candidates, target - candidates[i], i + 1, cur, ans);
        cur.pollLast();
        process(candidates, target, i + 1, cur, ans);
    }

}
