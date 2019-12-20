package com.tree.core.algorithm.leetcode;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class P0013RomanToInteger {

    public int romanToInt(String s) {
        int ans = 0;
        int[] vs = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] ss = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0, j = 0; i < ss.length; i++) {
            while (startWith(s, j, ss[i])) {
                ans += vs[i];
                j += ss[i].length();
            }
        }
        return ans;
    }

    private boolean startWith(String s, int i, String p) {
        int j = 0;
        while (j < p.length() && i < s.length()){
            if (s.charAt(i) != p.charAt(j)){
                return false;
            }
            j++;
            i++;
        }
        return j == p.length();
    }

}
