package com.tree.core.algorithm.leetcode;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process
 * until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class P0202HappyNumber {

    public boolean isHappy(int n){
        if (n <= 0){
            return false;
        }
        int sum = 0, digit = 0;
        HashSet<Integer> set = new HashSet<>();
        while (n != 1){
            sum = 0;
            while (n != 0){
                digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
            if (set.contains(n)){
                break;
            }
            set.add(n);
        }
        return n == 1;
    }

    /**
     * 关于非快乐数有个特点，循环的数字中必定会有4，这里就不做证明了
     * @param n
     * @return
     */
    public boolean awesome(int n){
        if (n <= 0){
            return false;
        }
        while (n != 1 && n != 4){
            int sum = 0;
            while (n != 0){
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

}
