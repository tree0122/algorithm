package com.tree.core.algorithm.leetcode;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 */
public class P0171ExcelSheetColumnNumber {

    public int titleToNumber(String s){
        if (s == null || s.length() < 1){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - 'A' + 1;
            ans = 26 * ans + digit;
        }
        return ans;
    }

}
