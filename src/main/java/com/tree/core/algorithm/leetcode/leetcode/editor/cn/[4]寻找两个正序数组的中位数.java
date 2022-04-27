package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 5342 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length)/2;
        int right = (nums1.length + nums2.length + 1)/2;
        int first = findMedianSortedArrays(nums1, nums2, 0, 0, left);
        int second = findMedianSortedArrays(nums1, nums2, 0, 0, right);
        return (first + second) / 2.0;
    }

    private int findMedianSortedArrays(int[] a1, int[] a2, int i, int j, int k) {
        if(i >= a1.length){
            return a2[j + k - 1];
        }
        if(j >= a2.length){
            return a1[i + k - 1];
        }
        if (k == 1){
            return Math.min(a1[i], a2[j]);
        }
        if (a1[i + k / 2 - 1] < a2[j + k / 2 - 1]){
            return findMedianSortedArrays(a1, a2, i + k / 2 + 1, j, k - k / 2);
        }else {
            return findMedianSortedArrays(a1, a2, i, j + k / 2, k - k / 2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
