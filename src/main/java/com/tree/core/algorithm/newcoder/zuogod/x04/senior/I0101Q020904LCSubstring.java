package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 最长公共子串问题
 *
 * 【题目】
 * 给定两个字符串str1和str2,返回两个字符串的最长公共子串。
 *
 * 【举例】
 * str1="1AB2345CD",str2="12345EF",返回"2345"。
 *
 * 【要求】
 * 如果str1长度为M,str2长度为N,实现时间复杂度为O(MN),额
 * 外空间复杂度为O(1)的方法。
 */
public class I0101Q020904LCSubstring {

    public int lcs(String s1, String s2){
        int len = 0;
        int[][] d = new int[s1.length()][s2.length()];
        d[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        if (d[0][0] > len){
            len = d[0][0];
        }
        for (int i = 1; i < s1.length(); i++) {
            d[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : 0;
            if (d[i][0] > len){
                len = d[i][0];
            }
        }
        for (int i = 1; i < s2.length(); i++) {
            d[0][i] = s1.charAt(0) == s2.charAt(i) ? 1 : 0;
            if (d[0][i] > len){
                len = d[0][i];
            }
        }
        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d[0].length; j++) {
                if (s1.charAt(i) == s2.charAt(j)){
                    d[i][j] = d[i - 1][j - 1] + 1;
                }
                if (len < d[i][j]){
                    len = d[i][j];
                }
            }
        }

        return len;
    }

}
