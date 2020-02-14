package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 给定一个数组arr,和一个数num,请把小于等于num的数放在数
 * 组的左边,大于num的数放在数组的右边。
 *
 * 要求额外空间复杂度O(1),时间复杂度O(N)
 */
public class Q010201Partition {

    public int[] part(int[] a, int n){
        if (a == null || a.length <= 1){
            return a;
        }
        int i = 0;
        int j = a.length - 1;
        while (i < j){
            if (a[i] <= n){
                i++;
            }else {
                swap(a, i, j--);
            }
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
