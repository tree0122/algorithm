package com.tree.core.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 */
public class P0225ImplementStackUsingQueue {

    LinkedList<Integer> dataQueue = new LinkedList<>();
    LinkedList<Integer> helpQueue = new LinkedList<>();

    /** Push element x onto stack. */
    public void push(int x) {
        dataQueue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (dataQueue.isEmpty()){
            throw new RuntimeException("no value");
        }
        while (dataQueue.size() > 1){
            helpQueue.offer(dataQueue.poll());
        }
        Integer res = dataQueue.poll();
        LinkedList<Integer> tmp = this.dataQueue;
        dataQueue = helpQueue;
        helpQueue = tmp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        if (dataQueue.isEmpty()){
            throw new RuntimeException("no value");
        }
        Integer res = null;
        while (!dataQueue.isEmpty()){
            helpQueue.offer(res = dataQueue.poll());
        }
        LinkedList<Integer> tmp = this.dataQueue;
        dataQueue = helpQueue;
        helpQueue = tmp;
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return dataQueue.isEmpty();
    }


}
