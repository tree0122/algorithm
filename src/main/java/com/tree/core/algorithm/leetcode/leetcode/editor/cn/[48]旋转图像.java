package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
// Related Topics 数组 数学 矩阵 👍 1189 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length){
            return;
        }
        for (int i = 0, j = matrix.length - 1; i < j; ) {
            rotate(matrix, i, i, j, j);
            i++;
            j--;
        }
    }

    private void rotate(int[][] m, int r1, int c1, int r2, int c2) {
        for (int i = 0; i < r2 - r1; i++) {
            int t = m[r1][c1 + i];
            m[r1][c1 + i] = m[r2 - i][c1];
            m[r2 -i][c1] = m[r2][c2 - i];
            m[r2][c2 - i] = m[r1 + i][c2];
            m[r1 + i][c2] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
