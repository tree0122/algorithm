package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 最长递增子序列
 *
 * 【题目】
 * 给定数组arr,返回arr的最长递增子序列。
 *
 * 【举例】
 * arr=[2,1,5,3,6,4,8,9,7],返回的最长递增子序列为
 * [1,3,4,8,9]。
 *
 * 【要求】
 * 如果arr长度为N,请实现时间复杂度为O(NlogN)的方法。
 */
public class Q020902LIS {

    public int[] best(int[] a){
        if (a == null || a.length <= 1){
            return a;
        }
        //e[j]表示, 遍历到a[i]位置时, 在ends[0...right]的有效范围内, 所有长度为(j+1)的最长单调子序列中的最小末尾元素
        int[] e = new int[a.length];
        int[] d = new int[a.length];
        e[0] = a[0];
        d[0] = 1;
        for (int i = 1, right = 0; i < d.length; i++) {
            int l = 0;
            int r = right;
            while (l <= r){
                int m = (l + r) / 2;
                if (a[i] > a[m]){
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            }
            if (right < l){
                right = l;
            }
            e[l] = a[i];
            d[i] = l + 1;
        }
        return generate(a, d);
    }

    public int[] right(int[] a){
        if (a == null || a.length <= 1){
            return a;
        }
        int len = 0;
        int idx = 0;
        int[] d = new int[a.length];
        d[0] = 1;
        for (int i = 1; i < a.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1){
                    d[i] = d[j] + 1;
                }
            }
            if (len < d[i]){
                len = d[i];
                idx = i;
            }
        }
        return generate(a, d);
    }

    private int[] generate(int[] a, int[] d) {
        int len = 0;
        int idx = 0;
        for (int i = 0; i < d.length; i++) {
            if (len < d[i]){
                len = d[i];
                idx = i;
            }
        }
        int[] t = new int[len];
        t[--len] = a[idx];
        for (int i = idx - 1; i >= 0 && len >= 0; i--) {
            if (a[i] < a[idx] && d[i] + 1 == d[idx]){
                t[--len] = a[i];
                idx = i;
            }
        }
        return t;
    }

}
