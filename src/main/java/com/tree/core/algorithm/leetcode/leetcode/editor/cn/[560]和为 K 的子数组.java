package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1367 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // 前缀和 和对应的次数
        int sum = 0, cn = 0;
        map.put(sum, 1);
        for (int n : nums) {
            sum += n;
            Integer c = map.getOrDefault(sum - k, 0);
            cn += c;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cn;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
