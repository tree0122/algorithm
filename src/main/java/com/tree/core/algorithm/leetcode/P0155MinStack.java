package com.tree.core.algorithm.leetcode;

import java.util.LinkedList;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class P0155MinStack {
    LinkedList<Integer> dataStack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        }else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
