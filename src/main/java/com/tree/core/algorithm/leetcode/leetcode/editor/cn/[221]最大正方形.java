package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 👍 1112 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution215 {
    public int maximalSquare(char[][] matrix) {
        int[][] d = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < d[0].length; i++) {
            d[0][i] = matrix[0][i];
        }
        for (int i = 0; i < d.length; i++) {
            d[i][0] = matrix[i][0];
        }
        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d[0].length; j++) {
                if (matrix[i][j] == 1){
                    d[i][j] = Math.min(d[i-1][j-1], Math.min(d[i-1][j], d[i][j-1]))+1;
                    res = Math.max(res, d[i][j]);
                }
            }
        }
        return res * res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
