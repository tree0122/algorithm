package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 👍 1407 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution169 {
    public int majorityElement(int[] nums) {
        int majority = nums[0]; // 多数元素
        int cn = 0; // 多数元素个数 与 其他所以元素个数 的差
        for (int num : nums) {
            if (cn == 0){
                majority = num;
            }
            if (majority == num){
                cn++;
            }else {
                cn--;
            }
        }
        return majority;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
