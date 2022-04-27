package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2421 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length];
        int res = d[0] = 1;
        for (int i = 1; i < d.length; i++) {
            d[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]){
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            res = Math.max(res, d[i]);
        }
       return res;
    }

    public int best(int[] a){
        int[] d = new int[a.length + 1];
        int len = 1;
        d[len] = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > d[len]){
                d[++len] = a[i];
            }else {
                int l = 1, r = len;
                while (l <= r){
                    int m = (l + r) /2;
                    if (d[m] < a[i]){
                        l = m + 1;
                    }else {
                        r = m - 1;
                    }
                }
                d[l] = a[i];
            }
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
