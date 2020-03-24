package com.tree.core.algorithm.leetcode;

/**
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 */
public class P0191NumberOfOneBits {

    public int hammingWeight(int n){
        int ans = 0;
        for (int i = 31; i != -1; i--) {
            if ((n & 1) == 1) {
                ans++;
            }
            n >>>= 1;
        }
        return ans;
    }

    public int awesome(int n){
        int cnt = 0;
        while (n != 0){
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

}
