package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class P0077Combinations {

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1 || k > n) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < n; i++) {
                temp.add(i + 1);
                backtrack(res, temp, n, k, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private void p(int[] a, int k, boolean[] v, ArrayList<Integer> c, ArrayList<List<Integer>> list) {
        if (0 == k) {
            list.add(new ArrayList<>(c));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (v[i]) {
                continue;
            }
            c.add(a[i]);
            v[i] = true;
            p(a, k - 1, v, c, list);
            c.remove(c.size() - 1);
            v[i] = false;
        }
    }

}
