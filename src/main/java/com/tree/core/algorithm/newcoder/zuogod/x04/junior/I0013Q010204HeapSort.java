package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 堆排序的细节和复杂度分析
 *
 * 时间复杂度O(N*logN),额外空间复杂度O(1)
 * 堆结构非常重要
 *
 * 1. 堆结构的heapInsert与heapify
 * 2. 堆结构的增大和减少
 * 3. 如果只是建立堆的过程,时间复杂度为O(N)
 * 4. 优先级队列结构,就是堆结构
 */
public class I0013Q010204HeapSort {

    public int[] sort(int[] a){
        if (a == null || a.length <= 1){
            return a;
        }
        for (int i = 1; i < a.length; i++) {
            heapInsert(a, i);
        }
        for (int i = a.length - 1; i > 0; i--) {
           swap(a, 0, i);
           heapify(a, 0, i);
        }
        return a;
    }

    private void heapify(int[] a, int i, int size) {
        int big = (i >> 1) + 1;
        while (big < size){
            big = big + 1 < size && a[big] < a[big + 1] ? big + 1 : big;
            if (a[big] <= a[i]){
                break;
            }
            swap(a, i, big);
            i = big;
            big = (big >> 1) + 1;
        }
    }

    private void heapInsert(int[] a, int i) {
        int p = (i - 1) >> 1;
        while (p >= 0 && a[i] > a[p]){
            swap(a, i, p);
            i = p;
            p = (p - 1) >> 1;
        }
    }


    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
