package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 用数组结构实现大小固定的队列和栈
 */
public class I0017Q010303ArrayToStackQueue {

    private class Stack{
        private int[] a;
        private int idx;

        public Stack(int size){
            a = new int[size];
        }

        public void push(int val){
            if (a.length == idx){
                throw new RuntimeException("stack full !");
            }
            a[idx++] = val;
        }

        public int pop(){
            if (idx == 0){
                throw new RuntimeException("stack empty !");
            }
            return a[--idx];
        }

        public int peek(){
            if (idx == 0){
                throw new RuntimeException("stack empty !");
            }
            return a[idx - 1];
        }
    }

    private class Queue{
        private int[] a;
        private int head;
        private int tail;
        private int size;

        public Queue(int size){
            a = new int[size];
        }

        public void offer(int val){
            if (size == a.length){
                throw new RuntimeException("queue full!");
            }
            a[tail] = val;
            tail = tail == a.length - 1 ? 0 : tail + 1;
            size++;
        }

        public int poll(){
            if (size == 0){
                throw new RuntimeException("queue empty!");
            }
            int ans = a[head];
            head = head == a.length - 1 ? 0 : head + 1;
            size--;
            return ans;
        }

        public int peek(){
            if (size == 0){
                throw new RuntimeException("queue empty!");
            }
            return a[head];
        }
    }

}
