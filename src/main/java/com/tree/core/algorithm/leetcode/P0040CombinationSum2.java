package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class P0040CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        process(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void process(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            list.add(candidates[i]);
            process(candidates, target - candidates[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }

/*        if (target < 0){
            return;
        }
        if (target == 0){
            ans.add(new ArrayList<>(out));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i]){
                continue;
            }
            out.add(candidates[i]);
            process(candidates, target - candidates[i], i + 1, out, ans);
            out.remove(out.size() - 1);
        }*/


    }

    private void process1(int[] candidates, int target, int i, LinkedList<Integer> cur, List<List<Integer>> ans) {
        if (target < 0) {
            return;
        }
        if (i == candidates.length) {
            if (target == 0) {
                ArrayList<Integer> out = new ArrayList<>(cur);
                if (!ans.contains(out)) {
                    ans.add(out);
                }
            }
            return;
        }
        cur.add(candidates[i]);
        process1(candidates, target - candidates[i], i + 1, cur, ans);
        cur.pollLast();
        process1(candidates, target, i + 1, cur, ans);
    }

}
