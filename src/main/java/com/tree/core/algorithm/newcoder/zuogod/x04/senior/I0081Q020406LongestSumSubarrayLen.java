package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.HashMap;

/**
 * 子数组累加和为目标值的最长子数组
 *
 * 给定一个数组arr,和一个整数num,求在arr中,累加和等于num的最长
 * 子数组的长度
 *
 * 例子:
 * arr = {7,3,2,1,1,7,7,7} num = 7
 * 其中有很多的子数组累加和等于7,但是最长的子数组是{3,2,1,1},
 * 所以返回其长度4
 */
public class I0081Q020406LongestSumSubarrayLen {

    public int maxLen(int[] a, int aim){
        if (a == null || a.length < 1){
            return 0;
        }
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            Integer pre = map.get(sum - aim);
            if (pre != null){
                len = Math.max(len, i - pre);
            }else {
                map.put(sum, i);
            }
        }
        return len;
    }


}
