package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 岛问题
 * 一个矩阵中只有0和1两种值,每个位置都可以和自己的上、下、左、右
 * 四个位置相连,如果有一片1连在一起,这个部分叫做一个岛,求一个
 * 矩阵中有多少个岛?
 * 举例:
 * 0 1 1 0 0 1
 * 0 0 1 1 0 0
 * 0 0 1 0 1 1
 * 0 0 0 0 0 0
 *
 * 这个矩阵中有三个岛。
 */
public class Q010702Islands {

    public int count(int[][] m){
        if (m == null || m.length == 0){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1){
                    ans++;
                    infect(m, i, j);
                }
            }
        }
        return ans;
    }

    private void infect(int[][] m, int i, int j) {
        if (i < 0 || i > m.length - 1 || j < 0 || j > m[0].length - 1){
            return;
        }
        m[i][j] = 2;
        infect(m, i - 1, j);
        infect(m, i, j - 1);
        infect(m, i + 1, j);
        infect(m, i, j + 1);
    }
}
