package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1570 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode n1 = head, n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        n2 = sortList(n2);
        n1 = sortList(head);
        return merge(n1, n2);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode pre = new ListNode(), res = pre;
        while (n1 != null && n2 != null){
            if (n1.val <= n2.val){
                pre.next = n1;
                n1 = n1.next;
            }else {
                pre.next = n2;
                n2 = n2.next;
            }
            pre = pre.next;
        }
        if (n1 != null){
            pre.next = n1;
        }
        if (n2 != null){
            pre.next = n2;
        }
        return res.next;
    }

    class ListNode{
        int val;
        ListNode next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
