package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 *
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 *
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
 *
 * Example 1:
 *
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation:
 * There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 */
public class P0759EmployeeFreeTime {

    public List<List<Integer>> employeeFreeTime(int[][] schedule){
        if (schedule == null || schedule.length == 0){
            return new ArrayList<>();
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(schedule.length, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        for (int i = 0; i < schedule.length; i++) {
            heap.offer(schedule[i]);
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int preEnd = -1;
        int start = 0;
        while (!heap.isEmpty()){
            int[] poll = heap.poll();
            start = poll[0];
            if (preEnd > 0 && preEnd < start){
                ans.add(Arrays.asList(preEnd, start));
            }
            if (preEnd < poll[1]){
                preEnd = poll[1];
            }
        }
        return ans;
    }

}
