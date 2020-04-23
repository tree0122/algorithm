package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 堆的应用
 *
 * 随时能找到一个stream的中位数
 */
public class I0014Q010205MedianQuick {

    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minQ = new PriorityQueue<>();

    public double median(){
        if (maxQ.isEmpty()) {
            return 0;
        }
        int delta = maxQ.size() - minQ.size();
        if (delta == 0) {
            return (maxQ.peek() + minQ.peek()) / 2.0;
        }else if (delta == 1){
            return maxQ.peek();
        }else {
            return minQ.peek();
        }
    }

    public void insert(int val){
        if (maxQ.isEmpty()){
            maxQ.offer(val);
        }
        if (maxQ.peek() >= val){
            maxQ.offer(val);
        }else {
            minQ.offer(val);
        }
        int delta = maxQ.size() - minQ.size();
        if (delta == 2){
            minQ.offer(maxQ.poll());
        }
        if (delta == -2){
            maxQ.offer(minQ.poll());
        }
    }

}
