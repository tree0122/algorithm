package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 */
public class P0057InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(intervals.length);
        int cur = 0;
        while (cur < intervals.length && intervals[cur][1] < newInterval[0]){
            list.add(intervals[cur++]);
        }
        while (cur < intervals.length && intervals[cur][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[cur][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[cur++][1], newInterval[1]);
        }
        list.add(newInterval);
        while (cur < intervals.length){
            list.add(intervals[cur++]);
        }
        return list.toArray(new int[][]{});
    }

}
