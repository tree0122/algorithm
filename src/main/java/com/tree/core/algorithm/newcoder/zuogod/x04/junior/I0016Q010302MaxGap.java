package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 桶排序、计数排序、基数排序的介绍
 * 1. 非基于比较的排序,与被排序的样本的实际数据状况很有关系,所以实际中并不经常使用
 * 2. 时间复杂度O(N),额外空间复杂度O(N)
 * 3. 稳定的排序
 *
 *
 * 补充问题
 * 给定一个数组,求如果排序之后,相邻两数的最大差值,要求时
 * 间复杂度O(N),且要求不能用非基于比较的排序。
 */
public class I0016Q010302MaxGap {

    public int gap(int[] a){
        if (a == null || a.length == 1){
            return 0;
        }
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            max = max < a[i] ? a[i] : max;
            min = min > a[i] ? a[i] : min;
        }
        int[] xs = new int[a.length + 1];
        int[] ns = new int[a.length + 1];
        boolean[] hs = new boolean[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            int idx = bucketAt(a[i], a.length, max, min);
            xs[idx] = hs[idx] ? Math.max(xs[idx], a[i]) : a[i];
            ns[idx] = hs[idx] ? Math.min(ns[idx], a[i]) : a[i];
            hs[idx] = true;
        }
        int ans = Integer.MIN_VALUE;
        Integer lastMax = null;
        for (int i = 0; i < hs.length; i++) {
            if (hs[i]){
                if (lastMax != null) {
                    ans = Math.max(ans, ns[i] - lastMax);
                }
                lastMax = xs[i];
            }
        }
        return ans;
    }

    private int bucketAt(int val, int length, int max, int min) {
        return (val - min) / (max - min) * length;
    }

}
