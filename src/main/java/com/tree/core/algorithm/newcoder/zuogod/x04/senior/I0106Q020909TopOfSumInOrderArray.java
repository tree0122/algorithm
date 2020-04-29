package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 两个有序数组间相加和的TOP K问题
 *
 * 【题目】
 * 给定两个有序数组arr1和arr2,再给定一个整数k,返回来自
 * arr1和arr2的两个数相加和最大的前k个,两个数必须分别来自
 * 两个数组。
 *
 * 【举例】
 * arr1=[1,2,3,4,5],arr2=[3,5,7,9,11],k=4。
 * 返回数组[16,15,14,14]。
 *
 * 【要求】
 * 时间复杂度达到O(klogk)
 *
 */
public class I0106Q020909TopOfSumInOrderArray {

    public int[] topKSum(int[] a1, int[] a2, int k){
        if (a1 == null || a2 == null){
            return null;
        }
        k = Math.min(k, a1.length * a2.length);
        int[] res = new int[k];
        PriorityQueue<Node> pQueue = new PriorityQueue<>(k + 1, (v1, v2) -> v2.value - v1.value);
        int m = a1.length - 1;
        int n = a2.length - 1;
        pQueue.offer(new Node(m, n, a1[m] + a2[n]));
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            res[i] = pQueue.poll().value;
            if (m > 0 && !set.contains(--m + "_" + n)){
                pQueue.offer(new Node(m, n, a1[m] + a2[n]));
                set.add(m + "_" + n);
            }
            if (n > 0 && !set.contains(m + "_" + --n)){
                pQueue.offer(new Node(m, n, a1[m] + a2[n]));
                set.add(m + "_" + n);
            }
        }
        return res;
    }

    @AllArgsConstructor
    private class Node{
        int index1;
        int index2;
        int value;
    }

}
