package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 转圈打印矩阵
 *
 * 【题目】 给定一个整型矩阵matrix,请按照转圈的方式打印它。
 * 例如: 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 打印结果为:1,2,3,4,8,12,16,15,14,13,9,
 * 5,6,7,11, 10
 * 【要求】 额外空间复杂度为O(1)。
 */
public class I0021Q010402MatrixSpiralOrder {

    public void print(int[][] m){
        if (m == null || m.length == 0){
            return;
        }
        int r1 = 0;
        int c1 = 0;
        int r2 = m.length - 1;
        int c2 = m[0].length - 1;
        while (r1 <= r2 && c1 <= c2){
            printEdge(m, r1++, c1++, r2--, c2--);
        }
    }

    private void printEdge(int[][] m, int r1, int c1, int r2, int c2) {
        for (int i = c1; i < c2; i++) {
            System.out.print(m[r1][i] + " ");
        }
        if (r1 == r2){
            return;
        }
        for (int i = r1; i < r2; i++) {
            System.out.print(m[i][c2] + " ");
        }
        if (c1 == c2){
            return;
        }
        for (int i = c2; i > c1; i--) {
            System.out.print(m[r2][i] + " ");
        }
        for (int i = r2; i > r1; i--) {
            System.out.print(m[i][c1] + " ");
        }
    }

}
