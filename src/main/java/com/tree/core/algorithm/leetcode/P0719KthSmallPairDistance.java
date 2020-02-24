package com.tree.core.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 *
 * 示例 1:
 *
 * 输入：
 * nums = [1,3,1]
 * k = 1
 * 输出：0
 * 解释：
 * 所有数对如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 * 提示:
 *
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P0719KthSmallPairDistance {

    public int best(int[] nums, int k){
        if (nums == null || nums.length == 0 || k <= 0){
            return -1;
        }
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        while (min < max){
            int mid = (min + max) / 2;
            int count = 0;
            for (int i = 0, j = 0; j < nums.length; j++) {
                while (nums[j] - nums[i] > mid){
                    i++;
                }
                count += j - i;
            }
            if (count < k){
                min = mid + 1;
            }else {
                max = mid;
            }
        }
        return min;
    }

    public int smallestDistancePair(int[] nums, int k){
        if (nums == null || nums.length == 0 || k <= 0){
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int dis = Math.abs(nums[i] - nums[j]);
                if (heap.size() < k){
                    heap.offer(dis);
                }else if (heap.peek() > dis){
                    heap.poll();
                    heap.offer(dis);
                }
            }
        }
        return heap.size() == k ? heap.peek() : -1;
    }

    /*
    public int smallestDistancePair(int[] nums, int k){
        if (nums == null || nums.length == 0 || k <= 0){
            return -1;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                treeSet.add(Math.abs(nums[i] - nums[j]));
                if (treeSet.size() == k + 1){
                    treeSet.remove(treeSet.last());
                }
            }
        }
        return treeSet.size() == k ? treeSet.last() : -1;
    }*/

    @Test
    public void test(){
        int[] a = {1, 6, 1};
        System.out.println(smallestDistancePair(a, 3));
    }

}
