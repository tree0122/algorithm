package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
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
 */
public class P0052NQueens2 {

    public int totalNQueens(int n) {
        return queens(new int[n], 0);
    }

    private int queens(int[] a, int i) {
        if (i == a.length){
            return 1;
        }
        int cn = 0;
        for (int v = 0; v < a.length; v++) {
            if (valid(a, i, v)){
                a[i] = v;
                cn += queens(a, i + 1);
            }
        }
        return cn;
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
