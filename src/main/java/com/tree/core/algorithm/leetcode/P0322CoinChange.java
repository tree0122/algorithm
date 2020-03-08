package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0322CoinChange {

    public int coin(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0){
            return 0;
        }
        // d[i]表示, 总金额为i的 最小硬币个数
        // 动态转移方程, d[i] = min(d[i - coins[j]]) + 1, j为coins的下标
        int[] d = new int[amount + 1];
        d[0] = 0;
        for (int i = 1; i < d.length; i++) {
            d[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && d[i] > d[i - coins[j]] + 1){
                    d[i] = d[i - coins[j]] + 1;
                }
            }
        }
        return d[amount] == amount + 1 ? -1 : d[amount];
    }
    
    public int process(int[] a, int money){
        if (money == 0){
            return 0;
        }
        int ans = money + 1;
        for (int i = 0; i < a.length && money >= a[i]; i++) {
            int r = process(a, money - a[i]) + 1;
            ans = Math.min(ans, r);
        }
        return ans;
    }

    @Test
    public void test(){
        int[] a = {186,419,83,408};
        int money = 6249;
        System.out.println(coin(a, money));
    }

}
