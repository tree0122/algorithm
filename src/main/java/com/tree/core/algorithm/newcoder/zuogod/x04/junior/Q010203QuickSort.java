package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 随机快速排序的细节和复杂度分析
 * 可以用荷兰国旗问题来改进快速排序
 * 时间复杂度O(N*logN),额外空间复杂度O(logN)
 */
public class Q010203QuickSort {

    public int[] sort(int[] a){
        if (a == null || a.length <= 1){
            return a;
        }
        quick(a, 0, a.length - 1);
        return a;
    }

    private void quick(int[] a, int l, int r) {
        if (l < r){
            int p = (int) (l + Math.random() *  (r - l + 1));
            int[] e = part(a, l, r, a[p]);
            quick(a, l, e[0] - 1);
            quick(a, e[1] + 1, r);
        }
    }

    public int[] part(int[] a, int l, int r, int n) {
        int less = l - 1;
        int more = r + 1;
        for (int i = 0; i < more;) {
            if (a[i] == n){
                i++;
            }else if (a[i] < n){
                swap(a, ++less, i++);
            }else {
                swap(a, i, --more);
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
