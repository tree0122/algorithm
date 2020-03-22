package com.tree.core.algorithm.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class P0070ClimbingStairs {

    public int climbStairs(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int i = 1, j = 2;
        for (int k = 3, t = 0; k <= n; k++) {
            t = i + j;
            i = j;
            j = t;
        }
        return j;
    }

    public int understand(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return understand(n - 1) + understand(n - 2);
    }

}
