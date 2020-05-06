package com.tree.core.algorithm.leetcode;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class P0059SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        for (int r1 = 0, c1 = 0, r2 = n - 1, c2 = n - 1, v = 1; r1 <= r2 && c1 <= c2; ) {
            v = rect(ans, r1++, c1++, r2--, c2--, v);
        }
        return ans;
    }

    private int rect(int[][] ans, int r1, int c1, int r2, int c2, int v) {
        if (r1 == r2){
            return ans[r1][c1] = v++;
        }
        for (int i = c1; i < c2; i++) {
            ans[r1][i] = v++;
        }
        for (int i = r1; i < r2; i++) {
            ans[i][c2] = v++;
        }
        for (int i = c2; i > c1; i--) {
            ans[r2][i] = v++;
        }
        for (int i = r2; i > r1; i--) {
            ans[i][c1] = v++;
        }
        return v;
    }

}
