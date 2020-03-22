package com.tree.core.algorithm.leetcode;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class P0060PlusOne {

    public int[] plusOne(int[] digits){
        if (digits == null || digits.length == 0){
            return new int[]{1};
        }
        if (digits[digits.length - 1] < 9){
            digits[digits.length - 1]++;
            return digits;
        }

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int other = i == digits.length - 1 ? 1 : 0;
            digits[i] += (other + carry);
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if (carry > 0){
            int[] tmp = new int[digits.length + 1];
            tmp[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                tmp[i + 1] = digits[i];
            }
            digits = tmp;
        }
        return digits;
    }

}
