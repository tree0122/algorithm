package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1248 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int[] t = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                t[i] = matrix[i][j] == '1' ? t[i] + 1: 0;
            }
            LinkedList<Integer> stack = new LinkedList<>();
            for (int k = 0; k < t.length; k++) {
                while (!stack.isEmpty() && t[i] < t[stack.peek()]){
                    int pos = stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    ans = Math.max(ans, (i - left - 1) * t[pos]);
                }
                stack.push(k);
            }
            while (!stack.isEmpty()){
                int pos = stack.pop();
                int left = stack.isEmpty() ? pos - 1 : stack.peek();
                ans = Math.max(ans, t[pos] * (pos - left));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
