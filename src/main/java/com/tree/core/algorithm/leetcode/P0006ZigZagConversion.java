package com.tree.core.algorithm.leetcode;

import java.util.LinkedList;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 */
public class P0006ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 1){
            return "";
        }
        if (numRows == 1){
            return s;
        }
        boolean down = true;
        LinkedList<Character>[] list = new LinkedList[numRows];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
        for (int i = 0, idx = 0; i < s.length(); i++) {
            list[idx].add(s.charAt(i));
            if (down){
                if (idx == numRows - 1){
                    down = false;
                    idx--;
                }else {
                    idx++;
                }
            }else {
                if (idx == 0){
                    down = true;
                    idx++;
                }else {
                    idx--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Character> l : list) {
            for (Character character : l) {
                sb.append(character);
            }
        }
        return sb.toString();
    }


}
