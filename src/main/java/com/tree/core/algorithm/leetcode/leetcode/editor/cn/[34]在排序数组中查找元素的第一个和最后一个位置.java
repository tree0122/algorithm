package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1498 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] r = {-1, -1};
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target){
            return r;
        }
        int i = 0, j = nums.length - 1, m = 0;
        while (i < j){
            m = (i + j)/2;
            if (nums[m] == target){
                j = m;
            }else if (nums[m] < target){
                i = m + 1;
            }else {
                j = m - 1;
            }
        }
        if (nums[m] != target){
            return r;
        }
        r[0] = m;
        i = m;
        j = nums.length - 1;
        while (i < j){
           m = (i + j)/2;
           if (nums[m] == target){
               i = m;
           }else {
               j = m - 1;
           }
        }
        r[1] = m;
        return r;
    }

    public int firstEqual(int[] a, int t){
        int left = 0, right = a.length;
        // 搜索范围 [left, right)
        while (left < right){
            int m = (left + right) / 2;
            if (a[m] == t){
                // 下一次搜索范围 [left, m)
                right = m;
            }else if (a[m] < t){
                // 下一次搜索范围 [m + 1, right)
                left = m + 1;
            }else {
                // 下一次搜索范围 [left, m)
                right = m;
            }
        }
        return left;
    }

    public int lastEqual(int[] a, int t){
        int left = 0, right = a.length;
        // 搜索范围 [left, right)
        while (left < right){
            int m = (left + right) /2;
            if (a[m] == t){
                // 下一次搜索范围 [m + 1, right)
                left = m + 1;
            }else if (a[m] < t){
                // 下一次搜索范围 [m + 1, right)
                left = m + 1;
            }else {
                // 下一次搜索范围 [left, m)
                right = m;
            }
        }
        return left - 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
