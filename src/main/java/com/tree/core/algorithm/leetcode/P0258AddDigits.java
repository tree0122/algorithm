package com.tree.core.algorithm.leetcode;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class P0258AddDigits {

    public int addDigits(int num){
        if (num < 10){
            return num;
        }
        int sum = 0;
        while (num > 9){
            sum = 0;
            while (num != 0){
                sum += num % 10;
                sum /= 10;
            }
            num = sum;
        }
        return sum;
    }

    public int awesome(int num){
        return (num == 0) ? 0 : (num - 1) % 9 + 1;
    }

}
