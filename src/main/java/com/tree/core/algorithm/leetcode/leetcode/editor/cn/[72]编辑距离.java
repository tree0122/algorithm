package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 2161 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int r = minDistance(word1, word2, word1.length() - 1, word2.length() - 1);
        return r;
    }

    private int minDistance(String w1, String w2, int i, int j) {
        if (i == 0 && j == 0) {
            return w1.charAt(i) == w2.charAt(j) ? 0 : 1;
        }
        if (i == 0) {
            return j;
        }
        if (j == 0){
            return i;
        }
        int r = Math.min(
                minDistance(w1, w2, i - 1, j),
                minDistance(w1, w2, i, j - 1)
        ) + 1;
        int d = 1;
        if (w1.charAt(i) == w2.charAt(j)) {
            d = 0;
        }
        r = Math.min(r, minDistance(w1, w2, i - 1, j - 1) + d);
        return r;
    }

    public int better(String w1, String w2){
        /**
         * d[i][j]: w1[0, i) 变为 w[0, j)的代价
         *
         * d[i][j] = min{d[i-1][j], d[i][j], d[i-1][j-1] +{0,1}}
         */
        int[][] d = new int[w1.length() +1][w2.length() + 1];
        for (int i = 0; i < d.length; i++) {
            d[i][0] = i;
        }
        for (int i = 0; i < d[0].length; i++) {
            d[0][i] = i;
        }
        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d[0].length; j++) {
                d[i][j] = Math.min(
                        Math.min(d[i - 1][j], d[i][j - 1]) + 1,
                        d[i-1][j-1] + (w1.charAt(i) == w2.charAt(j) ? 0 : 1)
                );
            }
        }
        return d[w1.length()][w2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
