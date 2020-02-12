package com.tree.core.algorithm.newcoder.zuogod.x04.junior;


/**
 * 选择排序细节的讲解与复杂度分析
 *
 * 时间复杂度O(N^2),额外空间复杂度O(1)
 */
public class Q010105SelectSort {

    public int[] sort(int[] a){
        if (a == null || a.length <= 1){
            return a;
        }
        for (int i = 0; i < a.length; i++) {
            int idx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[idx] > a[j]){
                    idx = j;
                }
            }
            if (i != idx){
                swap(a, i, idx);
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
