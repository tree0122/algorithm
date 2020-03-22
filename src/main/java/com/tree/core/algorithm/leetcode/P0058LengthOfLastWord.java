package com.tree.core.algorithm.leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class P0058LengthOfLastWord {

    public int lengthOfLastWord(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        char space = ' ';
        boolean begin = false;
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != space && !begin){
                begin = true;
            }
            if (begin){
                if (c == space){
                    break;
                }else {
                    len++;
                }
            }
        }
        return len;
    }

}
