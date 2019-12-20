package com.tree.core.algorithm.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class P0011ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2){
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int leftMax = height[i];
        int rightMax = height[j];
        int ans = 0;
        while (i < j){
            ans = Math.max(ans, (j - i) * Math.min(leftMax, rightMax));
            if (height[i] <= height[j]){
                while (height[i] <= leftMax && i < j){
                    i++;
                }
                if (i == j){
                    break;
                }else {
                    leftMax = height[i];
                }
            }else {
                while (height[j] <= rightMax && j > i){
                    j--;
                }
                if (i == j){
                    break;
                }else {
                    rightMax = height[j];
                }
            }
        }
        return ans;
    }


    public int better(int[] a){
        if (a == null || a.length < 2){
            return 0;
        }
        int max = 0;
        for (int i = 0, j = a.length - 1; i < j; ) {
            int area = 0;
            if (a[i] < a[j]){
                int h = a[i];
                area = (j - i) * h;
                while (i < j && a[i] <= h){
                    i++;
                }
            }else {
                int h = a[j];
                area = (j - i) * h;
                while (i < j && a[j] <= h){
                    j--;
                }
            }
            if (max < area){
                max = area;
            }
        }
        return max;
    }


}
