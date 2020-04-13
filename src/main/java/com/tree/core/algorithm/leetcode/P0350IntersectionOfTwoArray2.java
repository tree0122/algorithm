package com.tree.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */
public class P0350IntersectionOfTwoArray2 {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] a1 = nums1;
        int[] a2 = nums2;
        if (a1.length > a2.length){
            a1 = nums2;
            a2 = nums1;
        }
        HashMap<Integer, Integer> map = new HashMap<>(a1.length);
        for (int n : a1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : a2) {
            Integer count = map.getOrDefault(n, 0);
            if (count > 0){
                list.add(n);
                map.put(n, count - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
