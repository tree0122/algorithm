package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.ArrayDeque;

/**
 * 实现一个特殊的栈,在实现栈的基本功能的基础上,再实现返
 * 回栈中最小元素的操作。
 *
 * 【要求】
 * 1.pop、push、getMin操作的时间复杂度都是O(1)。
 * 2.设计的栈类型可以使用现成的栈结构。
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
