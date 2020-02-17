package com.tree.core.algorithm.newcoder.zuogod.x04.senior;


import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 *
 * 题目:
 * 整数数组arr, 大小为W的窗口, 从数组最左边滑到最右边, 窗口每次向右滑到一个位置
 *
 * 返回窗口内最大值的数组
 */
public class I0069Q020204SlideWindowMaxArray {

    public int[] maxWindow(int[] a, int w){
        if (a == null || a.length == 0 || w < 1){
            return null;
        }
        int[] res = new int[a.length - w + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int j = 0;
        while (j < a.length){
            //右边尝试添加新的元素
            while (!queue.isEmpty() && a[queue.peekLast()] <= a[j]){
                queue.pollLast();
            }
            queue.offer(j++);
            //左边尝试剔除过期元素
            if (j - w + 1 > queue.peekFirst()){
                queue.pollFirst();
            }
            if (j + 1 >= w){
                res[j - w + 1] = a[queue.peekFirst()];
            }
        }
        return res;
    }

}
