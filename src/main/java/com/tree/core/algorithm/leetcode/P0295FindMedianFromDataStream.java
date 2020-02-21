package com.tree.core.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 */
public class P0295FindMedianFromDataStream {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHalfHeap = new PriorityQueue<>();
    PriorityQueue<Integer> minHalfHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

    public P0295FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        if(minHalfHeap.isEmpty() || minHalfHeap.peek() > num){
            minHalfHeap.offer(num);
        }else{
            maxHalfHeap.offer(num);
        }
        int delta = minHalfHeap.size() - maxHalfHeap.size();
        if(delta > 1){
            maxHalfHeap.offer(minHalfHeap.poll());
        }else if(delta < -1){
            minHalfHeap.offer(maxHalfHeap.poll());
        }
    }

    public double findMedian() {
        if(minHalfHeap.isEmpty()){
            throw new RuntimeException("empty");
        }
        int delta = minHalfHeap.size() - maxHalfHeap.size();
        if(delta == 0){
            return (minHalfHeap.peek() + maxHalfHeap.peek()) / 2.0;
        }else if(delta == 1){
            return minHalfHeap.peek();
        }else{
            return maxHalfHeap.peek();
        }
    }

}
