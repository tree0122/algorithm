package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1187 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum / 2 != 0){
            return false;
        }
        return canPartition(nums, 0, sum /2);
    }

    private boolean canPartition(int[] a, int i, int t) {
        if (i == a.length){
            return t == 0;
        }
        return canPartition(a, i + 1, t) || canPartition(a, i + 1, t - a[i]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
