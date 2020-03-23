package com.tree.core.algorithm.leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class P0125ValidPalindrome {

    public boolean isPalindrome(String s){
        if (s == null || s.length() <= 1){
            return true;
        }
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j;) {
            while (!check(s.charAt(i))){
                i++;
            }
            while (!check(s.charAt(j))){
                j--;
            }
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    private boolean check(char c){
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

}
