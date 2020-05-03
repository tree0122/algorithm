package com.tree.core.algorithm.leetcode;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Accepted
 */
public class P0043MultiplyStrings {

    public String multiply(String num1, String num2) {
        int[] vs = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int x = num1.charAt(i) - '0', y = num2.charAt(j) - '0', mul = 0;
                int p1 = i + j, p2 = i + j + 1;
                mul = vs[p2] + x * y;
                vs[p2] = mul % 10;
                vs[p1] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : vs) {
            if (v != 0 || sb.length() > 0){
                sb.append(v);
            }
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }


}
