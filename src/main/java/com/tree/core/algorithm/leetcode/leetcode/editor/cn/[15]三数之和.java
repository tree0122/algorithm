package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4674 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        // 枚举first
        for (int first = 0; first < nums.length; first++) {
            // 需要和上一次枚举的数不同
            if (first !=0 && nums[first] == nums[first - 1]){
                continue;
            }
            // third初始化为数组的最右端
            int third = nums.length - 1;
            int target = -nums[first];
            // 枚举second， second要在first的右边
            for (int second = first + 1; second < nums.length; second++) {
                // 需要和上一次枚举的数不同
                if (second != first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                //  保证 third 要在 second 的右边
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }
                // second 和 third 重合，则不会出现满足条件的，故直接跳出
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
