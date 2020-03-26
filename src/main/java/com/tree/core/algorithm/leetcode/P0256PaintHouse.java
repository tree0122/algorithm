package com.tree.core.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Example:
 *
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 *              Minimum cost: 2 + 5 + 3 = 10.
 */
public class P0256PaintHouse {

    public int minCost(int[][] costs){
        if (costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        // d[i][j] 表示, 第i个房子刷j颜色的全部最小代价
        // dp方程 d[i][j] = costs[i][j] + d[i-1][(j+1)%3][(j+2)%3]
        int[][] d = costs;
        for (int i = 1; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                d[i][j] += Math.min(d[i - 1][(j + 1) % 3], d[i - 1][(j + 2) % 3]);
            }
        }
        return Math.min(
                Math.min(d[d.length - 1][0], d[d.length - 1][1]),
                d[d.length - 1][2]
        );
    }

}
