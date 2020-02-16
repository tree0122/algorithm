package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 旋转正方形矩阵
 *
 * 【题目】 给定一个整型正方形矩阵matrix,请把该矩阵调整成
 * 顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)。
 */
public class I0022Q010403RotateMatrix {

    public void rotate(int[][] m){
        if (m == null || m.length == 0 || m.length != m[0].length){
            return;
        }
        int r1 = 0;
        int r2 = m.length - 1;
        while (r1 <= r2){
            printEdge(m, r1, r1++, r2, r2--);
        }
    }

    private void printEdge(int[][] m, int r1, int c1, int r2, int c2) {
        for (int i = 0; i < r2 - r1; i++) {
            int t = m[r1][c1 + i];
            m[r1][c1 + i] = m[r2 - i][c1];
            m[r2 - i][c1] = m[r2][c2 - i];
            m[r2][c2 - i] = m[r1 + i][c2];
            m[r1 + i][c2] = t;
        }
    }

}
