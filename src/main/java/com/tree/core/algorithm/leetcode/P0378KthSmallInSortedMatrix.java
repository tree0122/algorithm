package com.tree.core.algorithm.leetcode;

import java.util.*;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0378KthSmallInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k){
        if (matrix == null || matrix.length == 0 || k <= 0){
            throw new RuntimeException("null");
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(matrix[0].length, Comparator.comparingInt(n -> n[2]));
        for (int i = 0; i < matrix[0].length; i++) {
            heap.offer(new int[]{0, i, matrix[0][i]});
        }
        int[] t = null;
        while (!heap.isEmpty() && k > 0){
            t = heap.poll();
            if (t[0] + 1 < matrix.length){
                heap.offer(new int[]{t[0] + 1, t[1], matrix[t[0] + 1][t[1]]});
            }
            k--;
        }
        return t[2];
    }

    public int kth(int[][] m, int k){
        int left = m[0][0];
        int right = m[m.length - 1][m[0].length - 1];
        int mid = 0;
        while (left < right){
            mid = (left + right) / 2;
            // 矩阵中 <=mid 的元素总个数
            int count = findLessMid(m, mid, m.length - 1, m[0].length - 1);
            if (count < k){
                // 第k小的数, 在右半部分, 且不包含mid
                left = mid + 1;
            }else {
                // 第k小的数, 在左半部分, 且包含mid
                right = mid;
            }
        }
        return right;
    }

    private int findLessMid(int[][] m, int mid, int r, int c) {
        int count = 0;
        for (int i = r, j = 0; i >= 0 && j <= c;) {
            if (m[i][j] <= mid){
                count += (i + 1);
                j++;
            }else {
                i--;
            }
        }
        return count;
    }

}
