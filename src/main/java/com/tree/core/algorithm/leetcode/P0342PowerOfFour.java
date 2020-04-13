package com.tree.core.algorithm.leetcode;

import java.util.List;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 */
public class P0342PowerOfFour {

    public boolean isPowerOfFour(int num){
        return num > 0 && ((num - 1) & num) == 0 && (num & 0x55555555) == num ;
    }

}
