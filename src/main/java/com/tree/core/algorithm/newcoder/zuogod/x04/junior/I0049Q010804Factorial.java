package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 暴力递归 -> 动态规划
 *
 * 暴力递归:
 * 1. 把问题转化为规模缩小了的同类问题的子问题
 * 2. 有明确的不需要继续进行递归的条件(base case)
 * 3. 有当得到了子问题的结果之后的决策过程
 * 4. 不记录每一个子问题的解
 *
 * 动态规划:
 * 1. 从暴力递归中来
 * 2. 将每一个子问题的解记录下来, 避免重复计算
 * 3. 把暴力递归的规程, 抽象成了状态表达
 * 4. 并且存在化简状态表达, 使其更加简洁的可能
 *
 * 阶乘求解
 */
public class I0049Q010804Factorial {

    public int fac(int n){
        if (n == 1){
            return 1;
        }
        return n * fac(n - 1);
    }

    public int best(int n){
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
}
