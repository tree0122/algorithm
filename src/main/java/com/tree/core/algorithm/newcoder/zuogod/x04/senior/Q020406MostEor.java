package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.HashMap;

/**
 * 定义数组的异或和的概念:
 * 数组中所有的数异或起来,得到的结果叫做数组的异或和,
 * 比如数组{3,2,1}的异或和是,3^2^1 = 0
 *
 * 给定一个数组arr,你可以任意把arr分成很多不相容的子数组,你的目的是:
 * 分出来的子数组中,异或和为0的子数组最多。
 *
 * 请返回:分出来的子数组中,异或和为0的子数组最多是多少?
 */
public class Q020406MostEor {

    public int maxLen(int[] a){
        if (a == null || a.length < 1){
            return 0;
        }
        int len = 0;
        int eor = 0;
        int[] d = new int[a.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < a.length; i++) {
            eor ^= a[i];
            Integer pre = map.get(eor);
            if (pre != null){
                d[i] = pre == -1 ? 1 : d[pre] + 1;
            }
            if (i > 0 && d[i] < d[i - 1]){
                d[i] = d[i - 1];
            }
            map.put(eor, i);
            len = Math.max(len, d[i]);
        }
        return len;
    }


}
