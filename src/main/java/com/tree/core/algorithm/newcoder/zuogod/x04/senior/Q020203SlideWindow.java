package com.tree.core.algorithm.newcoder.zuogod.x04.senior;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 介绍窗口以及窗口内最大值或最小值的更新结构
 * 具体结构: 左右下标(确定窗口范围)+双端队列(左边踢出, 右边新增)
 */
public class Q020203SlideWindow {

    /**
     * 窗口内最大值更新结构:
     * 用以双端队列记录窗口内最大值的变化
     * 队列左边减数据, 右边加数据
     *
     * @param a 数组
     * @return 一个包含范围最大值的双端队列(队列内元素 单调递减 大->小)
     */
    public Deque<Integer> maxInWindow(int[] a){
        if (a == null || a.length == 0){
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int i = 0;
        int j = a.length - 1;
        while (j < a.length){
            //右边尝试添加新的元素
            while (!queue.isEmpty() && a[queue.peekLast()] <= a[j]){
                queue.pollLast();
            }
            queue.offer(j++);
            //左边尝试剔除过期元素
            if (i > queue.peekFirst()){
                queue.pollFirst();
            }
        }
        return queue;
    }

}
