package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.ArrayDeque;

/**
 * 单调栈
 *
 *
 * 数组arr[], 表示一个环形山, 而且每个山上有烽火, 山峰上烽火相互可见规则:
 * 1. 相邻山峰, 可见对方烽火
 * 2. 两山峰不相邻, 两条通往对方山峰路径下, 至少有一条路径上的所有山峰高度 <= Math.min(A, B), 则可见
 *
 * 返回能相互看见山峰, 有多少对
 *
 * 思路:
 * 情况1, 数组arr[]内的元素不重复,
 * 除第一高和第二高的山峰, 其他山峰每个都有两对可以, 第一. 第二高可组成一对, 故结果 2 * (n - 2) + 1 = 2 * n - 3;
 *
 * 情况2, 数组arr[]内的元素可能重复, 单调栈(单调递减)解决
 * 以最高山峰为栈底, 遍历其他山峰,
 *
 */
public class I0074Q020303MountainAndFlame {

    public int pair(int[] a){
        if (a == null || a.length < 2){
            return 0;
        }

        int res = 0;
        int maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            maxIndex = a[maxIndex] > a[i] ? maxIndex : i;
        }
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        int index = maxIndex;
        do {
            while (!stack.isEmpty() && stack.peek().value < a[index]){
                Pair pop = stack.pop();
                res += internalSum(pop.times) + (pop.times << 1);
            }
            if (stack.peek().value == a[index]){
                stack.peek().times++;
            }else {
                stack.push(new Pair(a[index]));
            }
            index = index == a.length - 1 ? 0 : index + 1;
        }while (index != maxIndex);

        while (!stack.isEmpty()){
            if (stack.size() > 2){
                int times = stack.pop().times;
                res += internalSum(times) + (times << 1);
            }else {
                int popTimes = stack.pop().times;
                int maxTimes = stack.pop().times;
                if (maxTimes > 1) { //第二大值的情况
                    res += internalSum(popTimes) + (popTimes << 1)
                            + internalSum(maxTimes);
                }else { //最大值的情况
                    res += internalSum(popTimes) + popTimes;
                }
            }
        }

        return res;
    }

    private int internalSum(int times) {
        return times == 1 ? 0 : times * (times - 1) >> 1;
    }

    private class Pair{
        int value;
        int times;
        Pair(int value){
            this.value = value;
            this.times = 1;
        }
    }

}
