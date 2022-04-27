package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 799 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1; // 子数组起始位置
        int end = -2;// 子数组结束位置
        int mx = nums[0];// nums[0...i]中的最大值
        int mn = nums[nums.length - 1]; // nums[i...len]中的最小值
        for (int i = 1,j = nums.length - 2; i < nums.length - 1; i++, j--) {
            mx = Math.max(mx, nums[i]);
            if (mx > nums[i]){ // 潜台词：num[0...i-1]中有元素大于nums[i]，故i为nums[0...i]中非升序子数组的end下标
                end = i;
            }
            mn = Math.min(mn, nums[j]);
            if (mn < nums[j]){// 潜台词：num[j...len]中有元素小于nums[j]，故j为nums[j...len]中非升序子数组的start下标
                start = j;
            }
        }
        return end - start + 1;
    }

    public int right(int[] a){
        int[] t = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            t[i] = a[i];
        }
        Arrays.sort(t);
        int i = 0, j = a.length - 1;
        while (i <= j && a[i] == t[i]){
            i++;
        }
        while (j > i && a[j] == t[j]){
            j--;
        }
        return j - i + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
