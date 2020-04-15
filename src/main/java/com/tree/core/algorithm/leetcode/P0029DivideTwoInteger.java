package com.tree.core.algorithm.leetcode;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Note:
 * <p>
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class P0029DivideTwoInteger {

    public int divide(int dividend, int divisor) {
        int result = 0;
        if (divisor == 0) //除数为0，返回最大值
            return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return ~dividend;
        }
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);

        while (dividendAbs >= divisorAbs) { //当被除数大于除数时，进行位移操作
            int shiftnum = 0;
            while (dividendAbs >= divisorAbs << shiftnum) {
                shiftnum++;//记录左移次数（比实际次数多1）
            }
            result += 1 << (shiftnum - 1);
            dividendAbs -= divisorAbs << (shiftnum - 1);//更新被除数的值
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) { //计算正负数
            return result;
        } else {
            return -result;
        }
    }

}
