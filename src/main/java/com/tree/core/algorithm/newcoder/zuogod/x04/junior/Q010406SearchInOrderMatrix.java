package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * 在行列都排好序的矩阵中找数
 *
 * 【题目】 给定一个有N*M的整型矩阵matrix和一个整数K,
 * matrix的每一行和每一 列都是排好序的。实现一个函数,判断K
 * 是否在matrix中。 例如: 0 1 2 5 2 3 4 7 4
 * 4 4 8 5 7 7 9 如果K为7,返回true;如果K为6,返
 * 回false。
 * 【要求】 时间复杂度为O(N+M),额外空间复杂度为O(1)。
 */
public class Q010406SearchInOrderMatrix {

    public boolean search(int[][] m, int aim){
        if (m == null || m.length == 0){
            return false;
        }
        int r = 0;
        int c = m[0].length - 1;
        while (r < m.length && c >= 0){
            if (m[r][c] == aim){
                return true;
            }else if (m[r][c] < aim){
                r++;
            }else {
                c--;
            }
        }
        return false;
    }

}
