package com.tree.core.algorithm.newcoder.zuogod.x04.junior;


/**
 * 插入排序细节的讲解与复杂度分析
 *
 * 时间复杂度O(N^2),额外空间复杂度O(1)
 */
public class Q010106InsertSort {

    public int[] sort(int[] a){
        if (a == null || a.length <= 1){
            return a;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
        return a;
    }

    private void swap(int[] a, int i, int j){
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
