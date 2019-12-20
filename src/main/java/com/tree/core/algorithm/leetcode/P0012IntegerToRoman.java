package com.tree.core.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine,
 * which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: "III"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 4
 * Output: "IV"
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: 9
 * Output: "IX"
 */
public class P0012IntegerToRoman {

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        StringBuilder sb = new StringBuilder();
        LinkedList<String> list = new LinkedList<>();
        int i = 1;
        while (num != 0) {
            int p = num % 10;
            if (p == 4 || p == 9 || p == 1 || p == 5) {
                list.add(map.get(p * i));
            } else {
                String s = "";
                if (p > 5) {
                    s += map.get(5 * i);
                    p = p - 5;
                }
                while (p-- > 0) {
                    s += map.get(i);
                }
                list.add(s);
            }
            i *= 10;
            num /= 10;
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            sb.append(list.get(j));
        }
        return sb.toString();
    }


    public String better(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        int[] vs = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] ss = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < vs.length; i++) {
            while (num >= vs[i]) {
                num -= vs[i];
                sb.append(ss[i]);
            }
        }
        return sb.toString();
    }


}
