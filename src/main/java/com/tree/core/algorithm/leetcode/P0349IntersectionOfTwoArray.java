package com.tree.core.algorithm.leetcode;

import java.util.HashSet;

/**
 *
 Given two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 Note:

 Each element in the result must be unique.
 The result can be in any order.
 */
public class P0349IntersectionOfTwoArray {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] a1 = nums1;
        int[] a2 = nums2;
        if (a1.length > a2.length){
            a1 = nums2;
            a2 = nums1;
        }
        HashSet<Integer> set1 = new HashSet<>(a1.length);
        HashSet<Integer> set2 = new HashSet<>(a1.length);
        for (int i : a1) {
            set1.add(i);
        }
        for (int i : a2) {
            if (set1.contains(i)){
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        int j = 0;
        for (Integer i : set2) {
            res[j++] = i;
        }
        return res;
    }

}
