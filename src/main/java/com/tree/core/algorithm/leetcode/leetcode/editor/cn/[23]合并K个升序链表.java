package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1898 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        for (ListNode list : lists) {
            heap.offer(list);
        }
        ListNode tmp = new ListNode(), res = tmp;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            tmp.next = node;
            tmp = tmp.next;
            if (node.next != null){
                heap.offer(node.next);
            }
        }
        return res.next;
    }

    public ListNode merge(ListNode[] lists){
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int i, int j) {
        if (i == j){
            return lists[i];
        }
        if (i > j){
            return null;
        }
        int m = (i + j) / 2;
        return merge(merge(lists, i, m), merge(lists, m + 1, j));
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null){
            return n1 == null ? n2 : n1;
        }
        ListNode head = new ListNode(), tail = head;
        while (n1 != null && n2 != null){
            if (n1.val <= n2.val){
                tail.next = n1;
                n1 = n1.next;
            }else {
                tail.next = n2;
                n2 = n2.next;
            }
            tail = tail.next;
        }
        tail.next = n1 != null ? n1 : n2;
        return head.next;
    }

    class ListNode{
        int val;
        ListNode next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
