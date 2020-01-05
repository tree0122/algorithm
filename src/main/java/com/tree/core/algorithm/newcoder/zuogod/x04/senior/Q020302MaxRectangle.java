package com.tree.core.algorithm.newcoder.zuogod.x04.senior;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * 单调栈
 *
 *
 * 求最大子矩阵的大小
 *
 * 给定一个整数矩阵map, 其中的值只有0和1, 求全身1的所有矩阵区域中,
 * 最大的矩形区域为1的数量.
 *
 * 例如:
 * 1 1 1 0
 * 其中, 最大的矩形区域有3个1, 故返回3
 *
 * 再如:
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 其中, 最大的矩形区域有6个1, 故返回6
 */
public class Q020302MaxRectangle {

    public int maxSize(int[][] m){
        if (m == null || m.length == 0){
            return 0;
        }
        int ans = 0;
        int[] t = new int[m[0].length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                t[j] = m[i][j] == 0 ? 0 : t[j] + m[i][j];
                while (!stack.isEmpty() && t[stack.peekLast()] <= t[j]){
                    int pos = stack.pollLast();
                    int pre = stack.isEmpty() ? - 1 : stack.peekLast();
                    ans = Math.max(ans, (j - pre - 1) * t[pos]);
                }
                stack.push(j);
            }
            while (!stack.isEmpty()){
                int pos = stack.pollLast();
                int pre = stack.isEmpty() ? -1 : stack.peekLast();
                ans = Math.max(ans, (pos - pre) * t[pos]);
            }
        }
        return ans;
    }



}
