package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4462 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    public int maxSubArray(int[] nums) {
        /**
         * a[i]: nums的[i,len-1]范围内以i开头的最大子数组和
         */
        int[] a = new int[nums.length];
        a[a.length - 1] = nums[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            a[i] = nums[i] + (a[i + 1] > 0 ? a[i + 1] : 0);
        }
        int res = a[0];
        for (int i = 1; i < a.length; i++) {
            res = Math.max(res, a[i]);
        }
        return res;

//        return get(nums, 0, nums.length - 1).max;
    }

    public int better(int[] a){
        int curSum = a[0], res = a[0];
        for (int i = 1; i < a.length; i++) {
            curSum = Math.max(curSum + a[i], a[i]);
            res = Math.max(res, curSum);
        }
        return res;
    }

    public Status get(int[] a, int i, int j){
        if (i == j){
            return new Status(a[i], a[i], a[i], a[i]);
        }
        int m = (i + j) /2;
        Status left = get(a, i, m);
        Status right = get(a, m + 1, j);
        int sum = left.sum + right.sum;
        int leftMax = Math.max(left.leftMax, left.sum + right.leftMax);
        int rightMax = Math.max(right.rightMax, left.rightMax + right.sum);
        int max = Math.max(Math.max(left.max, right.max), left.rightMax + right.leftMax);
        return new Status(sum,leftMax, rightMax, max);
    }

    class Status{
        int sum;
        int leftMax;
        int rightMax;
        int max;

        public Status(int sum, int leftMax, int rightMax, int max) {
            this.sum = sum;
            this.leftMax = leftMax;
            this.rightMax = rightMax;
            this.max = max;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
