package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 问题二(荷兰国旗问题)
 *
 * 给定一个数组arr,和一个数num,请把小于num的数放在数组的
 * 左边,等于num的数放在数组的中间,大于num的数放在数组的
 * 右边。
 *
 * 要求额外空间复杂度O(1),时间复杂度O(N)
 */
public class I0011Q010202NetherlandFlag {

    public int[] part(int[] a, int n){
        if (a == null || a.length <= 1){
            return a;
        }
        int less = -1;
        int more = a.length;
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
