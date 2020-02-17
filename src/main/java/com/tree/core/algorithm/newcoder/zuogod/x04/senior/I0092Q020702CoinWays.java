package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 换钱的方法数
 *
 * 【题目】
 * 给定数组arr,arr中所有的值都为正数且不重复。每个值代表
 * 一种面值的货币,每种面值的货币可以使用任意张,再给定一
 * 个整数aim代表要找的钱数,求换钱有多少种方法。
 *
 * 【举例】
 * arr=[5,10,25,1],aim=0。
 * 组成0元的方法有1种,就是所有面值的货币都不用。所以返回1。
 * arr=[5,10,25,1],aim=15。
 * 组成15元的方法有6种,分别为3张5元、1张10元+1张5元、1张
 * 10元+5张1元、10张1元+1张5元、2张5元+5张1元和15张1元。所
 * 以返回6。
 * arr=[3,5],aim=2。
 * 任何方法都无法组成2元。所以返回0
 */
public class I0092Q020702CoinWays {

    public int coins(int[] a, int aim){
        if (a == null || a.length == 0 || aim < 0){
            return 0;
        }
        return process(a, aim, 0);
    }

    private int process(int[] a, int aim, int i) {
        if (i == a.length){
            return aim == 0 ? 1 : 0;
        }
        int ans = 0;
        for (int k = 0; k * a[i] <= aim; k++) {
            ans += process(a, aim - k * a[i], i + 1);
        }
        return ans;
    }

    private int dp(int[] a, int aim){
        int[][] d = new int[a.length + 1][aim + 1];
        d[a.length][0] = 1;
        for (int i = d.length - 2; i >= 0; i--) {
            for (int j = 0; j < d[0].length; j++) {
                d[i][j] = d[i + 1][j] + (j >= a[i] ? d[i][j - a[i]] : 0);
            }
        }
        return d[0][aim];
    }

    public int best(int[] a, int aim){
        int[] d = new int[aim + 1];
        d[0] = 1;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < d.length; j++) {
                d[j] = d[j] + (j >= a[i] ? d[j - a[i]] : 0);
            }
        }
        return d[aim];
    }

}
