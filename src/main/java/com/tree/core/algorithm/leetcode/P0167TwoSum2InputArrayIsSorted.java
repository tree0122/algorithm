package com.tree.core.algorithm.leetcode;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class P0167TwoSum2InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target){
        if (numbers == null || numbers.length <= 1
                || target < numbers[0] + numbers[1]
                || target > numbers[numbers.length - 1] + numbers[numbers.length - 2]){
            return new int[0];
        }
        int i = 0, j = numbers.length - 1, sum = 0;
        while (i < j){
            sum = numbers[i] + numbers[j];
            if (sum == target){
                return new int[]{i, j};
            }else if (sum > target){
                j--;
            }else {
                i++;
            }
        }
        return new int[0];
    }

}
