package com.tree.core.algorithm.leetcode;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */
public class P0003LSBNoRepeatChar {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int[] d = new int[s.length()];
        d[0] = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            d[i] = 1;
            Integer idx = map.get(s.charAt(i));
            if (idx == null){
                d[i] = d[i - 1] + 1;
            }else {
                d[i] = Math.min(d[i - 1] + 1, i - idx);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, d[i]);
        }
        return ans;
    }

    public int best(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int j = -1; //j表示s遍历到i时,[0 ~ i-1]范围内最近重复元素的位置
        for (int i = 0; i < s.length(); i++) {
            Integer repeatIdx = map.put(s.charAt(i), i); //当前元素重复的位置
            if (repeatIdx != null){
                j = Math.max(repeatIdx, j);
            }
            maxLen = Math.max(maxLen, i - j);
        }

        return maxLen;
    }
}
