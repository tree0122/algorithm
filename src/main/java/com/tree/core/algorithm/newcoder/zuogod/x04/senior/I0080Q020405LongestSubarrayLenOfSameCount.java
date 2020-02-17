package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.HashMap;

/**
 * 元素是只能是{0,1,2}的数组, 其1,2个数相等的最长子数组
 *
 */
public class I0080Q020405LongestSubarrayLenOfSameCount {

    public int maxLen(int[] a){
        if (a == null || a.length <= 1){
            return 0;
        }

        int[] t = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            t[i] = a[i] == 1 ? -1 : a[i] == 2 ? 1 : 0;
        }
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < t.length; i++) {
            sum += t[i];
            if (map.containsKey(sum)){
                len = Math.max(len, i - map.get(sum));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }

    /**
     * 思路:
     * 遍历数组时, 累加和(0~cur) 减去 aim 的结果, 这个结果(0~index)首次出现的位置(index)
     * cur-index (当前位置减去上述位置), 即为当前位置下(cur)找到的目标值最大子数组长度
     *
     * @param a 原数组
     * @param aim 目标值
     * @return 和为aim的子数组中, 最长子数组的长度
     */
    public int maxLen(int[] a, int aim){
        if (a == null || a.length == 0){
            return 0;
        }
        int len = 0; // 结果
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (map.containsKey(sum - aim)){
                len = Math.max(len, i - map.get(sum - aim));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }


}
