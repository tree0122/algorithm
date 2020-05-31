package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class P0090Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        p(nums, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void p(int[] n, int i, List<Integer> c, List<List<Integer>> a) {
        for (int k = i; k < n.length; k++) {
            if (k > i && n[k] == n[k - 1]){
                continue;
            }
            c.add(n[k]);
            a.add(new ArrayList<>(c));
            p(n, k + 1, c, a);
            c.remove(c.size() - 1);
        }
    }

    @Test
    public void t(){
        int[] a={1, 2, 3};
        System.out.println(subsetsWithDup(a));
    }

}
