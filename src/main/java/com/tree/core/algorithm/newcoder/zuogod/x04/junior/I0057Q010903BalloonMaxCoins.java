package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 给定n个气球, 编号从0至n-1, 每个气球上写了一个数字, 这些数字存放在数组nums中.
 * 现在你来扎破所有的气球. 当扎破第i个气球时, 可以得到的金币个数为nums[left] * nums[i] * nums[right],
 * 这里的left和right指的是第i个气球相邻气球的编号. （当扎破一个气球后, 原来它左右侧的气球将成为相邻气球）.
 *
 * 求通过扎气球可以获得的最大金币数量
 */
public class I0057Q010903BalloonMaxCoins {

    public int best(int[] a){
        //todo
        return 0;
    }

    public int max(int[] a){
        if (a == null || a.length == 0){
            return 0;
        }
        int[] t = new int[a.length + 2];
        t[0] = t[t.length - 1] = 1;
        for (int i = 0; i < a.length; i++) {
            t[i + 1] = a[i];
        }
        return process(t, 1, t.length - 2);
    }

    private int process(int[] a, int i, int j) {
        if (i == j){
            return a[i - 1] * a[i] * a[j + 1];
        }
        int res = 0;
        for (int k = i; k <= j; k++) {
            int left = k == i ? 0 : process(a, i, k - 1);
            int right = k == j ? 0 : process(a, k + 1, j);
            int mid = a[i - 1] * a[j + 1] * a[k];
            res = Math.max(res, left + mid + right);
        }
        return res;
    }

}
