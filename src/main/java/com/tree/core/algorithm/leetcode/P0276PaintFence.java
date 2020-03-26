package com.tree.core.algorithm.leetcode;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 *
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 *
 * Return the total number of ways you can paint the fence.
 *
 * Note:
 * n and k are non-negative integers.
 *
 * Example:
 *
 * Input: n = 3, k = 2
 * Output: 6
 * Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:
 *
 *             post1  post2  post3
 *  -----      -----  -----  -----
 *    1         c1     c1     c2
 *    2         c1     c2     c1
 *    3         c1     c2     c2
 *    4         c2     c1     c1
 *    5         c2     c1     c2
 *    6         c2     c2     c1
 *
 *    在染一个柱子的时候，要考虑是否和上一个柱子的颜色相同，有两种方案：
 *    1）如果和上一个柱子染同一种颜色，那么取决于上一个柱子有多少种和上上个柱子不同的染色方案；
 *    2）如果染和上一个不同的颜色，那么染色方案就有(k - 1) * (之前总共有多少种方案)
 */
public class P0276PaintFence {

    public int numWays(int n, int k){
        if (n <= 0 || k <= 0 || (n > 2 && k == 1)){
            return 0;
        }
        // diff表示, n-1与n-2不同颜色的情况数量
        // same表示, n与n-1不同颜色的情况数量
        // total表示, n的所有情况数量
        int diff = k, same = 0, total = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }

}
