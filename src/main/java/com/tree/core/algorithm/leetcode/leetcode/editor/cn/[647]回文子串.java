package com.tree.core.algorithm.leetcode.leetcode.editor.cn;
//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 803 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution647 {
    public int countSubstrings(String s) {
        int[] r = {0};
        for (int i = 0; i < s.length(); i++) {
            process(s, i, i, r);
            process(s, i, i+1, r);
        }
        return r[0];
    }

    private void process(String s, int i, int j, int[] r) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            r[0]++;
        }
    }

    public int dp(String s){
        int res = 0;
        boolean[][] d = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                d[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || d[i + 1][j - 1]);
                if (d[i][j]){
                    res++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
