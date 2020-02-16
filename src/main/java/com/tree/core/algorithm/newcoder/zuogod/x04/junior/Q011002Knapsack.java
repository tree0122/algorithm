package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 背包问题
 */
public class Q011002Knapsack {

    public int best(int[] w, int[] v, int bag){
        if (w == null || w.length == 0
                || v == null || v.length == 0
                || w.length != v.length || bag < 1){
            return 0;
        }
        int[] d = new int[bag + 1];
        for (int i = w[w.length - 1]; i <= bag; i++) {
            d[i] = v[v.length - 1];
        }
        int ans = 0;
        for (int i = w.length - 2; i >= 0; i--) {
            for (int j = 0; j <= bag; j++) {
                if (j - w[i] >= 0 && d[j] < d[j - w[i]] + v[i]){
                    d[j] = d[j - w[i]] + v[i];
                }
                ans = Math.max(ans, d[j]);
            }
        }
        return ans;
    }

    public int maxValue(int[] w, int[] v, int bag){
        if (w == null || w.length == 0
                || v == null || v.length == 0
                || w.length != v.length || bag < 1){
            return 0;
        }
        return process(w, v, bag, 0);
    }

    private int process(int[] w, int[] v, int bag, int i) {
        if (i == w.length || bag < 0){
            return 0;
        }
        return Math.max(
                process(w, v, bag, i + 1),
                process(w, v, bag - w[i], i + 1) + v[i]
        );
    }

}
