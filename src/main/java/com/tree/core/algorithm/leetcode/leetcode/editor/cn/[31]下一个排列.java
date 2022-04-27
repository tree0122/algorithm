package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1656 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution31 {
    /**
     * 首先从后向前查找第一个顺序对 (i,i+1)(i,i+1)，满足 a[i] < a[i+1]a[i]<a[i+1]。
     * 这样「较小数」即为 a[i]a[i]。此时 [i+1,n)[i+1,n) 必然是下降序列。
     *
     * 如果找到了顺序对，那么在区间 [i+1,n)[i+1,n) 中从后向前查找第一个元素 jj 满足 a[i] < a[j]a[i]<a[j]。
     * 这样「较大数」即为 a[j]a[j]。
     *
     * 交换 a[i]a[i] 与 a[j]a[j]，此时可以证明区间 [i+1,n)[i+1,n) 必为降序。
     * 我们可以直接使用双指针反转区间 [i+1,n)[i+1,n) 使其变为升序，而无需对该区间进行排序
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int smaller = nums.length - 2; //
        while (smaller >= 0 && nums[smaller] >= nums[smaller + 1]){
            smaller--;
        }
        if (smaller >= 0){
            int bigger = nums.length - 1;
            while (bigger >= 0 && nums[bigger] <= nums[smaller]){
                bigger--;
            }
            swap(nums, smaller, bigger);
        }
        reverse(nums, smaller + 1);
    }

    private void reverse(int[] a, int i) {
        int j = a.length - 1;
        while (i < j){
            swap(a, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] a, int i, int j){

    }
}
//leetcode submit region end(Prohibit modification and deletion)
