package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1505 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        subsets(nums, res, 0, new LinkedList<Integer>());
        return res;
    }

    private void subsets(int[] a, List<List<Integer>> res, int i, List<Integer> list) {
        if (i == a.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(a[i]);
        subsets(a, res, i + 1, list);
        list.remove(list.size() - 1);
        subsets(a, res, i + 1, list);
    }

    private void other(int[] a, List<List<Integer>> res, int i, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int k = i; k < a.length; k++) {
            list.add(a[k]);
            other(a, res, k + 1, list);
            list.remove(list.size() - 1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
