package com.tree.core.algorithm.leetcode;

import java.util.LinkedList;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 */
public class P0232ImplementQueueUsingStack {

    LinkedList<Integer> stackPush = new LinkedList<>();
    LinkedList<Integer> stackPop = new LinkedList<>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stackPop.isEmpty()){
            return stackPop.pop();
        }
        while (!stackPush.isEmpty()){
            stackPop.push(stackPush.pop());
        }
        return stackPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!stackPop.isEmpty()){
            return stackPop.peek();
        }
        while (!stackPush.isEmpty()){
            stackPop.push(stackPush.pop());
        }
        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }


}
