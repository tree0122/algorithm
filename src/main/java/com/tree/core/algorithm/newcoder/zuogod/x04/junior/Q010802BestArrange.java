package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一些项目要占用一个会议室宣讲,会议室不能同时容纳两个项目
 * 的宣讲. 给你每一个项目开始的时间和结束的时间(给你一个数
 * 组,里面 是一个个具体的项目),你来安排宣讲的日程,要求会
 * 议室进行 的宣讲的场次最多. 返回这个最多的宣讲场次
 */
public class Q010802BestArrange {

    public int count(Meeting[] m, int begin){
        if (m == null || m.length == 0){
            return 0;
        }
        PriorityQueue<Meeting> heap = new PriorityQueue<>(Comparator.comparingInt(m1 -> m1.end));
        for (Meeting meeting : m) {
            heap.offer(meeting);
        }
        int ans = 0;
        while (!heap.isEmpty()) {
            Meeting p = heap.poll();
            if (begin <= p.start){
                ans++;
                begin = p.end;
            }
        }
        return ans;
    }

    private class Meeting{
        int start;
        int end;
    }

}
