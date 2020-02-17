package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 矩阵的最小路径和
 *
 * 【题目】
 * 给定一个矩阵m,从左上角开始每次只能向右或者向下走,最后
 * 到达右下角的位置,路径上所有的数字累加起来就是路径和,
 * 返回所有的路径中最小的路径和。
 *
 * 【举例】
 * 如果给定的m如下:
 * 1 3 5 9
 * 8 1 3 4
 * 5 0 6 1
 * 8 8 4 0
 * 路径1,3,1,0,6,1,0是所有路径中路径和最小的,所以返
 * 回12。
 *
 * 【要求】
 * 额外空间复杂度O( min {m , n})
 */
public class I0098Q020901MatrixSmallestPath {

    public int path(int[][] m){
        if (m == null || m.length == 0){
            return 0;
        }
        return process(m, 0, 0);
    }

    private int process(int[][] m, int i, int j) {
        if (i == m.length - 1 && j == m[0].length - 1){
            return m[i][j];
        }
        if (i == m.length - 1){
            return m[i][j] + process(m, i, j + 1);
        }
        if (j == m[0].length - 1){
            return m[i][j] + process(m, i + 1, j);
        }
        return m[i][j] + Math.min(process(m, i + 1, j), process(m, i, j + 1));
    }

    public int dp(int[][] m){
        int[][] d = new int[m.length][m[0].length];
        d[m.length - 1][m[0].length - 1] = m[m.length - 1][m[0].length - 1];
        for (int i = m.length - 2; i >= 0; i--) {
            d[i][m[0].length - 1] = m[i][m[0].length - 1] + d[i + 1][m[0].length - 1];
        }
        for (int i = m[0].length - 2; i >= 0; i--) {
            d[m.length - 1][i] = m[m.length - 1][i] + d[m.length - 1][i + 1];
        }
        for (int i = m.length - 2; i >= 0; i--) {
            for (int j = m[0].length - 2; j >= 0; j--) {
                d[i][j] = m[i][j] + Math.min(d[i + 1][j], d[i][j + 1]);
            }
        }
        return d[0][0];
    }

    public int best(int[][] m){
        int rLen = m.length;
        int cLen = m[0].length;
        int[] d = new int[cLen];
        d[cLen - 1] = m[rLen - 1][cLen - 1];
        for (int i = cLen - 2; i >= 0; i--) {
            d[i] = d[i + 1] + m[rLen - 1][i];
        }
        for (int i = rLen - 2; i >= 0; i--) {
            d[cLen - 1] = d[cLen - 1] + m[i][cLen - 1];
            for (int j = cLen - 2; j >= 0; j--) {
                d[j] = Math.min(d[j], d[j + 1]) + m[i][j];
            }
        }
        return d[0];
    }

}
