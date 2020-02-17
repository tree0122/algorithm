package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 字符串的交错组成
 *
 * 【题目】
 * 给定三个字符串str1、str2和aim,如果aim包含且仅包含来自str1和str2的所有
 * 字符,而且在aim中属于str1的字符之间保持原来在str1中的顺序,属于str2的
 * 字符之间保持原来在str2中的顺序,那么称aim是str1和str2的交错组成。实现
 * 一个函数,判断aim是否是str1和str2交错组成。
 *
 * 【举例】
 * str1="AB",str2="12"。那么"AB12"、"A1B2"、"A12B"、"1A2B"和"1AB2"等都
 * 是str1和str2的交错组成。
 */
public class I0104Q020907StringIntersectCompose {
    
    public boolean awesome(String s1, String s2, String s3){
        if (s1 == null || s2 == null || s3 == null){
            return false;
        }
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = dp(s1, s2, s3);
        return dp[s1.length()][s2.length()];
    }

    /**
     * 状态数组
     * @param s1 字符串1
     * @param s2 字符串2
     * @param s3 字符串3
     * @return dp[i][j]，表示s1[0...i]与s2[0...j]能否交替组成s3[0...i+j+1]
     */
    private boolean[][] dp(String s1, String s2, String s3) {
        boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
        if (s3.length() == 0){
            res[0][0] = true;
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)){
                res[0][i] = true;
            }else {
                break;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)){
                res[i][0] = true;
            }else {
                break;
            }
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                //s3[i+j+1]既不是s1[i]，也不是s2[j]，直接下一个
                if (s3.charAt(i + j + 1) != s1.charAt(i) && s3.charAt(i + j + 1) != s2.charAt(j)){
                    continue;
                } 
                //s1[i]==s3[i+j+1], 依赖res[i-1][j]
                if (s1.charAt(i) == s3.charAt(i + j + 1)){
                    res[i][j] = res[i - 1][j];
                }
                //s1的情况失败，则尝试res[i][j-1]
                if (!res[i][j] && s2.charAt(j) == s3.charAt(i + j + 1)){
                    res[i][j] = res[i][j - 1];
                }
            }
        }
        return res;
    }
    
}
