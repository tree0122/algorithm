package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5108 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public String longestPalindrome(String s) {
        // 预处理字符串
        char[] cs = new char[s.length() * 2 + 1];
        for (int i = 0, j= 0; i < cs.length; i++) {
            if (i /2 == 0){
                cs[i] ='#';
            }else {
                cs[i] = s.charAt(j++ );
            }
        }
        // 以预处理字符串的下标i为中心的回文半径（奇数长度时，不包括中心字符）
        int[] radius = new int[cs.length];
        // 通过中心扩散能扩散到的最右边的下标
        int mostRight = 0;
        // 与maxRight对应的中心字符的下标
        int center = 0;
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < cs.length; i++) {
            if (i < mostRight){
                // 状态转移方程
                radius[i] = Math.min(mostRight - i, radius[2 * center - i]);
            }else {
                radius[i] = 1;
            }
            // 尝试用中心扩展法，更新 radius[i]的值
            while (i - radius[i] >= 0 && i + radius[i] < cs.length && cs[i - radius[i]] == cs[i + radius[i]]){
                radius[i]++;
            }
            // 更新 mostRight，它是遍历过的i的 i + radius[i] 最大值
            if (i + radius[i] > mostRight){
                center = i;
                mostRight = i + radius[i];
            }
            // 更新 maxLen 和 begin
            if (radius[i] > maxLen){
                maxLen = radius[i];
                begin = i;
//                begin = (i - maxLen) /2;
            }
        }
        begin = (begin - 1) /2;
        return s.substring(begin, begin + maxLen);
    }

    public String dp(String s) {
        // d[i][j] 表示s[i..j]子串是否为回文子串
        boolean[][] d = new boolean[s.length()][s.length()];
        for (int i = 0; i < d.length; i++) {
            d[i][i] = true;
        }
        int maxLen = 1; // 最长回文子串长度
        int begin = 0; // 最长回文子串的起始位置
        for (int i = 1; i < d.length; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) != s.charAt(j)){
                    d[i][j] = false;
                }else {
                    if (j - i < 3){ // s[i..j]的长度为1或者2
                        d[i][j] = true;
                    }else {
                        d[i][j] = d[i + 1][j - 1];
                    }
                }
                if (d[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String center(String s){
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);
            int len = Math.max(oddLen, evenLen);
            if (maxLen < len){
                maxLen = len;
                begin = i - (maxLen - 1) /2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
