package com.tree.core.algorithm.leetcode;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 *
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 *
 *
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class P0010RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if ((s == null || s.length() == 0) && (p == null || p.length() == 0)){
            return true;
        }
        if ((s == null) && (p != null || p.length() > 0)){
            return false;
        }
        if ((s != null || s.length() > 0) && (p == null || p.length() == 0)){
            return false;
        }
        return process(s, p, 0, 0);
    }

    private boolean process(String s, String p, int i, int j) {
        if (j == p.length()){
            return i == s.length();
        }
        if (j + 1 == p.length() || p.charAt(j + 1) != '*'){
            return i < s.length()
                    && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
                    && process(s, p, i + 1, j + 1);
        }
        while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))){
            if (process(s, p, i, j + 2)){
                return true;
            }
            i++;
        }
        return process(s, p, i, j + 2);
    }



}
