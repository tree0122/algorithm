package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.HashMap;

/**
 * 子数组奇数,偶数个数相等的最长子数组
 *
 */
public class Q020403LongestSubarrayOfEqualParity {

    public int maxLen(int[] a){
        if (a == null || a.length <= 1){
            return 0;
        }
        int[] t = preprocess(a);
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < t.length; i++) {
            sum += a[i];
            Integer pre = map.get(sum);
            if (pre != null){
                len = Math.max(len, i - pre);
            }else {
                map.put(sum, i);
            }
        }
        return len;
    }

    private int[] preprocess(int[] a) {
        int[] t = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            t[i] = (a[i] & 1) == 0 ? -1 : 1;
        }
        return t;
    }


}
