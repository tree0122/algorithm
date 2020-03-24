package com.tree.core.algorithm.leetcode;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 *
 *
 * Example 1:
 *
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 *
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
 * so return 964176192 which its binary representation is 00111001011110000010100101000000.
 */
public class P0190ReverseBits {

    public int reverseBits(int n){
        int ans = 0;
        for (int i = 31; i != -1; i--) {
            if ((n & 1) == 1) {
                ans |= (1 << i);
            }
            n >>>= 1;
        }
        return ans;
    }

}
