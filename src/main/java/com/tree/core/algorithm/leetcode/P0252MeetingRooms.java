package com.tree.core.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class P0252MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals){
        PriorityQueue<Integer> heap = new PriorityQueue<>(intervals.length, Comparator.comparingInt(i1 -> intervals[i1][0]));
        for (int i = 0; i < intervals.length; i++) {
            heap.offer(i);
        }
        int preEnd = intervals[heap.poll()][1], start = 0;
        while (!heap.isEmpty()){
            Integer idx = heap.poll();
            start = intervals[idx][0];
            if (preEnd > start){
                return false;
            }
            preEnd = intervals[idx][1];
        }
        return true;
    }

}
