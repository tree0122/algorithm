package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1886 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int pos = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                ans = Math.max(ans, (i - left - 1) * heights[pos]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int pos = stack.pop();
            int left = stack.isEmpty() ? pos - 1 : stack.peek();
            ans = Math.max(ans, (pos - left) * heights[pos]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
