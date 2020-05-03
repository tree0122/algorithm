package com.tree.core.algorithm.leetcode;

import java.util.LinkedList;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class P0042TrapRainWater {

    public int trap(int[] height) {
        if (height == null || height.length <= 1){
            return 0;
        }
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; ) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]){
                stack.push(i++);
            }else {
                int pos = stack.pop();
                if (stack.isEmpty()){
                    continue;
                }
                ans += (
                        Math.min(height[stack.peek()], height[i]) // pos的左右最近比pos高的值
                        - height[pos] // pos的高度
                ) * (i - stack.peek() - 1);
            }
        }
        return ans;
    }

    public int best(int[] h){
        int ans = 0;
        for (int i = 0, j = h.length - 1; i < j; ) {
            int low = Math.min(h[i], h[j]);
            if (low == h[i]){
                while (i < j && h[i] <= low){
                    ans += low - h[i++];
                }
            }else {
                while (i < j && h[j] <= low){
                    ans += low - h[j--];
                }
            }
        }
        return ans;
    }

}
