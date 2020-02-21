package com.tree.core.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 */
public class P0215KthLargestInArray {

    /**
     * 堆的思想
     *
     * @return
     */
    public int findKthLargest(int[] nums, int k){
        if (nums == null || nums.length == 0 || k <= 0){
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (heap.peek() < nums[i]) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }

    /**
     * 最右解法 bfprt
     *
     * @param nums
     * @param k
     * @return
     */
    public int bfprt(int[] nums, int k){
        //todo
        return 0;
    }

}
