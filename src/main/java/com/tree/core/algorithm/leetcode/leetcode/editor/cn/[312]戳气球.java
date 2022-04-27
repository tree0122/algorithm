package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 967 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution312 {
    public int maxCoins(int[] nums) {
        int[] d = new int[nums.length + 2];
        d[0] = d[d.length - 1] =1;
        for (int i = 1, j = 0; i < d.length - 1; i++, j++) {
            d[i] = nums[j];
        }
        return maxCoins(d, 1, d.length - 2);
    }

    private int maxCoins(int[] d, int i, int j) {
        if (i == j){
            return d[i] * d[i - 1] * d[j + 1];
        }
        int res = 0;
        for (int k = i; k <= j; k++) {
            int left = (k == i) ? 0 : maxCoins(d, i, k - 1);
            int right = (k == j) ? 0 : maxCoins(d, k + 1, j);
            int mid = d[k] * d[i - 1] * d[j + 1];
            res = Math.max(res, left + right + mid);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
