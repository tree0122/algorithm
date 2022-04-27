package com.tree.core.algorithm.leetcode.leetcode.editor.cn;//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1804 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        permute(nums, 0, res);
        return res;
    }

    /**
     *
     * @param a
     * @param i 以i为分界，a的[0,i)已处理，a的[i, len-1]是待处理的
     *          现要处理第i个元素
     * @param res
     */
    private void permute(int[] a, int i, List<List<Integer>> res) {
        // 所有的数都处理完零
        if (i >= a.length){
            List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
            res.add(list);
            return;
        }
        for (int k = i; k < a.length; k++) {
            // 动态维护数组 a的[0,i]已处理，a的(i, len-1]是待处理的
            swap(a, i, k);
            // 递归处理下一个数
            permute(a, i + 1, res);
            // 撤销操作
            swap(a, i, k);
        }
    }

    private void swap(int[] a, int i, int j){

    }
}
//leetcode submit region end(Prohibit modification and deletion)
