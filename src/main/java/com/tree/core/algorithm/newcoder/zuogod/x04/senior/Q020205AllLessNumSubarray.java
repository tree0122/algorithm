package com.tree.core.algorithm.newcoder.zuogod.x04.senior;


import java.util.LinkedList;


/**
 * 最大值减去最小值的结果, 小于或等于num的子数组数量
 *
 * 题目:
 * 数组arr和整数num, 共返回有多少个子数组满足如下情况:
 * 1. max(arr[i..j]) - min(arr[i..j]) <= num
 * 2. max(arr[i..j])范围内最大值, min(arr[i..j])范围内最小值
 *
 * 要求: 时间复杂度O(N)
 */
public class Q020205AllLessNumSubarray {

    /**
     * 思路:
     * 窗口[l..r]内的最大值和最小值符合要求,
     * 则[l..r]内的l开头的任何子数组都合要求
     *
     * @param a 数组
     * @param num 目标
     * @return 合要求的子数组个数
     */
    public int getNum(int[] a, int num){
        if (a == null || a.length == 0){
            return 0;
        }
        int res = 0;
        LinkedList<Integer> maxQ = new LinkedList<>();
        LinkedList<Integer> minQ = new LinkedList<>();
        for (int i = 0, j = 0; i < a.length; i++) {
            for (; j < a.length; ) {
                while (!maxQ.isEmpty() && a[maxQ.peekLast()] <= a[j]){
                    maxQ.pollLast();
                }
                maxQ.offer(j);
                while (!minQ.isEmpty() && a[minQ.peekLast()] >= a[j]){
                    minQ.pollLast();
                }
                minQ.offer(j);
                if (a[maxQ.peekFirst()] - a[minQ.peekFirst()] <= num){
                    j++;
                }else {
                    break;
                }
            }
            res += j - i;
            if (i >= maxQ.peekFirst()){
                maxQ.pollFirst();
            }
            if (i >= minQ.peekFirst()){
                minQ.pollFirst();
            }
        }
        return res;
    }

}
