package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 👍 1552 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution283 {
    public void moveZeroes(int[] nums) {
        int i = 0, j = i + 1;
        while (j < nums.length){
            while (i < nums.length && nums[i] != 0){
                i++;
            }
            if (j <= i){
                j = i + 1;
            }
            while (j < nums.length && nums[j] == 0){
                j++;
            }
            if (i < nums.length && j < nums.length){
                swap(nums, i++, j++);
            }
        }
    }

    public void best(int[] a){
        int left = 0; //左指针，表示当前已处理好的序列的尾部
        int right = 0; //右指针，表示当前待处理的序列头部
        // 注意，左指针左边均为非零数；右指针左边直到左指针处都是零
        while (right < a.length){
            if (a[right] != 0){
                swap(a, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] a, int i, int j){

    }
}
//leetcode submit region end(Prohibit modification and deletion)
