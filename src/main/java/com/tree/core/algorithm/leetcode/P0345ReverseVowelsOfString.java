package com.tree.core.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class P0345ReverseVowelsOfString {

    public String reverseVowels(String s){
        if (s == null || s.length() < 2){
            return s;
        }
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            while (!set.contains(chars[i]) && i < j){
                i++;
            }
            while (!set.contains(chars[j]) && i < j){
                j--;
            }
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
        return String.valueOf(chars);
    }

}
