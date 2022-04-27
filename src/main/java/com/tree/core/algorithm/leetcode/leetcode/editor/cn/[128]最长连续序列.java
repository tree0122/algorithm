package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 1221 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int len = 0;
        for (int num : nums) {
            int i = 0, j = 0;
            len = 1;
            while (set.contains(num - i)){
                i--;
            }
            while (set.contains(num + j)){
                j++;
            }
            len = Math.max(len, j - i - 1);
        }
        return len;
    }

    public int better(int[] a){
        HashSet<Integer> set = new HashSet<>(a.length);
        for (int i : a) {
            set.add(i);
        }
        int len = 0;
        for (Integer i : set) {
            // 如果已知有一个 x, x+1, x+2, x+y 的连续序列，
            // 而我们却重新从 x+1，x+2 或者是 x+y 处开始尝试匹配，
            // 那么得到的结果肯定不会优于枚举 x 为起点的答案，
            // 因此我们在外层循环的时候碰到这种情况跳过即可

            // 那么怎么判断是否跳过呢？由于我们要枚举的数 x 一定是在数组中不存在前驱数 x−1 的
            if (!set.contains(i - 1)){
                int curLen = 1;
                while (set.contains(i + curLen)){
                    curLen++;
                }
                len = Math.max(len, curLen);
            }
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
