package com.tree.core.algorithm.leetcode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class P0344ReverseString {

    public void reverseString(char[] s){
        if (s == null || s.length < 2){
            return;
        }
        char t;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

}
