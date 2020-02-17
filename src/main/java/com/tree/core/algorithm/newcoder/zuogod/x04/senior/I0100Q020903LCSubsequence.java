package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 最长公共子序列问题
 *
 * 【题目】
 * 给定两个字符串str1和str2,返回两个字符串的最长公共子序列。
 *
 * 【举例】
 * str1="1A2C3D4B56",str2="B1D23CA45B6A"。
 * "123456"或者"12C4B6"都是最长公共子序列,返回哪一个都行
 */
public class I0100Q020903LCSubsequence {

    public int lcs(String s1, String s2){
        return process(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    private int process(String s1, String s2, int i, int j) {
        if (i == 0 && j == 0){
            return s1.charAt(i) == s2.charAt(j) ? 1 : 0;
        }
        if (i == 0){
            for (int k = 0; k < s2.length(); k++) {
                if (s1.charAt(i) == s2.charAt(k)){
                    return 1;
                }
            }
            return 0;
        }
        if (j == 0){
            for (int k = 0; k < s1.length(); k++) {
                if (s1.charAt(k) == s2.charAt(j)){
                    return 1;
                }
            }
            return 0;
        }
        int ans = process(s1, s2, i - 1, j);
        ans = Math.max(ans, process(s1, s2, i, j - 1));
        if (s1.charAt(i) == s2.charAt(j)){
            ans = Math.max(ans, process(s1, s2, i - 1, j - 1) + 1);
        }
        return ans;
    }

}
