package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

/**
 * “之”字形打印矩阵
 *
 * 【题目】 给定一个矩阵matrix,按照“之”字形的方式打印这
 * 个矩阵,例如: 1 2 3 4 5 6 7 8 9 10 11 12
 * “之”字形打印的结果为:1,2,5,9,6,3,4,7,10,11,
 * 8,12
 * 【要求】 额外空间复杂度为O(1)。
 */
public class Q010405ZigzagMatrix {

    public void print(int[][] m){
        if (m == null || m.length == 0){
            return;
        }
        int r1 = 0;
        int c1 = 0;
        int r2 = 0;
        int c2 = 0;
        boolean down = false;
        while (r1 < m.length && c1 < m[0].length){
            printEdge(m, r1, c1, r2, c2, down);
            r1 = r1 == m.length - 1 ? r1 : r1 + 1;
            c1 = r1 == m.length - 1 ? c1 + 1 : c1;
            r2 = c2 == m[0].length - 1 ? r2 + 1 : r2;
            c2 = c2 == m[0].length - 1 ? c2 : c2 + 1;
            down = !down;
        }
    }

    private void printEdge(int[][] m, int r1, int c1, int r2, int c2, boolean down) {
        if (down){
            while (r2 <= r1){
                System.out.print(m[r2++][c2--] + " ");
            }
        }else {
            while (c1 <= c2){
                System.out.print(m[r1--][c1++] + " ");
            }
        }
    }

}
