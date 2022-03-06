package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1210 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] v = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int k = 0;
                v[i][j] = true;
                if (board[i][j] == word.charAt(k)){
                    boolean a = exist(board, word, v, i, j, k + 1);
                    if (a){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] b, String w, boolean[][] v, int i, int j, int k) {
        if (k == w.length()){
            return true;
        }
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length || v[i][j] || b[i][j] != w.charAt(k)){
            return false;
        }
        v[i][j] = true;
        boolean res = exist(b, w, v, i - 1, j, k + 1)
                    ||exist(b, w, v, i + 1, j, k + 1)
                    ||exist(b, w, v, i, j - 1, k + 1)
                    ||exist(b, w, v, i, j + 1, k + 1)
                ;
        v[i][j] = false;
        return res;

    }

//    private boolean exist(char[][] b, String w, boolean[][] v, int i, int j, int k) {
//        boolean r = false;
//        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length){
//            return r;
//        }
//        if (k == w.length()){
//            return true;
//        }
//        if (!v[i - 1][j] && b[i - 1][j] == w.charAt(k)){
//            r = exist(b, w, v, i - 1, j, k + 1);
//            if (r){
//                return r;
//            }
//        }
//        if (!v[i + 1][j] && b[i + 1][j] == w.charAt(k)){
//            r = exist(b, w, v, i + 1, j, k + 1);
//            if (r){
//                return r;
//            }
//        }
//        if (!v[i][j - 1] && b[i][j - 1] == w.charAt(k)){
//            r = exist(b, w, v, i, j - 1, k + 1);
//            if (r){
//                return r;
//            }
//        }
//        if (!v[i][j + 1] && b[i][j + 1] == w.charAt(k)){
//            r = exist(b, w, v, i, j + 1, k + 1);
//            if (r){
//                return r;
//            }
//        }
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
