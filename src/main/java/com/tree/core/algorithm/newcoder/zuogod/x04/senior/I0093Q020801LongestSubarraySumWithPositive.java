package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 给定一个数组arr,全是正数; 一个整数aim,求累加和等
 * 于aim的,最长子数组,要求额外空间复杂度O(1),时间
 * 复杂度O(N)
 */
public class I0093Q020801LongestSubarraySumWithPositive {

    public int maxLen(int[] a, int aim){
        if (a == null || a.length == 0 || aim <= 0){
            return 0;
        }
        int len = 0;
        for (int j = 0, i = 0, sum = 0; j < a.length;) {
            if (sum == aim){
                len = Math.max(len, j - i + 1);
                sum -= a[i++];
            }else if (sum < aim){
                sum += a[j++];
            }else {
                sum -= a[i++];
            }
        }
        return len;
    }

}
