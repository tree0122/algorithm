package com.tree.core.algorithm.leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class P0005LongestPalindromicSubstr {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2){
            return s;
        }
        char[] t = prepare(s);
        int maxLen = 0;
        int idx = 0;
        for (int i = 1; i < t.length; i++) {
            int len = 1;
            while (i - len >= 0 && i + len < t.length && t[i - len] == t[i + len]){
                len++;
            }
            if (len > maxLen){
                maxLen = len;
                idx = i;
            }
        }
        int b = (idx - maxLen + 1) >> 1;
        return s.substring(b, b + maxLen - 1);
    }

    public String manacher(String s){
        if (s == null || s.length() < 2){
            return s;
        }
        char[] t = prepare(s);
        int len = 0;
        int idx = 0;
        int[] radius = new int[t.length];
        int c = -1;
        int r = -1;
        for (int i = 0; i < t.length; i++) {
            radius[i] = i >= r ? 1 : Math.min(r - i, radius[2 * c - i]);
            while (i - radius[i] >= 0 && i + radius[i] < t.length &&t[i - radius[i]] == t[i + radius[i]]){
                radius[i]++;
            }
            if (i + radius[i] > r){
                c = i;
                r = i + radius[i];
            }
            if (len < radius[i]){
                len = radius[i];
                idx = i;
            }
        }
        int b = (idx - len + 1) >> 1;
        return s.substring(b, b + len - 1);
    }

    private char[] prepare(String s) {
        char[] ans = new char[s.length() * 2 + 1];
        for (int i = 0, j = 0; i < ans.length; i++) {
            if ((i & 1) == 0){
                ans[i] = '#';
            }else {
                ans[i] = s.charAt(j++);
            }
        }
        return ans;
    }


}
