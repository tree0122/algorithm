package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 给定一个数组arr,值可正,可负,可0;一个整数aim,求累加
 * 和小于等于aim的,最长子数组,要求时间复杂度O(N)
 */
public class Q020803LongestSubarraySumLessAim {

    public int maxLen(int[] a, int aim){
        if (a == null || a.length == 0){
            return 0;
        }
        int len = 0;
        //预处理数据
        //求出a[i-len]的最小累加和,及得到最小累加和时的右边界
        int[] minSums = new int[a.length];
        int[] ends = new int[a.length];
        ends[a.length - 1] = a.length - 1;
        minSums[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i > 0; i--) {
            if (a[i + 1] < 0){
                ends[i] = ends[i + 1];
                minSums[i] = a[i] + minSums[i + 1];
            }else {
                ends[i] = i;
                minSums[i] = a[i];
            }
        }
        for (int i = 0, j = 0, sum = 0; i < a.length; i++) {
            while (j < a.length && minSums[j] + sum <= aim){
                sum += minSums[j];
                j = ends[j] + 1;
            }
            // 潜台词, sums[r] + sum > aim
            len = Math.max(len, j - i);
            if (j > i){
                sum -= a[i];
            }
            if (j < i + 1){
                j = i + 1;
            }
        }
        return len;
    }

}
