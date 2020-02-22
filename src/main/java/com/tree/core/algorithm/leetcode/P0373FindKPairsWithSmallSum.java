package com.tree.core.algorithm.leetcode;

import java.util.*;

/**
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0373FindKPairsWithSmallSum {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0){
            return new ArrayList<>();
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(nums1.length, Comparator.comparingInt(p -> (nums1[p[0]] + nums2[p[1]])));
        for (int i = 0; i < nums1.length; i++) {
            heap.offer(new int[]{i, 0});
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int[] cur = null;
        while (!heap.isEmpty() && k > 0){
            cur = heap.poll();
            if (cur[1] + 1 < nums2.length){
                heap.offer(new int[]{cur[0], cur[1] + 1});
            }
            ans.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            k--;
        }
        return ans;
    }

}
