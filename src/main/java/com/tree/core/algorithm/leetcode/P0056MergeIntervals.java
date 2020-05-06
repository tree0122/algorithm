package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class P0056MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{};
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        for (int[] interval : intervals) {
            heap.offer(interval);
        }
        List<int[]> list = new ArrayList<>();
        int[] cur = heap.poll();
        int start = cur[0], end = cur[1];
        while (!heap.isEmpty()){
            cur = heap.poll();
            if (cur[0] <= end){
                end = Math.max(end, cur[1]);
            }else {
                list.add(new int[]{start, end});
                start = cur[0];
                end = cur[1];
            }
        }
        if (start <= end){
            list.add(new int[]{start, end});
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int[][] understand(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{};
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        for (int[] interval : intervals) {
            heap.offer(interval);
        }
        List<int[]> list = new ArrayList<>();
        int[] cur = heap.poll();
        list.add(cur);
        while (!heap.isEmpty()){
            cur = heap.poll();
            int[] pre = list.get(list.size() - 1);
            if (cur[0] <= pre[1]){
                pre[1] = Math.max(pre[1], cur[1]);
            }else {
                list.add(cur);
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
