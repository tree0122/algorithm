package com.tree.core.algorithm.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class P0004MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)){
            return 0;
        }
        int[] n1 = nums1;
        int[] n2 = nums2;
        int tLen = nums1.length + nums2.length;
        int mid = (tLen - 1) >> 1;
        boolean odd = (tLen & 1) == 0;
        int idx = 0;
        int i = 0, j = 0;
        int t = 0;
        int t1 = 0;
        while (i < n1.length && j < n2.length){
            t = n1[i] <= n2[j] ? n1[i++] : n2[j++];
            if (idx++ == mid){
                if (odd){
                    if (i == n1.length){
                        t1 = n2[j];
                    }else if (j == n2.length){
                        t1 = n1[i];
                    }else {
                        t1 = Math.min(n1[i], n2[j]);
                    }
                    return (t + t1) / 2.0;
                }
                return t;
            }
        }
        while (i < n1.length){
            t = n1[i++];
            if (idx++ == mid){
                if (odd){
                    t1 = n1[i];
                    return (t + t1) / 2.0;
                }
                return t;
            }
        }
        while (j < n2.length){
            t = n2[j++];
            if (idx++ == mid){
                if (odd){
                    t1 = n2[j];
                    return (t + t1) / 2.0;
                }
                return t;
            }
        }
        return 0;
    }

}
