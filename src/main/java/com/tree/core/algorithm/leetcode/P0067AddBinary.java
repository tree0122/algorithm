package com.tree.core.algorithm.leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class P0067AddBinary {

    public String addBinary(String a, String b){
        if (a == null || a.length() == 0){
            return b;
        }
        if (b == null || b.length() == 0){
            return a;
        }
        char zero = '0';
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0){
            int cSum = (a.charAt(i--) - zero) + (b.charAt(j--) - zero) + carry;
            carry = cSum / 2;
            sb.append(cSum % 2);
        }
        while (i >= 0){
            int cSum = a.charAt(i--) - zero + carry;
            carry = cSum / 2;
            sb.append(cSum % 2);
        }
        while (j >= 0){
            int cSum = b.charAt(j--) - zero + carry;
            carry = cSum / 2;
            sb.append(cSum % 2);
        }
        if (carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
