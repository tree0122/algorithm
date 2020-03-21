package com.tree.core.algorithm.leetcode;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 */
public class P0028ImplementStrstr {

    public int strStr(String haystack, String needle){
        if (haystack == null || needle == null || needle.length() > haystack.length()){
            return -1;
        }
        int[] a = next(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else if (j > 0){
                j = a[j];
            }else {
                i++;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private int[] next(String s) {
        int[] a = new int[s.length()];
        a[0] = -1;
        for (int i = 2, c = 0; i < s.length();) {
            if (s.charAt(i - 1) == s.charAt(c)){
                a[i++] = ++c;
            }else if (c > 0){
                c = a[c];
            }else {
                i++;
            }
        }
        return a;
    }

}
