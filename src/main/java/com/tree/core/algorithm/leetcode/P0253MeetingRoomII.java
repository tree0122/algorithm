package com.tree.core.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 *
 * 方法一：对起始时间进行排序，使用最小堆来记录当前会议的结束时间，当心会议的起始时间大于最小堆中的最早结束时间，说明新会议与堆中的最早结束会议不重叠。
 * ————————————————
 * 版权声明：本文为CSDN博主「jmspan」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/jmspan/article/details/51093343
 */
public class P0253MeetingRoomII {

    /**
     * 堆的思想
     *
     * @return
     */
    public int minMeetingRooms(Interval[] intervals){
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        int rooms = 0;
        PriorityQueue<Interval> sHeap = new PriorityQueue<>(intervals.length, Comparator.comparingInt(i -> i.start));
        PriorityQueue<Integer> eHeap = new PriorityQueue<>();
        for (Interval interval : intervals) {
            sHeap.offer(interval);
        }
        while (!sHeap.isEmpty()){
            Interval cur = sHeap.poll();
            eHeap.offer(cur.end);
            if (cur.start < eHeap.peek()){
                rooms++;
            }else {
                eHeap.poll();
            }
        }
        return rooms;
    }

    private class Interval{
        int start;
        int end;
    }

}
