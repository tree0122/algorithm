package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class P0054SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new ArrayList<>();
        }
        int rLen = matrix.length, cLen = matrix[0].length;
        List<Integer> ans = new ArrayList<>(rLen * cLen);
        for (int r1 = 0, c1 = 0, r2 = rLen - 1, c2 = cLen - 1; r1 <= r2 && c1 <= c2; ) {
            rect(matrix, r1++, c1++, r2--, c2--, ans);
        }
        return ans;
    }

    private void rect(int[][] matrix, int r1, int c1, int r2, int c2, List<Integer> ans) {
        if (r1 == r2){
            for (int i = c1; i <= c2; i++) {
                ans.add(matrix[r1][i]);
            }
        }else if (c1 == c2){
            for (int i = r1; i <= r2; i++) {
                ans.add(matrix[i][c1]);
            }
        }else {
            for (int i = c1; i < c2; i++) {
                ans.add(matrix[r1][i]);
            }
            for (int i = r1; i < r2; i++) {
                ans.add(matrix[i][c2]);
            }
            for (int i = c2; i > c1; i--) {
                ans.add(matrix[r2][i]);
            }
            for (int i = r2; i > r1; i--) {
                ans.add(matrix[i][c1]);
            }
        }
    }

}
