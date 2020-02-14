package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.ArrayDeque;

/**
 * 如何仅用队列结构实现栈结构?
 * 如何仅用栈结构实现队列结构?
 */
public class Q010305StackAndQueue {

    private class Stack{
        ArrayDeque<Integer> dataQueue = new ArrayDeque<>();
        ArrayDeque<Integer> helpQueue = new ArrayDeque<>();

        public void push(int val){
            dataQueue.offer(val);
        }

        public int pop(){
            if (dataQueue.isEmpty()){
                throw new RuntimeException("empty!");
            }
            while (dataQueue.size() > 1){
                helpQueue.offer(dataQueue.poll());
            }
            int ans = dataQueue.poll();
            ArrayDeque<Integer> tmp = dataQueue;
            dataQueue = helpQueue;
            helpQueue = tmp;
            return ans;
        }

        public int peek(){
            if (dataQueue.isEmpty()){
                throw new RuntimeException("empty!");
            }
            int ans = 0;
            while (!dataQueue.isEmpty()){
                helpQueue.offer(ans = dataQueue.poll());
            }
            ArrayDeque<Integer> tmp = dataQueue;
            dataQueue = helpQueue;
            helpQueue = tmp;
            return ans;
        }
    }

    private class Queue{
        ArrayDeque<Integer> pushStack = new ArrayDeque<>();
        ArrayDeque<Integer> popStack = new ArrayDeque<>();

        public void offer(int val){
            pushStack.push(val);
        }

        public int poll(){
            if (popStack.isEmpty()){
                while (!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            if (popStack.isEmpty()){
                throw new RuntimeException("empty!");
            }
            return popStack.pop();
        }

        public int peek(){
            if (popStack.isEmpty()){
                while (!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            if (popStack.isEmpty()){
                throw new RuntimeException("empty!");
            }
            return popStack.peek();
        }
    }

}
