package com.tree.core.algorithm.leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class P0048RotateImage {

    public void rotate(int[][] matrix) {
        for (int i = 0, j = matrix.length - 1; i <= j; ) {
            rotateEdge(matrix, i, i++, j, j--);
        }
    }

    private void rotateEdge(int[][] m, int r1, int c1, int r2, int c2) {
        int len = r2 - r1;
        for (int i = 0; i < len; i++) {
            int t = m[r1][c1 + i];
            m[r1][c1 + i] = m[r2 - i][c1];
            m[r2 - i][c1] = m[r2][c2 - i];
            m[r2][c2 - i] = m[r1 + i][c2];
            m[r1 + i][c2] = t;

        }
    }

}
