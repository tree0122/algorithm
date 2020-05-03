package com.tree.core.algorithm.leetcode;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 */
public class P0044WildcardMatch {

    public boolean isMatch(String s, String p) {
        return dp(s, p);
    }


    private boolean dp(String s, String p) {
        boolean[][] d = new boolean[s.length() + 1][p.length() + 1];
        d[0][0] = true;
        for (int i = 1; i < d[0].length; i++) {
            if (p.charAt(i - 1) == '*') {
                d[0][i] = d[0][i - 1];
            }
        }
        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d[0].length; j++) {
                if (p.charAt(j - 1) == '*'){
                    d[i][j] = d[i][j - 1] || d[i - 1][j];
                }else {
                    d[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && d[i - 1][j - 1];
                }
            }
        }
        return d[s.length()][p.length()];
    }

}
