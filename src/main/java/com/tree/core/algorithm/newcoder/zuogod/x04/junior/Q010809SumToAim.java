package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 一个二维数组, 他的每个数都是正数.
 * 要求从左上角走到右下角, 每一步只能向右或者向下.
 * 沿途经过的数字累加起来, 返回最小的路径和
 */
public class Q010809SumToAim {

    public boolean can(int[] a, int aim){
        if (a == null || a.length == 0){
            return false;
        }
        return process(a, aim, 0, 0);
    }

    private boolean process(int[] a, int aim, int i, int sum) {
        if (i == a.length){
            return aim == sum;
        }
        return process(a, aim, i + 1, sum) || process(a, aim, i + 1, sum + a[i]);
    }

}
