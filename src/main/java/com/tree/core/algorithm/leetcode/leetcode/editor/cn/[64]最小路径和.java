package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 1157 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution64 {
    public int minPathSum(int[][] grid) {
        int r = minPathSum(grid, grid.length - 1, grid[0].length - 1);
        return r;
    }

    private int minPathSum(int[][] m, int r, int c) {
        if (r == m.length - 1 && c == m[0].length - 1) {
            return m[r][c];
        }
        if (r == m.length - 1) {
            return m[r][c] + minPathSum(m, r, c + 1);
        }
        if (c == m[0].length - 1) {
            return m[r][c] + minPathSum(m, r + 1, c);
        }
        return m[r][c] + Math.min(minPathSum(m, r + 1, c), minPathSum(m, r, c + 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
