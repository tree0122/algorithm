package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1686 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution55 {
    public boolean canJump(int[] nums) {
        boolean res = canJump(nums, 0);
        return res;
    }

    public int jump(int[] a){
        if (a[0] == 0){
            return -1;
        }
        /**
         * d[i] 表示从i位置到len-1，所需的最小步数
         * d[i] = min{d[j]} + 1, j的范围(i, i + a[i]]
         */
        int[] d = new int[a.length];
        for (int i = d.length - 1; i >= 0; i--) {
            d[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j < i + a[i] && j < a.length; j++) {
                if (d[j] == Integer.MAX_VALUE){
                    continue;
                }
                d[i] = Math.min(d[i], d[j] + 1);
            }
        }
        return d[0];
    }

    private boolean canJump(int[] a, int i) {
        if (i >= a.length - 1){
            return true;
        }
        for (int k = 1; k <= a[i]; k++) {
            if (canJump(a, i + k)){
                return true;
            }
        }
        return false;
    }

    public boolean better(int[] a){
        int reach = 0; //能到达的最大位置
        for (int i = 0; i < a.length; i++) {
            if (i <= reach){
                reach = Math.max(reach, i + a[i]);
                if (reach >= a.length - 1){
                    return true;
                }
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
