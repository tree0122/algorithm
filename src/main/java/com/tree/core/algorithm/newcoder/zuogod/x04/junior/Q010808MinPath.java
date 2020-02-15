package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 一个二维数组, 他的每个数都是正数.
 * 要求从左上角走到右下角, 每一步只能向右或者向下.
 * 沿途经过的数字累加起来, 返回最小的路径和
 */
public class Q010808MinPath {

    public int path(int[][] m){
        if (m == null || m.length == 0){
            return 0;
        }
        return process(m, m.length - 1, m[0].length - 1);
    }

    private int process(int[][] m, int i, int j) {
        if (i == 0 && j == 0){
            return m[i][j];
        }
        if (i == 0){
            return m[i][j] + process(m, 0, j - 1);
        }
        if (j == 0){
            return m[i][j] + process(m, i - 1, 0);
        }
        return m[i][j] + Math.min(process(m, i - 1, j), process(m, i, j - 1));
    }

}
