package com.tree.core.algorithm.leetcode;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class P0032LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1){
            return 0;
        }
        int ans = 0, pre = 0;
        // d[i]: 表示以s.charAt(i)结尾的最长有效括号子串的长度
        int[] d = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                pre = i - d[i - 1] - 1;
                if (pre >= 0 && s.charAt(pre) == '('){
                    d[i] = d[i - 1] + 2 // d[i-1]: 以s.charAt(i-1)结尾的最长有效子串长度
                            + (pre > 0 ? d[pre - 1] : 0); // d[pre-1]: 以s.charAt(pre-1)结尾的最长有效子串长度
                    ans = Math.max(ans, d[i]);
                }
            }
        }
        return ans;
    }

}
