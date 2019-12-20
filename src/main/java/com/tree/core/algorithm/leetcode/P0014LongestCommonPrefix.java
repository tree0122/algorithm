package com.tree.core.algorithm.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 *
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class P0014LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int k = 0, m = 0;
            while (k < ans.length() && m < strs[i].length() && ans.charAt(k) == strs[i].charAt(m)){
                k++;
                m++;
            }
            if (k == 0){
                return "";
            }
            ans = ans.substring(0, k);
        }
        return ans;
    }

    public String better(String[] strs) {

        if(strs.length == 0)
            return "";
        String ans = strs[0];

        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(ans) !=0){
                ans = ans.substring(0, ans.length() -1);
            }
        }
        return ans;
    }

}
