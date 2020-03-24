package com.tree.core.algorithm.leetcode;

import org.junit.Test;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 */
public class P0172FactorialTrailingZeroes {

    public int trailingZeroes(int n){
        int cnt = 0;
        while (n > 0){
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    public int awesome(int n){
        return n == 0 ? 0 : n / 5 + awesome(n / 5);
    }


    @Test
    public void test(){
        System.out.println(trailingZeroes(20));
    }

}
