package com.tree.core.algorithm.leetcode;

import org.junit.Test;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 */
public class P0767ReorganizeString {

    public String reorganize(String s){
        if (s == null || s.length() == 0){
            return "";
        }
        if (s.length() == 1){
            return s;
        }
        int len = s.length();
        int maxLen = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            maxLen = Math.max(maxLen, ++count[s.charAt(i) - 'a']);
        }
        if (maxLen > (len + 1) >> 1){
            return "";
        }
        char[] ans = new char[len];
        for (int i = 0, even = 0, odd = 1; i < count.length; i++) {
            while (count[i] > 0 && count[i] < (len >> 1) + 1 && odd < len){
                ans[odd] = (char) (i + 'a');
                count[i]--;
                odd += 2;
            }
            while (count[i] > 0){
                ans[even] = (char) (i + 'a');
                count[i]--;
                even += 2;
            }
        }
        return String.valueOf(ans);
    }

    @Test
    public void test(){
        System.out.println(reorganize("aab"));
    }

}
