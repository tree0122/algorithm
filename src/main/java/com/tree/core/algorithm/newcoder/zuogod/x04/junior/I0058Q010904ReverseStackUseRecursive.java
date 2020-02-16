package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.Deque;

/**
 * 有一个栈, 请逆序这个栈.
 * 要求: 不能申请额外的数据结构, 只能使用递归函数
 */
public class I0058Q010904ReverseStackUseRecursive {

    public void reverse(Deque<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        Integer bottom = removeBottom(stack);
        reverse(stack);
        stack.push(bottom);
    }

    private Integer removeBottom(Deque<Integer> stack) {
        Integer pop = stack.pop();
        if (stack.isEmpty()){
            return pop;
        }
        Integer bottom = removeBottom(stack);
        stack.push(pop);
        return bottom;
    }

}
