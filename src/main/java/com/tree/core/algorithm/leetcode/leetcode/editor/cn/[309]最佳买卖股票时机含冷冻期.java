package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1171 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution309 {
    public int maxProfit(int[] prices) {
        /**
         * d[i][0]: 表示prices[0...i]范围内，i天结束时有股票时，至今的最大收益
         * d[i][1]: 表示prices[0...i]范围内，i天结束时无股票且处于冷冻期时，至今的最大收益
         * d[i][2]: 表示prices[0...i]范围内，i天结束时无股票且不处于冷冻期时，至今的最大收益
         */
        int[][] d = new int[prices.length][3];
        d[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            d[i][0] = Math.max(d[i - 1][0], d[i - 1][2] - prices[i]);
            d[i][1] = d[i - 1][0] + prices[i];
            d[i][2] = Math.max(d[i - 1][1], d[i - 1][2]);
        }
        return Math.max(d[d.length-1][1], d[d.length-1][2]);
    }

    public int common(int[] prices){
        /**
         * days: 总天数
         * k: 交易次数
         * status: 0 表示当前无股票，1 表示当前有股票
         *
         * d[i][j][0] = Math.max(d[i-1][j][0], d[i-1][j][1] + prices[i])
         * d[i][j][1] = Math.max(d[i-1][j][1], d[i-1][j-1][0] - prices[i])
         */
//        int[][][] d = new int[days][k][status];


        int[][] d = new int[prices.length][2];

        int maxRes = 0;
        for (int i = 1; i < prices.length; i++) {
            d[i][0] = Math.max(d[i - 1][0], d[i-1][1] + prices[i]);
            d[i][1] = Math.max(d[i-1][1], d[i-2][0] - prices[i]);
            maxRes = Math.max(maxRes, d[i][0]);
        }
        return maxRes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
