package com.tree.core.algorithm.leetcode;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class P0031NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1){
            return;
        }
        int i = nums.length - 2, j = i + 1;
        while (i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }
        if (i >= 0){
            while (nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        for (int k = i + 1, p = nums.length - 1; k < p; k++, p--) {
            swap(nums, k, p);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
