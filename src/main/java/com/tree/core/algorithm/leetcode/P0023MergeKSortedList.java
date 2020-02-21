package com.tree.core.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 */
public class P0023MergeKSortedList {

    /**
     * 堆的思想
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        ListNode poll = null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists) {
            if (node != null){
                heap.offer(node);
            }
        }
        while (!heap.isEmpty()){
            poll = heap.poll();
            if (poll.next != null){
                heap.offer(poll.next);
            }
            cur.next = poll;
            cur = cur.next;
        }
        return ans.next;
    }

    /**
     * 归并的思想(分治)
     *
     * @param lists
     * @return
     */
    public ListNode mergeK(ListNode[] lists){
        if (lists == null || lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int i, int j) {
        if (i == j){
            return lists[i];
        }
        int m = (i + j) / 2;
        ListNode left = merge(lists, i, m);
        ListNode right = merge(lists, m + 1, j);
        return merge(left, right);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null){
            return n1 == null ? n2 : n1;
        }
        if (n1.val < n2.val){
            n1.next = merge(n1.next, n2);
            return n1;
        }else {
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }

    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

}
