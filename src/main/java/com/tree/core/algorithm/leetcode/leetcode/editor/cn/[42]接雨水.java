package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3185 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length <= 1){
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[right.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    public int better(int[] a){
        int left = 0;
        int right = a.length - 1;
        int ans = 0;
        int LMax = a[left]; // a的[0,left]的最大值
        int RMax = a[right]; // a的[right, len-1]的最大值
        while (left < right){
            LMax = Math.max(LMax, a[left]);
            RMax = Math.max(RMax, a[right]);
            // 潜台词：
            // a[left] < a[right] <= RMax
            // a[left] <= LMax
            // 由于 a[left] < a[right] 是left才递增，故此时LMax < RMax
            if (a[left] < a[right]){
                ans += (LMax - a[left]);
                left++;
            }else {
                ans += (RMax - a[right]);
                right--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
