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
public class Q010304GetMinStack {

    ArrayDeque<Integer> dataStack = new ArrayDeque<>();
    ArrayDeque<Integer> minStack = new ArrayDeque<>();

    public void push(int val){
        dataStack.push(val);
        if (minStack.isEmpty()){
            minStack.push(val);
        }else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public Integer pop(){
        if (dataStack.isEmpty()){
            return null;
        }
        minStack.pop();
        return dataStack.pop();
    }

    public Integer peek(){
        if (dataStack.isEmpty()){
            return null;
        }
        return dataStack.peek();
    }

    public Integer min(){
        return minStack.peek();
    }

}
