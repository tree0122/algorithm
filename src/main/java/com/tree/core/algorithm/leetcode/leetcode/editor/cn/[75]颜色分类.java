package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库的sort函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1178 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution75 {
    public void sortColors(int[] nums) {
        /**
         * 循环不变量的定义
         *
         * i 表示数组[0，i)都是0，即i为值0范围的最后一个元素（不包括i）
         * j 表示数组(j，len-1]都是2，即j为值2范围的第一个元素（不包括j）
         * c 表示数组的当前遍历元素，所以 [i,c) 为1，[c, j]待确定
         *
         * all in [0, i) == 0
         * all in [i, c) == 1
         * all in (j, len -1] == 2
         */
        for (int i = 0, j = nums.length - 1, c = 0; c <= j; ) {
            if (nums[c] == 1){
               c++;
            }else if (nums[c] < 1){
                swap(nums, c++, i++);
            }else {
                swap(nums, c, j--);
            }
        }
    }
    private void swap(int[] a, int i, int j){

    }
}
//leetcode submit region end(Prohibit modification and deletion)
