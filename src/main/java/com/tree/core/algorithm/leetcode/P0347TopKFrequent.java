package com.tree.core.algorithm.leetcode;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0347TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, Comparator.comparingInt(i1 -> i1[1]));
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k){
                heap.offer(new int[]{entry.getKey(), entry.getValue()});
            }else if (entry.getValue() > heap.peek()[1]){
                heap.poll();
                heap.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(k);
        while (!heap.isEmpty()){
            ans.add(heap.poll()[0]);
        }
        return ans;
    }

}
