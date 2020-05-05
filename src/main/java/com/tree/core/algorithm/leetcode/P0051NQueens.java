package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class P0051NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        queens(new int[n], 0, ans);
        return ans;
    }

    private void queens(int[] a, int i, List<List<String>> ans) {
        if (i == a.length){
            char[] cs = new char[a.length];
            for (int k = 0; k < cs.length; k++) {
                cs[k] = '.';
            }
            List<String> list = new ArrayList<>();
            for (int k = 0; k < a.length; k++) {
                cs[a[k]] = 'Q';
                list.add(String.valueOf(cs));
                cs[a[k]] = '.';
            }
            ans.add(list);
            return;
        }
        for (int v = 0; v < a.length; v++) {
            if (valid(a, i, v)){
                a[i] = v;
                queens(a, i + 1, ans);
            }
        }
    }

    private boolean valid(int[] a, int i, int v) {
        for (int x = 0; x < i; x++) {
            if (a[x] == v || Math.abs(i - x) == Math.abs(v - a[x])){
                return false;
            }
        }
        return true;
    }

}
