package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 归并排序的应用
 *
 * 小和问题和逆序对问题
 *
 * 小和问题
 * 在一个数组中,每一个数左边比当前数小的数累加起来,叫做这个数组的小和. 求一个数组的小和.
 *
 * 例子:
 * [1,3,4,2,5]
 * 1左边比1小的数,没有;
 * 3左边比3小的数,1;
 * 4左边比4小的数,1、3;
 * 2左边比2小的数,1;
 * 5左边比5小的数,1、3、4、2;
 * 所以小和为1+1+3+1+1+3+4+2=16
 *
 * 逆序对问题
 * 在一个数组中,左边的数如果比右边的数大,则折两个数构成一个逆序对,请打印所有逆序
 */
public class Q010109SmallSum {

    public int sum(int[] a){
        if (a == null || a.length <= 1){
            return 0;
        }
        int[] t = new int[a.length];
        return process(a, 0, a.length - 1, t);
    }

    private int process(int[] a, int l, int r, int[] t) {
        if (l < r){
            int m = (l + r) >> 1;
            int left = process(a, l, m, t);
            int right = process(a, m + 1, r, t);
            int s = merge(a, l, m, r, t);
            return left + right + s;
        }
        return 0;
    }

    private int merge(int[] a, int l, int m, int r, int[] t) {
        int i = l;
        int j = m + 1;
        int k = l;
        int sum = 0;
        while (i <= m && j <= r){
            if (a[i] < a[j]){
                sum += a[i] * (r - j + 1);
            }
            t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        }
        while (i <= m){
            t[k++] = a[i++];
        }
        while (j <= r){
            t[k++] = a[j++];
        }
        while (l <= r){
            a[l] = t[l++];
        }
        return sum;
    }

}
